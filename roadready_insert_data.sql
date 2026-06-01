-- Demo Data for Simplified RoadReady Car Rental Platform
-- Generated: June 1, 2026

USE roadready_db;

-- ==========================================================
-- 1. Insert Customers
-- ==========================================================
INSERT INTO Customers (name, email, password_hash, phone_number, role) VALUES
('John Doe', 'john.doe@example.com', 'hashed_pass_123', '+1-555-0101', 'CUSTOMER'),
('Jane Smith', 'jane.smith@example.com', 'hashed_pass_456', '+1-555-0102', 'CUSTOMER'),
('Michael Johnson', 'michael.j@example.com', 'hashed_pass_789', '+1-555-0103', 'CUSTOMER'),
('Emily Clark', 'emily.clark@example.com', 'hashed_pass_321', '+1-555-0104', 'CUSTOMER'),
('Robert Wilson', 'robert.w@example.com', 'hashed_pass_654', '+1-555-0105', 'CUSTOMER');

-- ==========================================================
-- 2. Insert Admins
-- ==========================================================
INSERT INTO Admins (name, email, password_hash, phone_number, role) VALUES
('Alice Admin', 'admin@roadready.com', 'hashed_admin_pass', '+1-555-0000', 'ADMIN'),
('Bob Admin', 'bob@roadready.com', 'hashed_admin_pass2', '+1-555-0001', 'ADMIN'),
('Charlie Admin', 'charlie@roadready.com', 'hashed_admin_pass3', '+1-555-0002', 'ADMIN'),
('Diana Admin', 'diana@roadready.com', 'hashed_admin_pass4', '+1-555-0003', 'ADMIN'),
('Ethan Admin', 'ethan@roadready.com', 'hashed_admin_pass5', '+1-555-0004', 'ADMIN');

-- ==========================================================
-- 3. Insert Rental Agents
-- ==========================================================
INSERT INTO RentalAgents (name, email, password_hash, phone_number, role, admin_id) VALUES
('Tom Agent', 'tom@roadready.com', 'hashed_agent_1', '+1-555-1111', 'AGENT', 1),
('Sarah Agent', 'sarah@roadready.com', 'hashed_agent_2', '+1-555-2222', 'AGENT', 2),
('Mike Agent', 'mike@roadready.com', 'hashed_agent_3', '+1-555-3333', 'AGENT', 3),
('Dave Agent', 'dave@roadready.com', 'hashed_agent_4', '+1-555-4444', 'AGENT', 4),
('Lisa Agent', 'lisa@roadready.com', 'hashed_agent_5', '+1-555-5555', 'AGENT', 5);

-- ==========================================================
-- 4. Insert Brands
-- ==========================================================
INSERT INTO Brands (brand_name) VALUES
('Toyota'),
('Honda'),
('Ford'),
('BMW'),
('Tesla');

-- ==========================================================
-- 5. Insert Vehicles
-- ==========================================================
INSERT INTO Vehicles (brand_id, agent_id, model, specifications, pricing_per_day, is_available, image_url, location) VALUES
(1, 1, 'Camry', 'Automatic, Petrol, 5 Seats', 55.00, TRUE, 'camry.jpg', 'Downtown Center, NY'),
(2, 2, 'CR-V', 'Automatic, Hybrid, 5 Seats', 70.00, TRUE, 'crv.jpg', 'Airport Terminal, NY'),
(3, 3, 'Mustang', 'Manual, Petrol, 4 Seats', 95.00, TRUE, 'mustang.jpg', 'Downtown Center, NY'),
(4, 4, '3 Series', 'Automatic, Petrol, 5 Seats', 110.00, TRUE, '3series.jpg', 'Uptown Branch, NY'),
(5, 5, 'Model 3', 'Automatic, Electric, 5 Seats', 85.00, FALSE, 'model3.jpg', 'Airport Terminal, NY');

-- ==========================================================
-- 6. Insert Reservations
-- ==========================================================
INSERT INTO Reservations (customer_id, vehicle_id, pickup_time, dropoff_time, optional_extras, booking_status) VALUES
(1, 1, '2026-06-10 10:00:00', '2026-06-12 10:00:00', 'Child Seat', 'CONFIRMED'),
(2, 5, '2026-06-01 09:00:00', '2026-06-05 09:00:00', 'None', 'ACTIVE'),
(3, 3, '2026-06-15 14:00:00', '2026-06-16 14:00:00', 'GPS', 'PENDING'),
(1, 4, '2026-05-10 08:00:00', '2026-05-12 08:00:00', 'None', 'COMPLETED'),
(4, 2, '2026-04-01 10:00:00', '2026-04-03 10:00:00', 'Extra Insurance', 'COMPLETED'),
(5, 3, '2026-05-15 09:00:00', '2026-05-20 09:00:00', 'None', 'COMPLETED');

-- ==========================================================
-- 7. Insert Payments
-- ==========================================================
-- Reservation 1: 2 days @ 55/day = 110
INSERT INTO Payments (reservation_id, amount, payment_method, payment_status) VALUES
(1, 110.00, 'CREDIT_CARD', 'SUCCESS');

-- Reservation 2: 4 days @ 85/day = 340
INSERT INTO Payments (reservation_id, amount, payment_method, payment_status) VALUES
(2, 340.00, 'PAYPAL', 'SUCCESS');

-- Reservation 3: 1 day @ 95/day = 95
INSERT INTO Payments (reservation_id, amount, payment_method, payment_status) VALUES
(3, 95.00, 'CREDIT_CARD', 'PENDING');

-- Reservation 4: 2 days @ 110/day = 220
INSERT INTO Payments (reservation_id, amount, payment_method, payment_status) VALUES
(4, 220.00, 'DEBIT_CARD', 'SUCCESS');

-- Reservation 5: 2 days @ 70/day = 140
INSERT INTO Payments (reservation_id, amount, payment_method, payment_status) VALUES
(5, 140.00, 'CREDIT_CARD', 'SUCCESS');

-- Reservation 6: 5 days @ 95/day = 475
INSERT INTO Payments (reservation_id, amount, payment_method, payment_status) VALUES
(6, 475.00, 'PAYPAL', 'SUCCESS');

-- ==========================================================
-- 8. Insert Reviews
-- ==========================================================
-- Only putting a review for the COMPLETED reservation (Reservation 4)
INSERT INTO Reviews (reservation_id, rating, comments) VALUES
(4, 5, 'Absolutely loved the BMW! Smooth handover and clean interior.'),
(1, 4, 'Great Camry, but the child seat was a bit hard to install.'),
(2, 5, 'The Model 3 was incredible to drive.'),
(5, 4, 'The CR-V was perfect for our weekend trip.'),
(6, 5, 'Driving a Mustang for 5 days was a dream come true!');
