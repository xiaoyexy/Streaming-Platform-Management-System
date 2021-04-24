-- drop tables
DROP TABLE if exists studio;
DROP TABLE if exists demographic_group;
DROP TABLE if exists show;
DROP TABLE if exists streaming_service;
DROP TABLE if exists show_license_record;
DROP TABLE if exists subscription_record;
DROP TABLE if exists watch_record;


-- demographic group
CREATE TABLE demographic_group (
    short_name varchar(45) NOT NULL,
    long_name varchar(45) NOT NULL,
    number_of_account int4 NOT NULL,
    PRIMARY KEY (short_name)
    );

INSERT INTO demographic_group (short_name, long_name, number_of_account) VALUES
      ('dg1', 'demographic_group1', 100),
      ('dg2', 'demographic_group2', 200),
      ('dg3', 'demographic_group3', 300),
      ('dg4', 'demographic_group4', 400),
      ('dg5', 'demographic_group5', 500);

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
      license_fee int8 NOT NULL,
      studio_name varchar(45) NOT NULL,
      PRIMARY KEY (short_name, year)
);

INSERT INTO show (short_name, year, duration, show_type, license_fee, studio_name) VALUES
    ('s1', 2000, 600, 'movie', 600, 'st1'),
    ('s2', 2000, 600, 'ppv', 600, 'st2');

INSERT INTO studio (short_name, long_name) VALUES
    ('st1', 'studio1'),
    ('st2', 'studio2');

--streaming_service
CREATE TABLE streaming_service (
   short_name varchar(45) NOT NULL,
   long_name varchar(45) NOT NULL,
   subscribe_fee int4
);

INSERT INTO streaming_service (short_name, long_name, subscribe_fee) VALUES
    ('ss1', 'streaming_service_1', 50),
    ('ss2', 'streaming_service_2', 100),
    ('ss3', 'streaming_service_3', 150);

--show_license_record
CREATE TABLE show_license_record (
    streaming_service_short_name varchar(45) NOT NULL,
    show_short_name varchar(45) NOT NULL,
    show_year int4,
    year_month varchar(45) NOT NULL,
    license_fee int4,
    watch_price int4,
    studio_short_name varchar(45) NOT NULL
);

INSERT INTO show_license_record (streaming_service_short_name, show_short_name, show_year, year_month, license_fee, watch_price, studio_short_name) VALUES
    ('ss1', 's1', 2000, '2020-8', 600, 0, 'st1'),
    ('ss1', 's2', 2000, '2020-8', 600, 10, 'st2'),
    ('ss2', 's1', 2000, '2020-8', 600, 0, 'st1'),
    ('ss3', 's2', 2000, '2020-8', 600, 10, 'st2');                                                                                                                                    ;


--subscription_record
CREATE TABLE subscription_record (
    demographic_group_short_name varchar(45) NOT NULL,
    streaming_service_short_name varchar(45) NOT NULL,
    year_month varchar(45) NOT NULL,
    percentage int4,
    subscription_fee int4,
    demongraphic_group_num_of_account int4
);

INSERT INTO subscription_record (demographic_group_short_name, streaming_service_short_name, year_month, percentage, subscription_fee, demongraphic_group_num_of_account) VALUES
    ('dg1', 'ss1', '2020-8', 50, 600, 100),
    ('dg1', 'ss2', '2020-8', 30, 600, 100),
    ('dg2', 'ss3', '2020-8', 50, 600, 200),
    ('dg3', 'ss1', '2020-8', 50, 600, 300);



--watch_record
CREATE TABLE watch_record (
    percentage_of_account varchar(45) NOT NULL,
    demographic_group_short_name varchar(45) NOT NULL,
    show_short_name varchar(45) NOT NULL,
    show_year int4,
    streaming_service_short_name varchar(45) NOT NULL,
    year_month varchar(45) NOT NULL,
    watch_price int4,
    demongraphic_group_num_of_account int4
);

INSERT INTO watch_record (percentage_of_account, demographic_group_short_name, show_short_name, show_year, streaming_service_short_name, year_month, watch_price, demongraphic_group_num_of_account)  VALUES
(50, 'dg1', 's1', 2000, 'ss1', '2020-8', 0, 100),
(50, 'dg1', 's2', 2000, 'ss1', '2020-8', 10, 100),
(50, 'dg2', 's1', 2000, 'ss2', '2020-8', 0, 200),
(50, 'dg3', 's2', 2000, 'ss3', '2020-8', 10, 300);