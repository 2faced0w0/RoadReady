package com.app.model;

import com.app.enums.AvailabilityStatus;

import java.time.Instant;

public class Vehicle {

    private int id;
    private Brand brand;
    private String model;
    private String location;
    private String specifications;
    private float pricing_per_day;
    private AvailabilityStatus availabilityStatus;
    private String image_url;
    private Instant created_at;

    public Vehicle(int id, Brand brand, String model, String location, String specifications, float pricing_per_day, AvailabilityStatus availabilityStatus, String image_url, Instant created_at) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.location = location;
        this.specifications = specifications;
        this.pricing_per_day = pricing_per_day;
        this.availabilityStatus = availabilityStatus;
        this.image_url = image_url;
        this.created_at = created_at;
    }

    public Vehicle(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        return "Vehicle{" +
                "id=" + id +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                ", location='" + location + '\'' +
                ", specifications='" + specifications + '\'' +
                ", pricing_per_day=" + pricing_per_day +
                ", availabilityStatus=" + availabilityStatus +
                ", image_url='" + image_url + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
