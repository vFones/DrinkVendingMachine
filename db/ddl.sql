DROP TABLE purchase CASCADE;
DROP TABLE product CASCADE;
DROP TABLE admin CASCADE;
DROP TABLE key CASCADE;

CREATE TABLE product
(
  prod_id SERIAL PRIMARY KEY,
  price FLOAT NOT NULL,
  stock FLOAT NOT NULL,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE key
(
  id_key  SERIAL PRIMARY KEY,
  balance FLOAT NOT NULL
);

CREATE TABLE purchase
(
  purchase_id SERIAL PRIMARY KEY,
  date DATE NOT NULL,
  prod_id INTEGER REFERENCES product(prod_id),
  cash BOOLEAN NOT NULL,
  cc_number VARCHAR(16),
  id_key INTEGER REFERENCES key(id_key),

  CHECK (cc_number ~ '\d{16}'),
  CHECK ( (cash IS TRUE AND cc_number IS NULL AND id_key IS NULL) OR
          (cash IS FALSE AND cc_number IS NOT NULL AND id_key IS NULL) OR
          (cash IS FALSE AND  cc_number IS NULL AND id_key IS NOT NULL))
);

CREATE TABLE admin
(
  admin_id SERIAL PRIMARY KEY,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(128) NOT NULL,

  CHECK (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$')
);