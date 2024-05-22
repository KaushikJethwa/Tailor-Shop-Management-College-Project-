-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: management
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customerdetail`
--

DROP TABLE IF EXISTS `customerdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerdetail` (
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `worker` varchar(255) DEFAULT NULL,
  `cloth` varchar(255) DEFAULT NULL,
  `dateTime` datetime DEFAULT NULL,
  `advance` int DEFAULT NULL,
  `urgent` varchar(255) DEFAULT NULL,
  `deliveryDate` varchar(50) DEFAULT NULL,
  `bill_no` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdetail`
--

LOCK TABLES `customerdetail` WRITE;
/*!40000 ALTER TABLE `customerdetail` DISABLE KEYS */;
INSERT INTO `customerdetail` VALUES ('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 19:47:45',49,'YES','2023-10-04',1),('Bruce','7710865788','Gotham','bat@gmail.com','worker1','dress','2023-10-01 19:58:57',30,'YES','2023-10-13',2),('nilesh','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 20:38:22',20,'YES','2023-10-19',3),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 20:41:36',30,'YES','2023-10-23',4),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 20:43:23',70,'YES','2023-10-14',5),('Bruce','9969278097','Gotham','bat@gmail.com','worker1','dress','2023-10-01 20:44:22',45,'YES','2023-10-17',6),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 20:54:28',30,'YES','2023-10-16',7),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 21:10:29',30,'YES','2023-10-29',8),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 21:20:13',30,'YES','2023-10-09',9),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 21:36:37',20,'YES','2023-10-17',10),('Kaushik Jethwa','9969278097','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 21:40:28',20,'YES','2023-10-30',11),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 22:00:21',40,'YES','2023-10-09',12),('Kaushik Jethwa','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','kaushikjethwa19@gmail.com','worker1','dress','2023-10-01 22:10:38',40,'YES','2023-10-17',13),('rohit','7710865788','104,D-6,Sahil C.H.S,Gorai-1,Borivali W','rv@telegmail.com','worker1','dress','2023-10-07 16:38:31',30,'YES','2023-10-18',14),('rohit bhai','79878978','hhfjhajk','vadhavanarohit73@gmail.com','worker1','dress','2023-10-07 16:40:49',67,'YES','2023-10-25',15),('hiral jethwa','4455','Gotham','bat@gmail.com','worker1','dress','2023-10-08 04:43:40',40,'YES','2023-11-01',16),('Bruce','9969278097','Gotham','bat@gmail.com','worker1','dress','2023-10-08 04:45:56',34,'YES','',17);
/*!40000 ALTER TABLE `customerdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-09  9:37:49
