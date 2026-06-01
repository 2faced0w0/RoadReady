package com.roadready.repository;

import com.roadready.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("""
            SELECT v FROM Vehicle v 
            WHERE (:model IS NULL OR LOWER(v.model) LIKE LOWER(CONCAT('%', :model, '%'))) 
            AND (:maxPrice IS NULL OR v.pricingPerDay <= :maxPrice) 
            AND (:brandName IS NULL OR LOWER(v.brand.brandName) LIKE LOWER(CONCAT('%', :brandName, '%'))) 
            AND (:location IS NULL OR LOWER(v.location) LIKE LOWER(CONCAT('%', :location, '%')))""")
    List<Vehicle> searchVehicles(@Param("model") String model,
                                 @Param("maxPrice") BigDecimal maxPrice,
                                 @Param("brandName") String brandName,
                                 @Param("location") String location);
}
