CREATE TABLE public.user (
     id SERIAL PRIMARY KEY,
     fullname VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL,
     product_id BIGINT,
     order_id BIGINT,
     created_at TIMESTAMP WITH TIME ZONE NOT NULL,
     updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
     FOREIGN KEY (product_id) REFERENCES product(id),
     FOREIGN KEY (order_id) REFERENCES orderp(id)
);
