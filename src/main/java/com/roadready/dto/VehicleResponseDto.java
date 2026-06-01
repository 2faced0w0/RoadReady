package com.roadready.dto;

public record VehicleResponseDto(
        int vehicleId,
        String brandName,
        String model,
        float pricingPerDay,
        String location
) {
}
