package com.roadready.service;

import com.roadready.dto.VehicleDto;
import com.roadready.mapper.VehicleMapper;
import com.roadready.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleDto> searchVehicles(String model, BigDecimal maxPrice, String brandName, String location) {
        return vehicleRepository.searchVehicles(model, maxPrice, brandName, location)
                .stream()
                .map(vehicleMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
}
