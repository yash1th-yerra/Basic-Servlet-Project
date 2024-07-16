CREATE DATABASE Register;

use Register;

CREATE TABLE RegisterUser(
name VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
country VARCHAR(255) NOT NULL
);

select * from RegisterUser;

CREATE TABLE CSUser(
userid INT NOT NULL,
username VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
country VARCHAR(255) NOT NULL,
contact INT NOT NULL,
PRIMARY KEY(userid)
);


INSERT INTO CSUser values(1,"yashwanth","Yash1th","yashwanthyashssc@gmail.com","India",9283848267);