package com.roadready.dto;

import java.time.LocalDateTime;

public record ReservationResponseDto(
        Integer reservationId,
        Integer customerId,
        Integer vehicleId,
        LocalDateTime pickupTime,
        LocalDateTime dropoffTime,
        String optionalExtras,
        String bookingStatus,
        LocalDateTime createdAt
) {
}
