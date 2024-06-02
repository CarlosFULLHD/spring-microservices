CREATE TABLE IF NOT EXISTS memberships (
                                           id_membership SERIAL PRIMARY KEY,
                                           user_id INT NOT NULL REFERENCES users_db.public.users(id_users) ON DELETE CASCADE,
    type VARCHAR(50) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS membership_features (
                                                   id_feature SERIAL PRIMARY KEY,
                                                   membership_id INT NOT NULL REFERENCES memberships(id_membership) ON DELETE CASCADE,
    feature_name VARCHAR(255) NOT NULL,
    feature_description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
