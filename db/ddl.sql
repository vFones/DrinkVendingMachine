DROP TABLE person CASCADE;
DROP TABLE product CASCADE;
DROP TABLE purchase CASCADE;

CREATE TABLE product
(
  prod_id SERIAL PRIMARY KEY,
  price FLOAT NOT NULL,
  stock INT NOT NULL,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE person
(
  user_id SERIAL PRIMARY KEY,
  balance FLOAT NOT NULL
);

CREATE TABLE purchase
(
  purchase_id SERIAL PRIMARY KEY,
  user_id INTEGER REFERENCES person(user_id),
  prod_id INTEGER REFERENCES product(prod_id),
  date DATE NOT NULL
);