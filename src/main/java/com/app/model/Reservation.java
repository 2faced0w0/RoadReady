package com.app.model;

import com.app.enums.ReservationStatus;

import java.time.LocalDateTime;

public class Reservation {

    private int id;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime pickup_datetime;
    private LocalDateTime dropoff_datetime;
    private float total_amount;
    private ReservationStatus status;
    private LocalDateTime created_at;

    public Reservation(int id, User user, Vehicle vehicle, LocalDateTime pickup_datetime, LocalDateTime dropoff_datetime, float total_amount, ReservationStatus status, LocalDateTime created_at) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.pickup_datetime = pickup_datetime;
        this.dropoff_datetime = dropoff_datetime;
        this.total_amount = total_amount;
        this.status = status;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getPickup_datetime() {
        return pickup_datetime;
    }

    public void setPickup_datetime(LocalDateTime pickup_datetime) {
        this.pickup_datetime = pickup_datetime;
    }

    public LocalDateTime getDropoff_datetime() {
        return dropoff_datetime;
    }

    public void setDropoff_datetime(LocalDateTime dropoff_datetime) {
        this.dropoff_datetime = dropoff_datetime;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", pickup_datetime=" + pickup_datetime +
                ", dropoff_datetime=" + dropoff_datetime +
                ", total_amount=" + total_amount +
                ", status=" + status +
                ", created_at=" + created_at +
                '}';
    }
}
