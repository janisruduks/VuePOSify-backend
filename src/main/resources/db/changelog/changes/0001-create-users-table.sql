--liquibase formatted sql

--changeset janis:1

CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    role VARCHAR(255),
    created_at TIMESTAMP
);