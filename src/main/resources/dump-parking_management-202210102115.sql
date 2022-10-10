-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: parking_management
-- ------------------------------------------------------
-- Server version	5.5.5-10.0.10-MariaDB

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
-- Table structure for table `parking_lot`
--

DROP TABLE IF EXISTS `parking_lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parking_lot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_vehicle_types` int(11) NOT NULL,
  `available_lot` bigint(20) NOT NULL,
  `filled_lot` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `parking_lot_vehicle_types` (`id_vehicle_types`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_lot`
--

LOCK TABLES `parking_lot` WRITE;
/*!40000 ALTER TABLE `parking_lot` DISABLE KEYS */;
INSERT INTO `parking_lot` VALUES (1,1,1000,2),(2,2,1500,3);
/*!40000 ALTER TABLE `parking_lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_methods`
--

DROP TABLE IF EXISTS `payment_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_methods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key Of Payment Methods',
  `code` varchar(100) COLLATE utf8_hungarian_ci NOT NULL COMMENT 'Code Of Payment Methods',
  `description` varchar(100) COLLATE utf8_hungarian_ci NOT NULL COMMENT 'Description Of Payment Methods',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_methods`
--

LOCK TABLES `payment_methods` WRITE;
/*!40000 ALTER TABLE `payment_methods` DISABLE KEYS */;
INSERT INTO `payment_methods` VALUES (1,'CASH','Cash'),(2,'DANA','Dana Indonesia'),(3,'GOPAY','Gopay Wallet'),(4,'OVO','Ovo');
/*!40000 ALTER TABLE `payment_methods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID as Primary Key Of Tickets',
  `ticket_number` varchar(100) NOT NULL COMMENT 'Number of Ticket',
  `datetime_in` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date Time Incoming of Ticket',
  `datetime_out` timestamp NULL DEFAULT NULL COMMENT 'Date Time Outcoming of Ticket',
  `barcode` varchar(255) DEFAULT NULL COMMENT 'Barcode of Ticket',
  `id_payment_methods` int(11) DEFAULT NULL COMMENT 'ID Payment Methods reference from table payment methods',
  `checkout_by` varchar(50) DEFAULT NULL,
  `plat_number` varchar(10) DEFAULT NULL,
  `is_payment` tinyint(1) DEFAULT NULL,
  `id_vehicle_types` int(11) NOT NULL,
  `total_hour` int(11) DEFAULT NULL,
  `total_cost` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tickets_unique_ticket_number` (`ticket_number`),
  UNIQUE KEY `tickets_unique_barcode` (`barcode`),
  KEY `tickets_payment_methods_fk` (`id_payment_methods`),
  KEY `tickets_vehicle_types_fk` (`id_vehicle_types`),
  CONSTRAINT `tickets_payment_methods_fk` FOREIGN KEY (`id_payment_methods`) REFERENCES `payment_methods` (`id`),
  CONSTRAINT `tickets_vehicle_types_fk` FOREIGN KEY (`id_vehicle_types`) REFERENCES `vehicle_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,'1|M02','2022-10-10 15:09:17',NULL,'C90CE7F7ED3C4B7CB428C4',NULL,NULL,NULL,0,1,NULL,NULL),(2,'2|C04','2022-10-10 15:18:25','2022-10-10 13:57:29','C58ED5087F874D39814B90',1,'Tompi','B1211UWM',1,2,5,25000),(3,'3|C04','2022-10-10 15:21:04',NULL,'F24036C9B24340AE80C06B',NULL,NULL,NULL,0,2,NULL,NULL),(4,'4|M02','2022-10-10 15:21:19',NULL,'BB9840B66BD142BAA44193',NULL,NULL,NULL,0,1,NULL,NULL),(5,'5|C04','2022-10-10 15:29:45',NULL,'0A7F6AEDFF894EE784EBE2',NULL,NULL,NULL,0,2,NULL,NULL),(6,'6|C04','2022-10-10 16:02:35',NULL,'4438BA5A183B439D8937F8',NULL,NULL,NULL,0,2,NULL,NULL);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_types`
--

DROP TABLE IF EXISTS `vehicle_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID of Vehicle Types',
  `vehicle` varchar(100) NOT NULL COMMENT 'Vehicle',
  `cost_per_hour` int(11) NOT NULL COMMENT 'Cost Per Hour',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_types`
--

LOCK TABLES `vehicle_types` WRITE;
/*!40000 ALTER TABLE `vehicle_types` DISABLE KEYS */;
INSERT INTO `vehicle_types` VALUES (1,'MOTORCYCLE',2000),(2,'CAR',5000);
/*!40000 ALTER TABLE `vehicle_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'parking_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-10 21:15:30
