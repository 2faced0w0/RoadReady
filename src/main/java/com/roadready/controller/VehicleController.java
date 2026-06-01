package com.roadready.controller;

import com.roadready.dto.VehicleDto;
import com.roadready.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<VehicleDto>> searchVehicles(
            @RequestParam(required = false) String model,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String brandName,
            @RequestParam(required = false) String location) {
        List<VehicleDto> vehicles = vehicleService.searchVehicles(model, maxPrice, brandName, location);
        return ResponseEntity.ok(vehicles);
    }
}
