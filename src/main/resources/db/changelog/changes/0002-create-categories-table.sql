--liquibase formatted sql

--changeset janis:2

CREATE TABLE categories
(
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    user_id INTEGER
);