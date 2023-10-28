--liquibase formatted sql

--changeset janis:4

CREATE TABLE tables
(
    table_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    status varchar(20),
    order_id INTEGER,
    user_id INTEGER
);