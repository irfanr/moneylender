-- kill session
SELECT pg_terminate_backend(pg_stat_activity.procpid)
FROM pg_stat_activity
WHERE 
pg_stat_activity.datname IN ( 'moneylender');

-- drop object owned by role
DROP OWNED BY moneylender CASCADE;

-- drop before create
DROP DATABASE IF EXISTS "moneylender";
DROP ROLE IF EXISTS moneylender;

-- create role
CREATE ROLE moneylender LOGIN
  ENCRYPTED PASSWORD 'md51a3246d48af47206517c1fac0d621e97'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

-- create database with owner just created
CREATE DATABASE "moneylender"
WITH OWNER = moneylender
ENCODING = 'UTF8'
TABLESPACE = pg_default
LC_COLLATE = 'en_US.UTF-8'
LC_CTYPE = 'en_US.UTF-8'
CONNECTION LIMIT = -1; 
