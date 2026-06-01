package com.roadready.dto;

import com.roadready.enums.BookingStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservationRequestDto(
        @NotNull(message = "This field is mandatory")
        int customerId,
        @NotNull(message = "This field is mandatory")
        int vehicleId,
        @NotNull(message = "This field is mandatory")
        int vehicleId,
        LocalDateTime pickupTime,
        LocalDateTime dropOffTime,
        String payementMethod

) {
}
