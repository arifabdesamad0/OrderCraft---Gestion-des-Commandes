CREATE DATABASE IF NOT EXISTS artwood;
USE artwood;

CREATE TABLE IF NOT EXISTS clients (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS items (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     price DECIMAL(10, 2) NOT NULL
);
CREATE TABLE IF NOT EXISTS orders (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      user_id INT,
                                      FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE IF NOT EXISTS order_items (
                                           order_id INT,
                                           item_id INT,
                                           FOREIGN KEY (order_id) REFERENCES orders(id),
                                           FOREIGN KEY (item_id) REFERENCES items(id),
                                           PRIMARY KEY (order_id, item_id)
);
