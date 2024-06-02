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
