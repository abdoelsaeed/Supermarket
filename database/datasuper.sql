DROP DATABASE IF EXISTS supermarket;
CREATE DATABASE supermarket;
USE supermarket;
CREATE TABLE admins( username VARCHAR(30) UNIQUE NOT NULL, password VARCHAR(30) NOT NULL ),
 CREATE TABLE product( id INT(15), name VARCHAR(30), number INT(15), price DOUBLE, type VARCHAR(30), discount INT(15) );
