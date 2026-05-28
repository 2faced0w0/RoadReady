package com.app.dao;

import com.app.model.Reservation;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadReadyDao {

    boolean createReservation(int uid, int vid, String pickup, String dropoff, float amount);

    List<Reservation> viewUserReservations(int uid);

    boolean updateReservationStatus(int updateId, int uid, String status);

    boolean deleteReservation(int rid, int uid);
}
