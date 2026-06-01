package com.roadready.service;

import com.roadready.dto.ReservationRequestDto;
import com.roadready.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    ReservationResponseDto createReservation(ReservationRequestDto requestDTO);
    ReservationResponseDto cancelReservation(Integer reservationId);
    List<ReservationResponseDto> getPastReservations(Integer customerId);
}
