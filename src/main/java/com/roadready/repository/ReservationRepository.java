package com.roadready.repository;

import com.roadready.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservations, Integer> {

}
