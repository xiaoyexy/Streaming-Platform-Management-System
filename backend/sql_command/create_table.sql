-- drop tables
DROP TABLE if exists studio;
DROP TABLE if exists demographic_group;
DROP TABLE if exists show;

-- demographic group
CREATE TABLE demographic_group (
    short_name varchar(45) NOT NULL,
    long_name varchar(45) NOT NULL,
    number_of_account int4 NOT NULL,
    PRIMARY KEY (short_name)
    );

INSERT INTO demographic_group (short_name, long_name, number_of_account) VALUES
      ('dg1', 'demographic_group1', 5),
      ('dg2', 'demographic_group2', 5),
      ('dg3', 'demographic_group3', 5),
      ('dg4', 'demographic_group4', 5),
      ('dg5', 'demographic_group5', 5);

-- studio
CREATE TABLE studio (
       short_name varchar(45) NOT NULL,
       long_name varchar(45) NOT NULL,
       PRIMARY KEY (short_name)
);

-- show
CREATE TABLE show (
      short_name varchar(45) NOT NULL,
      year int2 NOT NULL,
      duration int4 NOT NULL,
      show_type varchar(45) NOT NULL,
      price int8 NOT NULL,
      studio_name varchar(45) NOT NULL,
      PRIMARY KEY (short_name),
      CONSTRAINT studio_short_name
      FOREIGN KEY (studio_name)
      REFERENCES studio (short_name)
    -- ON DELETE CASCADE
    -- ON UPDATE CASCADE
);

CREATE TABLE users (
    id serial PRIMARY KEY ,
    username varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    firstname varchar(20) NOT NULL,
    lastname varchar(20) NOT NULL,
    role varchar(20) NOT NULL
);

INSERT INTO users (id, username, password, firstname, lastname, role) VALUES
(1,'admin','admin','Admin','User','admin'),
(2, 'user', 'user','Normal','User','user');
