CREATE TABLE public.orderp (
     id SERIAL PRIMARY KEY,
     status VARCHAR(255) NOT NULL,
     created_at TIMESTAMP WITH TIME ZONE NOT NULL
);
