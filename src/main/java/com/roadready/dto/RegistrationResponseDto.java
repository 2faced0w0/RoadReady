package com.roadready.dto;

import java.time.LocalDateTime;

public record RegistrationResponseDto(
        Integer reservationId,
        Integer userId,
        Integer vehicleId,
        LocalDateTime pickupDateTime,
        LocalDateTime dropoffDateTime,
        Float totalAmount,
        String reservationStatus
) {
}

