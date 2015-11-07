CREATE database if not exists `E_FORMATION`;
use E_FORMATION;

CREATE TABLE if not exists `LOCATION`(
 `ID` int not null auto_increment,
 `CITY` varchar(50) not null,
 primary key (`ID`)
 );

 CREATE TABLE if not exists `COURSE`(
 `CODE` varchar(10) not null,
 `TITLE` varchar(128) not null,
 primary key (`CODE`)
 );

 CREATE TABLE if not exists `COURSE_SESSION`(
 `ID` int not null AUTO_INCREMENT,
 `START_DATE` date not null,
 `END_DATE` date not null,
 `COURSE_CODE` varchar(4) not null,
 `LOCATION_ID` int not null,
 primary key(`ID`),
 foreign key(COURSE_CODE) references COURSE(CODE),
 foreign key(LOCATION_ID) references LOCATION(ID)
 );

  CREATE TABLE if not exists `CLIENT`(
 `ID` int not null AUTO_INCREMENT,
 `LASTNAME` varchar(50) not null,
 `FIRSTNAME` varchar(50) not null,
 `ADDRESS` varchar(50) not null,
 `PHONE` varchar(10) not null,
 `EMAIL` varchar(50) ,
 `COURSE_SESSION_ID` int not null,
 primary key(`ID`),
 foreign key(COURSE_SESSION_ID) references COURSE_SESSION(ID)
 );
