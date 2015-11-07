CREATE DATABASE  IF NOT EXISTS `E_FORMATION` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `E_FORMATION`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: E_FORMATION
-- ------------------------------------------------------
-- Server version	5.5.41-0+wheezy1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `COURSE_SESSION`
--

DROP TABLE IF EXISTS `COURSE_SESSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COURSE_SESSION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `COURSE_CODE` varchar(4) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `COURSE_CODE` (`COURSE_CODE`),
  KEY `LOCATION_ID` (`LOCATION_ID`),
  CONSTRAINT `COURSE_SESSION_ibfk_1` FOREIGN KEY (`COURSE_CODE`) REFERENCES `COURSE` (`CODE`),
  CONSTRAINT `COURSE_SESSION_ibfk_2` FOREIGN KEY (`LOCATION_ID`) REFERENCES `LOCATION` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COURSE_SESSION`
--

LOCK TABLES `COURSE_SESSION` WRITE;
/*!40000 ALTER TABLE `COURSE_SESSION` DISABLE KEYS */;
INSERT INTO `COURSE_SESSION` VALUES (1,'2014-10-01','2014-10-31','LO58',2),(2,'2015-11-15','2015-11-30','LO54',1),(3,'2015-12-02','2015-12-30','LO55',2);
/*!40000 ALTER TABLE `COURSE_SESSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COURSE`
--

DROP TABLE IF EXISTS `COURSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COURSE` (
  `CODE` varchar(10) NOT NULL,
  `TITLE` varchar(128) NOT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COURSE`
--

LOCK TABLES `COURSE` WRITE;
/*!40000 ALTER TABLE `COURSE` DISABLE KEYS */;
INSERT INTO `COURSE` VALUES ('LO54','Développez des sites web avec Java EE'),('LO55','Développez votre site web avec le framework Symfony2'),('LO56','Prenez en main Bootstrap'),('LO58','Évoluez vers une architecture PHP professionnelle'),('RE51','Apprenez à naviguer en sécurité sur Internet');
/*!40000 ALTER TABLE `COURSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENT`
--

DROP TABLE IF EXISTS `CLIENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CLIENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LASTNAME` varchar(50) NOT NULL,
  `FIRSTNAME` varchar(50) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `PHONE` varchar(10) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `COURSE_SESSION_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `COURSE_SESSION_ID` (`COURSE_SESSION_ID`),
  CONSTRAINT `CLIENT_ibfk_1` FOREIGN KEY (`COURSE_SESSION_ID`) REFERENCES `COURSE_SESSION` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENT`
--

LOCK TABLES `CLIENT` WRITE;
/*!40000 ALTER TABLE `CLIENT` DISABLE KEYS */;
INSERT INTO `CLIENT` VALUES (1,'MONGA','Achille','6 Rue de Madrid','0633375257','achillemonga@gmail.com',3),(2,'DUPONT','Pierre','24 Rue thier','0642376557','pierre.dupont@gmail.com',3),(3,'YANG','Andre','24 Rue thier','0689756557','andre.yang@gmail.com',3),(4,'PETIT','Aude','8 RUE Ganbetta','0642371023','aude.petit@gmail.com',3);
/*!40000 ALTER TABLE `CLIENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOCATION`
--

DROP TABLE IF EXISTS `LOCATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOCATION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOCATION`
--

LOCK TABLES `LOCATION` WRITE;
/*!40000 ALTER TABLE `LOCATION` DISABLE KEYS */;
INSERT INTO `LOCATION` VALUES (1,'Belfort'),(2,'Paris'),(3,'Annecy'),(4,'Lyon');
/*!40000 ALTER TABLE `LOCATION` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-07 15:02:35
