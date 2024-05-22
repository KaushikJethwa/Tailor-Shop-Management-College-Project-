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
-- Table structure for table `dressmeasurements`
--

DROP TABLE IF EXISTS `dressmeasurements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dressmeasurements` (
  `dresstype` varchar(255) DEFAULT NULL,
  `shoulder` varchar(255) DEFAULT NULL,
  `lengthoftop` varchar(255) DEFAULT NULL,
  `lengthofhand` varchar(255) DEFAULT NULL,
  `chest` varchar(255) DEFAULT NULL,
  `neck` varchar(255) DEFAULT NULL,
  `waist` varchar(255) DEFAULT NULL,
  `lengthoflower` varchar(255) DEFAULT NULL,
  `lengthofbottom` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `pattern` varchar(255) DEFAULT NULL,
  `completed` varchar(255) DEFAULT NULL,
  `dateTime` datetime DEFAULT NULL,
  `Aster` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dressmeasurements`
--

LOCK TABLES `dressmeasurements` WRITE;
/*!40000 ALTER TABLE `dressmeasurements` DISABLE KEYS */;
INSERT INTO `dressmeasurements` VALUES ('punjabi suit','8','8','8','8','88','8','8','8','8','Kaushik Jethwa',850,'Pattern2','NO','2023-10-01 19:47:45','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','9','92','9','9','9','9','9','9','9','Bruce',850,'Pattern2','YES','2023-10-01 19:58:57','clientAster'),('punjabi suit','8','8','8','8','8','88','8','8','8','nilesh',850,'Pattern2','YES','2023-10-01 20:38:22','clientAster'),('punjabi suit','9','92','9','9','99','9','99','9','9','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 20:41:36','clientAster'),('punjabi suit','9','2','2','2','2','2','2','2','2','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 20:43:23','clientAster'),('punjabi suit','2','2','2','2','2','2','2','2','2','Bruce',850,'Pattern2','YES','2023-10-01 20:44:22','clientAster'),('punjabi suit','8','8','88','8','8','8','8','8','8','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 20:54:28','clientAster'),('punjabi suit','9','92','9','9','99','9','9','9','9','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 21:10:29','clientAster'),('punjabi suit','9','92','99','9','99','9','9','99','9','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 21:20:13','clientAster'),('punjabi suit','8','8','8','8','8','88','8','8','88','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 21:36:37','clientAster'),('punjabi suit','9','92','9','9','7','7','77','7','7','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 21:40:28','clientAster'),('punjabi suit','7','2','22','7','2','2','2','2','2','Kaushik Jethwa',850,'Pattern2','YES','2023-10-01 22:00:21','clientAster'),('punjabi suit','2','2','2','2','2','2','229','2','2','Kaushik Jethwa',950,'Pattern3','NO','2023-10-01 22:10:38','clientAster'),('punjabi suit','7','7','7','7','7','7','7','7','7','rohit',850,'Pattern2','YES','2023-10-07 16:38:31','clientAster'),('punjabi suit','8','8','88','8','8','8','8','8','9','rohit bhai',850,'Pattern2','YES','2023-10-07 16:40:49','clientAster'),('punjabi suit','43','45','23','32','234','23','45','12','32','hiral jethwa',750,'Pattern1','NO','2023-10-08 04:43:40','clientAster');
/*!40000 ALTER TABLE `dressmeasurements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-09  9:37:51
