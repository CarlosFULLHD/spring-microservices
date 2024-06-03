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

-- memberships
INSERT INTO memberships (user_id, type, start_date, end_date, status, created_at, updated_at) VALUES
(1, 'Premium', '2024-01-01 00:00:00', '2024-12-31 23:59:59', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Basic', '2024-01-01 00:00:00', '2024-06-30 23:59:59', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Premium', '2024-01-01 00:00:00', '2024-12-31 23:59:59', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Basic', '2024-01-01 00:00:00', '2024-06-30 23:59:59', 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- membership_features
INSERT INTO membership_features (membership_id, feature_name, feature_description, created_at, updated_at) VALUES
(1, 'Priority Support', '24/7 priority customer support', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Extended Warranty', 'Extended warranty for all services', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Basic Support', 'Basic customer support', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Priority Support', '24/7 priority customer support', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Basic Support', 'Basic customer support', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
