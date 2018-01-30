SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS conferences (
 id int PRIMARY KEY auto_increment,
 topic VARCHAR,
 confDate VARCHAR,
 address VARCHAR,
 instructorId INTEGER,
 sponsorId INTEGER,
 attendeesAverageAge INTEGER,
 attendeesAverageSalary FLOAT,
 womenNumber INTEGER,
 menNumber INTEGER
);

CREATE TABLE IF NOT EXISTS sponsors (
 id int PRIMARY KEY auto_increment,
 companyName VARCHAR,
 website VARCHAR,
 representativeName VARCHAR
);

CREATE TABLE IF NOT EXISTS instructor (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 email VARCHAR,
 phone VARCHAR,
 education VARCHAR,
 currentJob VARCHAR,
);
CREATE TABLE IF NOT EXISTS attendees (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 email VARCHAR,
 phone VARCHAR,
 salary FLOAT,
 birthdate VARCHAR,
 gender VARCHAR,
);
CREATE TABLE IF NOT EXISTS attendees_conferences (
 id int PRIMARY KEY auto_increment,
 conferenceId INTEGER,
 attendeId INTEGER
);