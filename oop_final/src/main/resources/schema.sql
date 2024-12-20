CREATE TABLE roles (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role_id INT,
                       FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE subscription_plans (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(100) NOT NULL,
                                    price DECIMAL(10, 2) NOT NULL,
                                    duration_in_days INT NOT NULL
);

CREATE TABLE subscriptions (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               user_id INT,
                               plan_id INT,
                               start_date DATE NOT NULL,
                               end_date DATE NOT NULL,
                               status ENUM('ACTIVE', 'EXPIRED', 'CANCELLED') NOT NULL,
                               FOREIGN KEY (user_id) REFERENCES users(id),
                               FOREIGN KEY (plan_id) REFERENCES subscription_plans(id)
);

CREATE TABLE activity_logs (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               user_id INT,
                               check_in_time TIMESTAMP,
                               check_out_time TIMESTAMP,
                               FOREIGN KEY (user_id) REFERENCES users(id)
);
