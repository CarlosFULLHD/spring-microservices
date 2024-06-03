CREATE TABLE IF NOT EXISTS users (
id_users SERIAL NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
pin_code VARCHAR(8) NOT NULL UNIQUE,
created_at TIMESTAMP NULL DEFAULT current_timestamp,
updated_at TIMESTAMP NULL DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS roles (
id_role SERIAL NOT NULL PRIMARY KEY,
user_role VARCHAR(75) NOT NULL,
description VARCHAR(255) NOT NULL,
status SMALLINT NOT NULL,
created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS roles_users (
id_role_user SERIAL NOT NULL PRIMARY KEY,
user_id INT NOT NULL REFERENCES users(id_users) ON DELETE CASCADE,
role_id INT NOT NULL REFERENCES roles(id_role) ON DELETE CASCADE,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS vehicles (
id_vehicles SERIAL NOT NULL PRIMARY KEY,
users_id INT NOT NULL REFERENCES users(id_users) ON DELETE CASCADE,
license_plate VARCHAR(255) NOT NULL UNIQUE,
car_branch VARCHAR(255) NOT NULL,
car_model VARCHAR(255) NOT NULL,
car_color VARCHAR(255) NOT NULL,
car_manufacturing_date VARCHAR(255) NOT NULL DEFAULT '',
created_at TIMESTAMP NULL DEFAULT current_timestamp,
updated_at TIMESTAMP NULL DEFAULT current_timestamp
);

-- users
INSERT INTO users (name, last_name, email, password, pin_code, created_at, updated_at) VALUES
('Carlos', 'Nina', 'carlos.nina@ucb.edu.bo', 'password_hash1', '1234', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Maria', 'Lopez', 'maria.lopez@ucb.edu.bo', 'password_hash2', '5678', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Juan', 'Perez', 'juan.perez@ucb.edu.bo', 'password_hash3', '9012', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Ana', 'Torres', 'ana.torres@ucb.edu.bo', 'password_hash4', '3456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- roles
INSERT INTO roles (user_role, description, status, created_at) VALUES
('ADMIN', 'Administrator role', 1, CURRENT_TIMESTAMP),
('USER', 'User role', 1, CURRENT_TIMESTAMP);

-- roles_users
INSERT INTO roles_users (user_id, role_id, created_at, updated_at) VALUES
(1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- vehicles
INSERT INTO vehicles (users_id, license_plate, car_branch, car_model, car_color, car_manufacturing_date, created_at, updated_at) VALUES
(1, 'ABC123', 'Toyota', 'Corolla', 'Red', '2018', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'DEF456', 'Honda', 'Civic', 'Blue', '2019', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'GHI789', 'Ford', 'Focus', 'Black', '2020', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'JKL012', 'Chevrolet', 'Malibu', 'White', '2017', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
