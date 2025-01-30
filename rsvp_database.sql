SELECT "Creating rsvp_database database...";

DROP DATABASE IF EXISTS rsvp_database; 

CREATE DATABASE rsvp_database; 

USE rsvp_database; 

SELECT "Creating rsvp table...";
CREATE TABLE rsvp (

    rsvp_id int AUTO_INCREMENT,

    name varchar(256) NOT NULL, 
    email varchar(256) NOT NULL UNIQUE, 
    phone varchar(256) NOT NULL, 
    confirm_date date NOT NULL, 
    comments varchar(256) NOT NULL,

    CONSTRAINT pk_rsvp_id PRIMARY KEY (rsvp_id)

);

DROP USER IF EXISTS 'day22w'@'%';

CREATE USER 'day22w'@'%' IDENTIFIED BY 'password';
FLUSH PRIVILEGES; 

GRANT ALL PRIVILEGES ON rsvp_database.* TO 'day22w'@'%';
FLUSH PRIVILEGES; 