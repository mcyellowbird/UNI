-- MySQL dump 10.13  Distrib 8.0.18, for Linux (x86_64)
--
-- Host: localhost    Database: csit115
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `EMPLOYEE`
--

DROP TABLE IF EXISTS `EMPLOYEE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EMPLOYEE` (
  `ENUM` decimal(12,0) NOT NULL,
  `FNAME` varchar(50) NOT NULL,
  `INITIALS` varchar(5) DEFAULT NULL,
  `LNAME` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `BLDG` decimal(3,0) NOT NULL,
  `STREET` varchar(50) NOT NULL,
  `SUBURB` varchar(50) NOT NULL,
  `STATE` varchar(30) NOT NULL,
  `ZIPCODE` decimal(4,0) NOT NULL,
  `SALARY` decimal(9,2) NOT NULL,
  `MOBILE` varchar(12) NOT NULL,
  `EMPLOYEE_TYPE` varchar(10) NOT NULL,
  PRIMARY KEY (`ENUM`),
  UNIQUE KEY `EMPLOYEE_CK1` (`FNAME`,`LNAME`,`DOB`),
  UNIQUE KEY `EMPLOYEE_CK2` (`MOBILE`),
  CONSTRAINT `EMPLOYEE_CHECK1` CHECK ((`DOB` <= (sysdate() - 18))),
  CONSTRAINT `EMPLOYEE_CHECK2` CHECK (((`BLDG` > 0) and (`BLDG` < 1000))),
  CONSTRAINT `EMPLOYEE_CHECK3` CHECK ((`STATE` in (_utf8mb4'NSW',_utf8mb4'Queensland',_utf8mb4'Western Australia',_utf8mb4'Victoria',_utf8mb4'South Australia',_utf8mb4'Tasmania',_utf8mb4'NT',_utf8mb4'ACT'))),
  CONSTRAINT `EMPLOYEE_CHECK4` CHECK ((`EMPLOYEE_TYPE` in (_utf8mb4'Full Time',_utf8mb4'Part Time',_utf8mb4'Casual'))),
  CONSTRAINT `EMPLOYEE_CHECK5` CHECK (((`SALARY` > 0) and (`SALARY` < 100000)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE`
--

LOCK TABLES `EMPLOYEE` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE` DISABLE KEYS */;
INSERT INTO `EMPLOYEE` VALUES (1,'John',NULL,'Smith','1970-11-12',42,'Victoria St.','Hurstville','NSW',2456,10000.90,'0412356789','Full Time'),(2,'Peter',NULL,'Taylor','1970-01-12',42,'Victoria St.','Hurstville','NSW',2456,12000.00,'0412356782','Full Time'),(3,'John',NULL,'Doe','1966-03-23',12,'Station St.','Dapto','NSW',2530,12000.00,'0412356729','Full Time'),(4,'John',NULL,'Gray','1988-05-05',16,'Station St.','Dapto','NSW',2530,9000.00,'0412356289','Casual'),(5,'Adam',NULL,'Taylor','1980-01-01',42,'Church St.','City','NSW',2300,8500.00,'0412352789','Full Time'),(6,'Michael',NULL,'Jones','1975-03-05',23,'Waterloo Ave.','Surry Hills','NSW',2502,9500.00,'0412326789','Full Time'),(7,'Frederic',NULL,'Jones','1983-02-28',3,'Victoria St.','Redfern','NSW',2420,9600.00,'0412256789','Full Time'),(8,'Peter',NULL,'O\'Brien','1983-02-28',19,'Lucas Dr.','Horsley','NSW',2530,9900.00,'0422356789','Part Time'),(9,'John',NULL,'Lucas','1966-12-16',20,'Huxley St.','Horsley','NSW',2530,10000.00,'0432356789','Part Time'),(10,'John',NULL,'Fox','1975-10-15',18,'Victoria St.','Hurstville','NSW',2456,11000.00,'0413356789','Full Time'),(11,'Adam',NULL,'Fox','1974-12-13',45,'Victoria St.','Hurstville','NSW',2456,13000.00,'0412336789','Full Time'),(12,'Phillip',NULL,',Cox','1984-12-12',5,'The Avenue','Rockdale','NSW',2300,11500.00,'0412353789','Full Time'),(13,'Andrew','K','Smith','1969-04-04',42,'Bambaramba Ave.','Pennant Hills','NSW',2556,11200.00,'0412356389','Part Time'),(14,'Andrew','R','Smith','1992-04-01',67,'King Cr.','Hurstville','NSW',2456,12000.00,'0412356739','Full Time'),(15,'Michael',NULL,'Potter','1995-04-01',568,'Bong Bong St.','Horsley','NSW',2530,14000.00,'0412356783','Part Time'),(16,'Harry',NULL,'Potter','1995-04-01',568,'Bong Bong St.','Horsley','NSW',2530,8000.00,'0412356784','Full Time'),(17,'James',NULL,'Bond','1975-01-13',7,'Alan Bond St.','Perth','Western Australia',6000,9500.00,'0412356749','Full Time'),(18,'Paris',NULL,'Hilton','1973-10-23',1,'Hilton St.','Melbourne','Victoria',3000,9800.00,'0412356489','Casual'),(19,'Lady',NULL,'Gaga','1983-12-17',3,'Pork St.','Hobart','Tasmania',7000,1200.00,'0412354789','Full Time'),(20,'Robin',NULL,'Hood','1983-01-10',6,'Nottingham Pl.','Sydney','NSW',2000,12500.00,'0412346789','Full Time'),(21,'Andy',NULL,'Zhu','1981-01-12',38,'Ekerts Road.','Pokolbin','NSW',2320,5000.00,'0412456789','Full Time'),(22,'Amos',NULL,'Li','1981-01-12',6,'Melbourne Place.',' Melbourne','Victoria',3000,11000.00,'0414356789','Full Time'),(23,'Andre',NULL,'Smith','1960-06-23',12,'Bendooley Street.','Bowral','NSW',2576,12000.00,'0442356789','Full Time'),(24,'Bart',NULL,'Zhang','1982-03-05',455,'George St.','Sydney','NSW',2000,15000.00,'0452356789','Full Time'),(25,'Barton',NULL,'Yang','1980-01-01',8,'Whiteman S.','Melbourne','Victoria',3000,8000.05,'0415356789','Casual'),(26,'Kyle',NULL,'Wang','1971-03-05',29,' Doggett St.','Newstead ','Queensland',4005,9000.00,'0412556789','Full Time'),(27,'Larry',NULL,'Jones','1983-01-03',46,' Spence Street.',' Cairns City ','Queensland',4870,1300.00,'0412355789','Full Time'),(28,'Len',NULL,'O\'Brien','1983-02-28',19,'Liverpool Street.','Melbourne','Victoria',3000,12000.00,'0412356589','Full Time'),(29,'Carl',NULL,'Lucas','1966-12-16',36,'Caxton St.','Brisbane','Queensland',4000,7000.00,'0412356759','Full Time'),(30,'Frank',NULL,'Fox','1972-10-15',120,'Seaworld Dr Main Beach.','Queensland','Queensland',4217,12000.60,'0412356785','Full Time'),(31,'Don',NULL,'Fox','1990-10-15',6,'Theresa Creek Rd.','Millaa Millaa','Queensland',4886,13000.00,'0412356786','Part Time'),(32,'Clark',NULL,',Cox','1984-12-12',179,' Gold Coast','Queensland ','Queensland',4220,11000.00,'0412356769','Full Time'),(33,'Daniel','K','Smith','1962-04-04',42,'Salt Village.','Kingscliff','NSW',2487,20000.10,'0412356689','Full Time'),(34,'Ave','R','Smith','1991-04-01',66,'Bourke St.','Melbourne','Victoria',3000,11000.00,'0412366789','Casual'),(35,'Edison',NULL,'Potter','1995-04-01',90,'Bong Bong St.','Kingscliff','NSW',2487,13000.00,'0412656789','Full Time'),(36,'Gale',NULL,'Potter','1992-04-01',31,'Johnston St.','Stratford','Queensland',4780,11000.00,'0416356789','Part Time'),(37,'Ivan',NULL,'Bond','1970-01-11',49,' Little Bourke Street.','Melbourne','Victoria',3000,9000.00,'0462356789','Full Time'),(38,'Matt',NULL,'Hilton','1980-11-19',86,'Marine Pde.','Kingscliff','Western Australia',2487,9000.00,'0472356789','Full Time'),(39,'David',NULL,'Gaga','1973-05-19',6,'Orchid Avenue','Surfers Paradise','Queensland',4780,69999.00,'0417356789','Full Time'),(40,'Ben',NULL,'Franklin','1973-11-18',43,'Little Bourke St.','Melbourne','Victoria',3000,9000.00,'0412756789','Casual');
/*!40000 ALTER TABLE `EMPLOYEE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DRIVER`
--

DROP TABLE IF EXISTS `DRIVER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DRIVER` (
  `ENUM` decimal(12,0) NOT NULL,
  `LNUM` decimal(8,0) NOT NULL,
  `LTYPE` varchar(20) NOT NULL,
  `YEXP` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`ENUM`),
  UNIQUE KEY `DRIVER_UNIQUE` (`LNUM`),
  CONSTRAINT `DRIVER_FKEY` FOREIGN KEY (`ENUM`) REFERENCES `EMPLOYEE` (`ENUM`),
  CONSTRAINT `DRIVER_CHECK1` CHECK ((`LTYPE` in (_utf8mb4'Car',_utf8mb4'Heavy Rigid',_utf8mb4'light Rigid'))),
  CONSTRAINT `DRIVER_CHECK3` CHECK (((`YEXP` >= 0) and (`YEXP` <= 50)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DRIVER`
--

LOCK TABLES `DRIVER` WRITE;
/*!40000 ALTER TABLE `DRIVER` DISABLE KEYS */;
INSERT INTO `DRIVER` VALUES (1,10001,'Car',10),(2,10008,'Heavy Rigid',8),(3,10002,'Heavy Rigid',8),(4,10004,'Car',10),(5,10003,'Heavy Rigid',5),(6,10012,'Heavy Rigid',6),(7,20002,'light Rigid',10),(8,20003,'light Rigid',12),(9,30005,'Car',13),(10,40002,'light Rigid',15),(11,20045,'light Rigid',6),(12,20055,'Car',7),(13,20065,'light Rigid',9),(14,10305,'Heavy Rigid',11),(15,10345,'Car',6),(16,10705,'light Rigid',8),(17,40005,'light Rigid',16);
/*!40000 ALTER TABLE `DRIVER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VEHICLE`
--

DROP TABLE IF EXISTS `VEHICLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `VEHICLE` (
  `REGNUM` varchar(10) NOT NULL,
  `MANUFACT` varchar(30) NOT NULL,
  `YMANUF` decimal(4,0) NOT NULL,
  `STATUS` varchar(20) NOT NULL,
  PRIMARY KEY (`REGNUM`),
  CONSTRAINT `VEHICLE_CHECK1` CHECK ((`STATUS` in (_utf8mb4'AVAILABLE',_utf8mb4'DECOMMISSIONED',_utf8mb4'MAINTAINED'))),
  CONSTRAINT `VEHICLE_CHECK2` CHECK (((`YMANUF` >= 1999) and (`YMANUF` <= year(sysdate()))))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VEHICLE`
--

LOCK TABLES `VEHICLE` WRITE;
/*!40000 ALTER TABLE `VEHICLE` DISABLE KEYS */;
INSERT INTO `VEHICLE` VALUES ('AB0301','Man',2003,'MAINTAINED'),('AB0804','Daimler',2008,'AVAILABLE'),('AB0945','Volvo',1999,'AVAILABLE'),('AB0988','Iveco',2011,'DECOMMISSIONED'),('AL08UK','Ashok',2008,'AVAILABLE'),('GFT008','Scania',2005,'AVAILABLE'),('KKK007','Isuzu',2005,'MAINTAINED'),('LUCY01','Volvo',2008,'AVAILABLE'),('LUCY02','Hino',2007,'AVAILABLE'),('PKR008','Volvo',2003,'AVAILABLE'),('PKR768','Volvo',2001,'AVAILABLE'),('QRT834','Tata',2012,'AVAILABLE'),('SST005','Iveco',2000,'DECOMMISSIONED'),('SYF777','Hyindai',2004,'MAINTAINED'),('XCF003','Scania',2004,'AVAILABLE');
/*!40000 ALTER TABLE `VEHICLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SCHEDULE`
--

DROP TABLE IF EXISTS `SCHEDULE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SCHEDULE` (
  `SNUM` decimal(10,0) NOT NULL,
  `LNUM` decimal(8,0) NOT NULL,
  `REGNUM` varchar(10) NOT NULL,
  `START_DATE_TIME` datetime NOT NULL,
  `RETURN_DATE_TIME` datetime DEFAULT NULL,
  `RNUM` decimal(10,0) NOT NULL,
  PRIMARY KEY (`SNUM`),
  UNIQUE KEY `SCHEDULE_UNIQUE` (`LNUM`,`REGNUM`,`START_DATE_TIME`),
  KEY `SCHEDULE_FKEY2` (`REGNUM`),
  KEY `SCHEDULE_FKEY3` (`RNUM`),
  CONSTRAINT `SCHEDULE_FKEY1` FOREIGN KEY (`LNUM`) REFERENCES `DRIVER` (`LNUM`),
  CONSTRAINT `SCHEDULE_FKEY2` FOREIGN KEY (`REGNUM`) REFERENCES `VEHICLE` (`REGNUM`),
  CONSTRAINT `SCHEDULE_FKEY3` FOREIGN KEY (`RNUM`) REFERENCES `ROUTE` (`RNUM`),
  CONSTRAINT `SCHEDULE_CHECK1` CHECK ((`START_DATE_TIME` <= sysdate())),
  CONSTRAINT `SCHEDULE_CHECK2` CHECK ((`RETURN_DATE_TIME` <= sysdate())),
  CONSTRAINT `SCHEDULE_CHECK3` CHECK ((`RETURN_DATE_TIME` >= `START_DATE_TIME`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SCHEDULE`
--

LOCK TABLES `SCHEDULE` WRITE;
/*!40000 ALTER TABLE `SCHEDULE` DISABLE KEYS */;
INSERT INTO `SCHEDULE` VALUES (1,10001,'PKR768','2019-01-12 05:00:00','2019-01-17 18:00:00',1),(2,10001,'SYF777','2019-02-20 05:00:00','2019-02-22 18:00:00',2),(3,10001,'AB0804','2019-03-12 05:00:00','2019-03-17 18:00:00',21),(4,10001,'PKR768','2019-06-29 05:00:00','2019-07-06 18:00:00',22),(5,20002,'PKR768','2019-01-12 05:00:00','2019-01-17 18:00:00',3),(6,10002,'SYF777','2019-02-20 05:00:00','2019-02-25 18:00:00',4),(7,30005,'KKK007','2019-03-12 05:00:00','2019-03-26 18:00:00',5),(8,10001,'AB0804','2019-01-12 05:00:00','2019-01-17 18:00:00',6),(9,10002,'QRT834','2019-09-17 05:00:00','2019-09-19 18:00:00',7),(10,30005,'KKK007','2019-12-15 05:00:00','2019-12-25 18:00:00',8),(11,10003,'SST005','2018-01-23 05:00:00','2018-01-29 18:00:00',9),(12,10002,'PKR768','2018-03-12 05:00:00','2018-03-17 18:00:00',9),(13,20002,'QRT834','2019-04-23 05:00:00','2019-04-26 18:00:00',10),(14,20002,'PKR008','2019-04-23 05:00:00','2019-04-29 18:00:00',3),(15,30005,'PKR768','2019-05-24 05:00:00','2019-05-29 18:00:00',3),(16,30005,'SST005','2017-08-02 05:00:00','2017-08-17 18:00:00',4),(17,20002,'QRT834','2017-09-17 05:00:00','2017-09-22 18:00:00',33),(18,10001,'KKK007','2017-12-15 05:00:00','2019-12-17 18:00:00',25),(19,30005,'SST005','2018-01-23 05:00:00','2018-01-28 18:00:00',26),(20,10003,'PKR768','2018-03-12 05:00:00','2018-03-17 18:00:00',27),(21,10001,'QRT834','2016-04-23 05:00:00','2016-04-28 18:00:00',24),(22,30005,'PKR008','2016-04-23 05:00:00','2016-04-26 18:00:00',23),(23,10003,'PKR768','2016-05-25 05:00:00','2016-05-31 18:00:00',22),(24,20002,'SST005','2016-08-02 05:00:00','2016-08-17 18:00:00',26),(25,10001,'PKR768','2017-01-12 05:00:00','2017-01-17 18:00:00',12),(26,10001,'AB0804','2013-02-20 05:00:00','2013-02-26 18:00:00',12),(27,20002,'KKK007','2013-03-12 05:00:00','2013-03-17 18:00:00',11),(28,30005,'AB0804','2010-06-29 05:00:00','2010-07-05 18:00:00',12),(29,10001,'QRT834','2010-09-17 05:00:00','2010-09-25 18:00:00',13),(30,10002,'KKK007','2010-12-15 05:00:00','2010-12-17 18:00:00',14),(31,10003,'SST005','2010-01-23 05:00:00','2010-01-29 18:00:00',15),(32,20002,'PKR768','2010-03-12 05:00:00','2010-03-17 18:00:00',6),(33,30005,'QRT834','2003-04-23 05:00:00','2003-05-01 18:00:00',16),(34,30005,'PKR008','2004-04-23 05:00:00','2004-04-29 18:00:00',6),(35,10001,'PKR768','2018-05-24 05:00:00','2018-06-03 18:00:00',14),(36,10002,'SYF777','2017-02-25 05:00:00','2017-02-28 18:00:00',17),(37,30005,'PKR008','2017-01-23 05:00:00','2017-01-29 18:00:00',7),(38,10003,'SST005','2018-01-10 05:00:00','2018-01-29 18:00:00',17),(39,30005,'PKR008','2019-04-23 05:00:00','2019-04-29 18:00:00',18),(40,10002,'SYF777','2018-02-20 05:00:00','2018-02-25 18:00:00',19),(41,30005,'PKR008','2018-04-23 05:00:00','2018-04-29 18:00:00',20),(42,10003,'SST005','2018-05-23 05:00:00','2018-05-29 18:00:00',21),(43,10002,'SYF777','2017-02-20 05:00:00','2017-02-25 18:00:00',22),(44,10002,'PKR008','2019-04-23 05:00:00','2019-04-29 18:00:00',23),(45,10003,'SST005','2017-01-23 05:00:00','2017-01-29 18:00:00',24),(46,30005,'AB0988','2019-04-23 05:00:00','2019-04-29 18:00:00',25),(47,10002,'AB0804','2019-02-20 05:00:00','2019-02-25 18:00:00',26),(48,40005,'SST005','2018-07-23 05:00:00','2018-07-29 18:00:00',27),(49,10002,'SST005','2020-11-01 05:00:00','2020-11-02 18:00:00',28),(50,10001,'SST005','2020-10-05 05:00:00','2020-10-06 18:00:00',29),(51,20002,'SST005','2020-10-23 05:00:00','2020-10-29 18:00:00',29);
/*!40000 ALTER TABLE `SCHEDULE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROUTE`
--

DROP TABLE IF EXISTS `ROUTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ROUTE` (
  `RNUM` decimal(10,0) NOT NULL,
  `TOTAL_DISTANCE` decimal(6,2) NOT NULL,
  PRIMARY KEY (`RNUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROUTE`
--

LOCK TABLES `ROUTE` WRITE;
/*!40000 ALTER TABLE `ROUTE` DISABLE KEYS */;
INSERT INTO `ROUTE` VALUES (1,1450.00),(2,1150.00),(3,1050.00),(4,550.00),(5,650.00),(6,70.00),(7,80.00),(8,1000.00),(9,200.00),(10,120.00),(11,220.00),(12,250.00),(13,550.00),(14,750.00),(15,850.00),(16,950.00),(17,1050.00),(18,250.00),(19,450.00),(20,680.00),(21,880.00),(22,250.00),(23,550.00),(24,750.00),(25,850.00),(26,950.00),(27,1050.00),(28,250.00),(29,450.00),(30,380.00),(31,480.00),(32,680.00),(33,780.00);
/*!40000 ALTER TABLE `ROUTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROUTE_STATION`
--

DROP TABLE IF EXISTS `ROUTE_STATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ROUTE_STATION` (
  `RNUM` decimal(10,0) NOT NULL,
  `STOP_NUM` decimal(2,0) NOT NULL,
  `STATION` varchar(50) NOT NULL,
  PRIMARY KEY (`RNUM`,`STOP_NUM`,`STATION`),
  KEY `ROUTE_FKEY2` (`STATION`),
  CONSTRAINT `ROUTE_FKEY1` FOREIGN KEY (`RNUM`) REFERENCES `ROUTE` (`RNUM`),
  CONSTRAINT `ROUTE_FKEY2` FOREIGN KEY (`STATION`) REFERENCES `STATION` (`SNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROUTE_STATION`
--

LOCK TABLES `ROUTE_STATION` WRITE;
/*!40000 ALTER TABLE `ROUTE_STATION` DISABLE KEYS */;
INSERT INTO `ROUTE_STATION` VALUES (3,1,'Adelaide'),(24,2,'Adelaide'),(30,1,'Airlie Beach'),(32,2,'Apollo Bay'),(33,2,'Apollo Bay'),(6,3,'Brisbane'),(8,2,'Brisbane'),(9,2,'Brisbane'),(11,1,'Brisbane'),(15,3,'Brisbane'),(18,1,'Brisbane'),(26,2,'Brisbane'),(28,2,'Cairns City'),(29,1,'Cairns City'),(2,1,'Hobart'),(1,2,'Melbourne'),(4,2,'Melbourne'),(5,1,'Melbourne'),(8,1,'Melbourne'),(12,2,'Melbourne'),(13,1,'Melbourne'),(14,2,'Melbourne'),(16,1,'Melbourne'),(19,2,'Melbourne'),(20,2,'Melbourne'),(24,1,'Melbourne'),(27,2,'Melbourne'),(32,1,'Melbourne'),(6,2,'Newcastle'),(21,2,'Newcastle'),(22,2,'Newcastle'),(28,1,'Newcastle'),(25,2,'Newstead'),(26,1,'Newstead'),(30,2,'North Batemans Bay'),(31,2,'North Batemans Bay'),(2,2,'Perth'),(17,1,'Perth'),(25,1,'Perth'),(33,1,'Perth'),(1,1,'Sydney'),(3,3,'Sydney'),(4,1,'Sydney'),(5,2,'Sydney'),(6,1,'Sydney'),(7,1,'Sydney'),(9,1,'Sydney'),(10,2,'Sydney'),(11,2,'Sydney'),(12,1,'Sydney'),(13,2,'Sydney'),(15,2,'Sydney'),(16,2,'Sydney'),(17,2,'Sydney'),(18,2,'Sydney'),(19,1,'Sydney'),(20,1,'Sydney'),(21,1,'Sydney'),(22,1,'Sydney'),(23,2,'Sydney'),(27,1,'Sydney'),(29,2,'Sydney'),(3,2,'Wollongong'),(7,2,'Wollongong'),(10,1,'Wollongong'),(12,2,'Wollongong'),(14,1,'Wollongong'),(15,1,'Wollongong'),(23,1,'Wollongong'),(31,1,'Wollongong');
/*!40000 ALTER TABLE `ROUTE_STATION` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-02 22:05:00