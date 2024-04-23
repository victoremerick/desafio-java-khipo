CREATE TABLE public.order_product (
     id SERIAL PRIMARY KEY,
     amount NUMERIC NOT NULL,
     product_id BIGINT,
     order_id BIGINT,
     created_at TIMESTAMP WITH TIME ZONE NOT NULL,
     FOREIGN KEY (product_id) REFERENCES product(id),
     FOREIGN KEY (order_id) REFERENCES orderp(id)
);
