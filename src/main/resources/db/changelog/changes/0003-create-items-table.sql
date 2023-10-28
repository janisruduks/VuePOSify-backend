--liquibase formatted sql

--changeset janis:3

CREATE TABLE items
(
    item_id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    price DECIMAL,
    description VARCHAR(255),
    image_url TEXT,
    user_id INTEGER,
    category_id SERIAL REFERENCES categories (category_id)
);