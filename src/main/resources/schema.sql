DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA public;

CREATE TABLE producer
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR                  NOT NULL,
    address    VARCHAR                  NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE product
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        VARCHAR                  NOT NULL,
    description TEXT                     NOT NULL,
    producer    BIGINT                   NOT NULL REFERENCES producer,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE OR REPLACE VIEW product_view AS -- - SQL-вью
(
SELECT pt.id,
       pt.name,
       pr.id   AS producer_id,
       pr.name AS producer_name
FROM product pt
         JOIN producer pr ON pt.producer = pr.id
    );