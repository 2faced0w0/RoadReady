package com.roadready.repository;

import com.roadready.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("""
        SELECT r 
        FROM Reservation r 
        WHERE r.customer.id = :customerId
        AND r.dropoffTime < CURRENT_TIMESTAMP""")
    List<Reservation> findPastReservationsByCustomerId(@Param("customerId") Integer customerId);
}
