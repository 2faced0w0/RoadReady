package com.app.daoImpl;

import com.app.dao.RoadReadyDao;
import com.app.enums.ReservationStatus;
import com.app.model.Reservation;
import com.app.model.User;
import com.app.model.Vehicle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoadReadyDaoImpl implements RoadReadyDao {

    private final JdbcTemplate jdbcTemplate;

    public RoadReadyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Reservation> mapper(){
        return (rs, num)->{

            User user = new User();
            user.setId(rs.getInt("user_id"));
            Vehicle vehicle = new Vehicle();
            vehicle.setId(rs.getInt("vehicle_id"));

            return new Reservation(
                    rs.getInt("reservation_id"),
                    user,
                    vehicle,
                    rs.getTimestamp("pickup_datetime").toLocalDateTime(),
                    rs.getTimestamp("dropoff_datetime").toLocalDateTime(),
                    rs.getFloat("total_amount"),
                    ReservationStatus.valueOf(rs.getString("status").toUpperCase()),
                    rs.getTimestamp("created_at").toLocalDateTime()
            );
        };
    }

    @Override
    public boolean createReservation(int uid, int vid, String pickup, String dropoff, float amount) {
        String sql = "INSERT INTO reservations (user_id, vehicle_id, pickup_datetime, dropoff_datetime, total_amount, status) VALUES (?, ?, ?, ?, ?, 'PENDING')";
        int rowsAffected = jdbcTemplate.update(sql, uid, vid, pickup, dropoff, amount);
        return rowsAffected > 0;
    }

    @Override
    public List<Reservation> viewUserReservations(int uid) {
        String sql = "SELECT * FROM reservations WHERE user_id = ?";
        return jdbcTemplate.query(sql, mapper(), uid);
    }

    @Override
    public boolean updateReservationStatus(int reservationId, int uid, String status) {
        String sql = "UPDATE reservations SET status = ? WHERE reservation_id = ? AND user_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, status, reservationId, uid);
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteReservation(int reservationId, int uid) {
        String sql = "DELETE FROM reservations WHERE reservation_id = ? AND user_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, reservationId, uid);
        return rowsAffected > 0;
    }
}
