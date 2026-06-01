package com.roadready.dto;

public record VehicleSearchRequest(
        String model,
        float maxPricePerDay,
        String brandName,
        String location
) {
}
