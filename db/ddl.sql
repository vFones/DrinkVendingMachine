DROP TABLE product CASCADE;
DROP TABLE purchase CASCADE;
DROP TABLE key CASCADE;


CREATE TABLE product
(
  prod_id SERIAL PRIMARY KEY,
  price FLOAT NOT NULL,
  stock INT NOT NULL,
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
  credit_card BOOLEAN NOT NULL,
  cc_number VARCHAR(16),
  id_key INTEGER REFERENCES key(id_key),

  CHECK (cc_number ~ '\d{16}'),
  CHECK ( (credit_card IS TRUE) OR (cc_number IS NULL)), -- if true than insert
  CHECK ( (credit_card IS FALSE) OR (cc_number IS NOT NULL)), -- if false than NULL
  CHECK ( (cash IS TRUE AND credit_card IS FALSE AND id_key IS NULL) OR
          (cash IS FALSE AND credit_card IS TRUE AND id_key IS NULL) OR
          (cash IS FALSE AND  credit_card IS FALSE AND id_key IS NOT NULL))
);

