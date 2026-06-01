package com.roadready.service;

import com.roadready.dto.VehicleDto;
import java.math.BigDecimal;
import java.util.List;

public interface VehicleService {
    List<VehicleDto> searchVehicles(String model, BigDecimal maxPrice, String brandName, String location);
}
