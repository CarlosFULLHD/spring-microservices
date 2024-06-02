CREATE TABLE IF NOT EXISTS parkings (
                                        id_par SERIAL NOT NULL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    total_spots INT NOT NULL,
    created_at TIMESTAMP NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP NULL DEFAULT current_timestamp
    );

CREATE TABLE IF NOT EXISTS spots (
                                     id_spots SERIAL NOT NULL PRIMARY KEY,
                                     parking_id INT NOT NULL REFERENCES parkings(id_par) ON DELETE CASCADE,
    spot_number INT NOT NULL UNIQUE,
    status SMALLINT NOT NULL DEFAULT 1, -- 1 para disponible, 0 para ocupado
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
