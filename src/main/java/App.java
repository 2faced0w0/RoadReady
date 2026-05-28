import com.app.config.AppConfig;
import com.app.dao.RoadReadyDao;
import com.app.daoImpl.RoadReadyDaoImpl;
import com.app.model.Reservation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String args[]){
        AnnotationConfigApplicationContext  context=new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner sc=new Scanner(System.in);
        System.out.println(context.getBean(DataSource.class));
        RoadReadyDao userDao=context.getBean(RoadReadyDaoImpl.class);

        System.out.println("=================================");
        System.out.println("   Welcome to RoadReady System   ");
        System.out.println("=================================");

        boolean running=true;
        while(running){
            System.out.println("\n--- Reservation Menu ---");
            System.out.println("1. Create Reservation");
            System.out.println("2. View My Reservations");
            System.out.println("3. Update Reservation Status");
            System.out.println("4. Delete Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            int uid;

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    uid = sc.nextInt();
                    System.out.print("Enter Vehicle ID: ");
                    int vid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Pickup Datetime (YYYY-MM-DD HH:MM:SS): ");
                    String pickup = sc.nextLine();
                    System.out.print("Enter Dropoff Datetime (YYYY-MM-DD HH:MM:SS): ");
                    String dropoff = sc.nextLine();
                    System.out.print("Enter Total Amount: ");
                    float amount = sc.nextFloat();

                    userDao.createReservation(uid, vid, pickup, dropoff, amount);
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    uid = sc.nextInt();
                    List<Reservation> myReservations = userDao.viewUserReservations(uid);
                    if (myReservations == null || myReservations.isEmpty()) {
                        System.out.println("\n[Info] You currently have no reservations.");
                    } else {
                        System.out.println("\n--- Your Reservations ---");
                        for (Reservation res : myReservations) {
                            // Because we used stubs, we get the Vehicle ID via res.getVehicle().getId()
                            System.out.println("Reservation ID: " + res.getId() +
                                    " | Vehicle ID: " + res.getVehicle().getId() +
                                    " | Status: " + res.getStatus() +
                                    " | Pickup: " + res.getPickup_datetime() +
                                    " | Total: ₹" + res.getTotal_amount());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    uid = sc.nextInt();
                    System.out.print("Enter Reservation ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Status (Confirmed/Cancelled): ");
                    String status = sc.nextLine();

                    userDao.updateReservationStatus(updateId, uid, status);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    uid = sc.nextInt();
                    System.out.print("Enter Reservation ID to delete: ");
                    int rid = sc.nextInt();

                    userDao.deleteReservation(rid, uid);
                    break;
                case 5:
                    System.out.println("Exiting System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
        sc.close();
    }
}
