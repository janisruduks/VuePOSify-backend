--liquibase formatted sql

--changeset janis:5

CREATE TABLE orders
(
    order_id SERIAL PRIMARY KEY,
    time_open timestamp,
    time_closed timestamp,
    order_total decimal,
    status varchar(20),
    user_id INTEGER,
    table_id SERIAL REFERENCES tables (table_id)

);