CREATE TABLE IF NOT EXISTS reservations (
                                            id_reservation SERIAL PRIMARY KEY,
                                            users_id INT REFERENCES users_db.public.users(id_users) ON DELETE CASCADE,
    vehicles_id INT REFERENCES users_db.public.vehicles(id_vehicles) ON DELETE CASCADE,
    spots_id INT REFERENCES parking_management_db.public.spots(id_spots) ON DELETE CASCADE,
    scheduled_entry TIMESTAMP NOT NULL,
    scheduled_exit TIMESTAMP NOT NULL,
    actual_entry TIMESTAMP,
    actual_exit TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
