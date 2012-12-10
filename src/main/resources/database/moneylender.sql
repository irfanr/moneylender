-- Sequence: seq_customer

-- DROP SEQUENCE seq_customer;

CREATE SEQUENCE seq_customer
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1236
  CACHE 1;
ALTER TABLE seq_customer
  OWNER TO moneylender;


-- Table: customer

-- DROP TABLE customer;

CREATE TABLE customer
(
  id integer PRIMARY KEY DEFAULT nextval('seq_customer'),
  name character varying(75),
  address character varying(200),
  birth_place character varying(200),
  dob date,
  occupation character varying(50)
)
WITH (
  OIDS=FALSE
);

-- Sequence: seq_loan

-- DROP SEQUENCE seq_loan;

CREATE SEQUENCE seq_loan
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 272
  CACHE 1;
ALTER TABLE seq_loan
  OWNER TO moneylender;


-- Table: loan

-- DROP TABLE loan;

CREATE TABLE loan
(
  id integer PRIMARY KEY DEFAULT nextval('seq_loan'),
  amount double precision,
  customer_id integer REFERENCES customer(id)  
)
WITH (
  OIDS=FALSE
);
