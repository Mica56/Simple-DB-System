-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: improject
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `tbltransaction`
--

DROP TABLE IF EXISTS `tbltransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltransaction` (
  `Refnum` int NOT NULL,
  `Custname` varchar(50) DEFAULT NULL,
  `Transtype` varchar(50) DEFAULT NULL,
  `Transdate` date DEFAULT NULL,
  `Invoicenum` int DEFAULT NULL,
  `Paytype` varchar(12) DEFAULT NULL,
  `Total` float DEFAULT NULL,
  PRIMARY KEY (`Refnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltransaction`
--

LOCK TABLES `tbltransaction` WRITE;
/*!40000 ALTER TABLE `tbltransaction` DISABLE KEYS */;
INSERT INTO `tbltransaction` VALUES (1,'Edna T. Cerilla','bills payment','2021-06-18',1233,'Cash',1500),(2,'Micaela Cerilla','bills payment','2021-07-15',1234,'Cash',1500),(3,'Melanie T. Cerilla','bills payment','2021-07-17',2338,'Credit Card',5500),(4,'Qin Sheng','loan payment','2021-07-17',4586,'Check',6000),(5,'Louis Li','bills payment','2021-07-18',2464,'Cash',5000),(6,'Qin Sheng','loan payment','2021-08-17',4587,'Check',6000),(7,'Shin Yap','bills payment','2021-08-18',2035,'Cash',5000),(8,'Micaela Cerilla','bills payment','2021-08-18',1235,'Cash',1500),(9,'Melanie T. Cerilla','bills payment','2021-09-17',2340,'Credit Card',16000),(10,'Qin Sheng','loan payment','2021-09-17',4588,'Check',6000);
/*!40000 ALTER TABLE `tbltransaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-27 17:33:09
