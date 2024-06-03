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

-- reservations
INSERT INTO reservations (users_id, vehicles_id, spots_id, scheduled_entry, scheduled_exit, actual_entry, actual_exit, status, created_at, updated_at) VALUES
(1, 1, 1, '2024-05-31 08:00:00', '2024-05-31 10:00:00', '2024-05-31 08:10:00', '2024-05-31 10:05:00', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, 3, '2024-05-31 09:00:00', '2024-05-31 12:00:00', '2024-05-31 09:10:00', '2024-05-31 12:05:00', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 3, 5, '2024-05-31 11:00:00', '2024-05-31 13:00:00', '2024-05-31 11:15:00', '2024-05-31 13:05:00', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 4, 7, '2024-05-31 08:30:00', '2024-05-31 10:30:00', '2024-05-31 08:35:00', '2024-05-31 10:25:00', 'COMPLETED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
