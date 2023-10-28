--liquibase formatted sql

--changeset janis:6

CREATE TABLE ordered_items
(
    ordered_items_id SERIAL PRIMARY KEY,
    quantity INTEGER,
    user_id INTEGER,
    order_id INTEGER REFERENCES orders (order_id),
    item_id SERIAL REFERENCES items (item_id)
);