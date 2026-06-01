
-- create database roadready_db;

use roadready_db;

-- 1. Customers Table

CREATE TABLE Customers (

    id INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(50) NOT NULL,

    email VARCHAR(100) UNIQUE NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    phone_number VARCHAR(20) NOT NULL,

    role ENUM('CUSTOMER', 'ADMIN', 'AGENT') DEFAULT 'CUSTOMER',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

-- 2. Admins Table

CREATE TABLE Admins (

    id INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(50) NOT NULL,

    email VARCHAR(100) UNIQUE NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    phone_number VARCHAR(20) NOT NULL,

    role ENUM('CUSTOMER', 'ADMIN', 'AGENT') DEFAULT 'ADMIN',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

-- 3. Rental Agents Table

CREATE TABLE RentalAgents (

    id INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(50) NOT NULL,

    email VARCHAR(100) UNIQUE NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    role ENUM('CUSTOMER', 'ADMIN', 'AGENT') DEFAULT 'AGENT',

    phone_number VARCHAR(20) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

-- 4. Brands Table

CREATE TABLE Brands (

    brand_id INT AUTO_INCREMENT PRIMARY KEY,

    brand_name VARCHAR(50) UNIQUE NOT NULL

);

-- 5. Vehicles Table (Location embedded)

CREATE TABLE Vehicles (

    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,

    brand_id INT NOT NULL,

    model VARCHAR(100) NOT NULL,

    specifications TEXT,

    pricing_per_day DECIMAL(10, 2) NOT NULL,

    is_available BOOLEAN DEFAULT TRUE,

    image_url VARCHAR(255),

    location VARCHAR(255) NOT NULL, -- Replaces the Locations table

    FOREIGN KEY (brand_id) REFERENCES Brands(brand_id) ON DELETE RESTRICT

);

-- 6. Reservations Table (Payment data embedded)

CREATE TABLE Reservations (

    reservation_id INT AUTO_INCREMENT PRIMARY KEY,

    customer_id INT NOT NULL,

    vehicle_id INT NOT NULL,

    pickup_time DATETIME NOT NULL,

    dropoff_time DATETIME NOT NULL,

    optional_extras VARCHAR(255),

    booking_status ENUM('PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED') DEFAULT 'PENDING',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (customer_id) REFERENCES Customers(id) ON DELETE CASCADE,

    FOREIGN KEY (vehicle_id) REFERENCES Vehicles(vehicle_id) ON DELETE RESTRICT

);

-- 6. Payments Table

CREATE TABLE Payments (

    payment_id INT AUTO_INCREMENT PRIMARY KEY,

    reservation_id INT NOT NULL,

    amount DECIMAL(10, 2) NOT NULL,

    payment_method VARCHAR(50) NOT NULL,

    payment_status ENUM('PENDING', 'SUCCESS', 'FAILED') DEFAULT 'PENDING',

    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id) ON DELETE CASCADE

);

-- 7. Reviews Table

CREATE TABLE Reviews (

    review_id INT AUTO_INCREMENT PRIMARY KEY,

    reservation_id INT NOT NULL UNIQUE, 

    rating INT CHECK (rating >= 1 AND rating <= 5),

    comments TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (reservation_id) REFERENCES Reservations(reservation_id) ON DELETE CASCADE

);