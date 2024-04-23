CREATE TABLE public.product (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        value NUMERIC
);

INSERT INTO product (name, value) VALUES ('Product 1', 100000);
INSERT INTO product (name, value) VALUES ('Product 2', 80000);
INSERT INTO product (name, value) VALUES ('Product 3', 1000000);
INSERT INTO product (name, value) VALUES ('Product 4', 10000000);
INSERT INTO product (name, value) VALUES ('Product 5', 500000);
