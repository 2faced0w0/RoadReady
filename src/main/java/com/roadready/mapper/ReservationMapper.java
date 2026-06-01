package com.roadready.mapper;

import com.roadready.dto.ReservationRequestDto;
import com.roadready.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation mapDtoToEntity(ReservationRequestDto reservationRequestDto) {
    Reservation reservation = new Reservation();
    reservation.setBookingStatus(reservationRequestDto.bookingStatus());
    }
}
