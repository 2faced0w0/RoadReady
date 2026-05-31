package com.roadready.model;

import com.roadready.enums.AvailabilityStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Vehicles {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Brands brand;

    @Column(nullable = false)
    private String model;
    private String specifications;

    @Column(nullable = false)
    private float pricing_per_day;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    private String image_url;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant created_at;

    public Vehicles(Brands brand, String model, float pricing_per_day, AvailabilityStatus availabilityStatus, int id) {
        this.brand = brand;
        this.model = model;
        this.pricing_per_day = pricing_per_day;
        this.availabilityStatus = availabilityStatus;
        this.created_at = Instant.from(LocalDateTime.now());
        this.id = id;
    }

    public Vehicles() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public float getPricing_per_day() {
        return pricing_per_day;
    }

    public void setPricing_per_day(float pricing_per_day) {
        this.pricing_per_day = pricing_per_day;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                ", specifications='" + specifications + '\'' +
                ", pricing_per_day=" + pricing_per_day +
                ", availabilityStatus=" + availabilityStatus +
                ", image_url='" + image_url + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
