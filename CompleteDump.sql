-- MySQL dump 10.13  Distrib 5.6.19, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: gimmeFive
-- ------------------------------------------------------
-- Server version	5.6.27-0ubuntu0.14.04.1

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
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `entry` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `speciality` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`entry`,`location`,`category`),
  UNIQUE KEY `CK_activities` (`category`,`entry`,`location`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (13,'coaching','byju','hsr layout','CAT'),(14,'coaching','byju','kormangala','CAT'),(15,'coaching','joshi classes','banshankari','Maths'),(16,'coaching','KT','hebbal','chemistry'),(17,'coaching','rajiv','domloor','physics'),(18,'coaching','RJS','BTM','big data'),(19,'coaching','varnaaz','banshankari','software technologies'),(20,'coaching','xyz','btm','java'),(21,'company','glassbeam','mg road','log analytics'),(22,'company','robert bosch','kormanagala','product company'),(23,'company','tavant technologies','kormangala','game development'),(24,'company','ugam solutions','hebbal','retail analytics'),(25,'gym','golds gym','hsr layout','fitness'),(26,'gym','magnum gym','hsr layout','fitness'),(27,'gym','pink fitness','hsr layout','fitness'),(28,'gym','snap fitness','hsr layout','fitnes'),(29,'restraurant','3\'oh3','indiranagar','restrobar'),(30,'restraurant','bakester','indiranagar','pizza'),(31,'restraurant','black rabbit','indiranagar','pub'),(32,'restraurant','cafe masala','MG Road','indian'),(33,'restraurant','chai patty','indiranagar','snacks'),(34,'restraurant','fatty bao','indiranagar','restrobar'),(35,'restraurant','hard rock cafe','st.marks road','pub'),(36,'restraurant','Imly','Indiranagar','indian'),(37,'restraurant','Little Italy','Indiranagar','italian'),(39,'restraurant','Little Italy','kormangala','italian'),(40,'restraurant','smalllys','frazer town','restrobar'),(41,'restraurant','social','church street','pub'),(42,'restraurant','Stoner','Indiranagar','ice cream'),(44,'restraurant','vapor','indirangar','pub'),(45,'salon','bodycraft','indiranagar','beaunty'),(46,'salon','bodycraft','kormanagala','spa'),(47,'salon','bodycraft','ulsoor','spa'),(48,'salon','lakme','hsr layout','beauty'),(49,'salon','lakme','kormangala','beauty'),(50,'salon','rita beauty parlour','kormangala','beauty'),(51,'salon','shehnaz','indiranagar','beauty'),(52,'salon','vlcc','indiranagar','beauty services'),(53,'salon','vlcc','kormanagala','beauty'),(54,'salon','vlcc','whitefield','beauty'),(55,'salon','ylg','hsr layout','beauty'),(56,'salon','ylg','indiranagar','beauty'),(57,'salon','ylg','mg road','beauty');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `name` varchar(100) NOT NULL,
  `speciality` varchar(100) NOT NULL,
  `attr1` varchar(100) NOT NULL,
  `att2` varchar(100) DEFAULT NULL,
  `attr3` varchar(100) DEFAULT NULL,
  `attr4` varchar(100) DEFAULT NULL,
  `attr5` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`name`,`speciality`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('coaching','subjects','value for money','staff','effectiveness','material','crowd'),('company','domain','salary','work culture','technologies','appraisal','employee satisfaction'),('gym','speciality','value for money','equipments','trainers','ambience',''),('restaurant','cuisine','value for money','food','service','ambience','quality'),('salon','speciality','value for money','staff service','customer satisfaction','quality of product used','');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coaching`
--

DROP TABLE IF EXISTS `coaching`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coaching` (
  `coaching_name` varchar(100) NOT NULL,
  `coaching_location` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `coaching_speciality` varchar(100) NOT NULL,
  `value_for_money` float unsigned DEFAULT '0',
  `staff` float unsigned DEFAULT '0',
  `effectiveness` float unsigned DEFAULT '0',
  `material` float unsigned DEFAULT '0',
  `crowd` float unsigned DEFAULT '0',
  `user_exp` float unsigned DEFAULT '0',
  `user_review` varchar(100) DEFAULT NULL,
  `posted_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`coaching_name`,`coaching_location`,`posted_on`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coaching`
--

LOCK TABLES `coaching` WRITE;
/*!40000 ALTER TABLE `coaching` DISABLE KEYS */;
INSERT INTO `coaching` VALUES ('byju','hsr layout','iveeshal@gmail.com','CAT',2,4,5,5,1,3.4,NULL,'2015-11-14 02:24:06'),('byju','kormangala','iveeshal@gmail.com','CAT',3,4,5,5,2,5,'','2015-11-14 02:24:06'),('joshi classes','banshankari','iveeshal','Maths',2,4,5,3,1,4,NULL,'2015-11-14 02:24:06'),('KT','hebbal','kusha.pande@gmail.com','chemistry',1,5,5,0,5,4.5,NULL,'2015-11-14 02:24:06'),('rajiv','domloor','kusha.pande@gmail.com','physics',1,3,5,0,1,2,NULL,'2015-11-14 02:24:06'),('RJS','BTM','kusha.pande@gmail.com','big data',4,3,5,4,3,3.5,'okay','2015-11-14 02:24:06'),('varnaaz','banshankari','kusha.pande@gmail.com','software technologies',2,4,3,3,1,0,NULL,'2015-11-26 03:31:37'),('xyz','btm','iveeshal@gmail.com','java',5,5,5,5,5,5,'good','2015-11-23 11:29:08');
/*!40000 ALTER TABLE `coaching` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger entiresAfterInsertCoaching after insert on coaching
for each row
begin
   insert  ignore into activities (category,Entry,location,speciality) values ('coaching',new.coaching_name, new.coaching_location,new.coaching_speciality);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `company_name` varchar(100) NOT NULL,
  `company_location` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `company_speciality` varchar(100) NOT NULL,
  `salary` float DEFAULT '0',
  `work_culture` float DEFAULT '0',
  `technologies` float DEFAULT '0',
  `appraisal` float DEFAULT '0',
  `employee_satisfaction` float DEFAULT '0',
  `user_exp` float unsigned zerofill DEFAULT '000000000000',
  `user_review` varchar(100) DEFAULT NULL,
  `postedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`company_name`,`company_location`,`postedOn`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('glassbeam','mg road','kusha.pande@glassbeam.com','log analytics',2,1,1,1,1,000000000000,NULL,'2015-11-26 03:29:18'),('robert bosch','kormanagala','iveesal@gmail.com','product company',1,5,2,1,5,000000000000,NULL,'2015-11-26 03:29:18'),('tavant technologies','kormangala','kusha.pande@gmail.com','game development',3,3,2,1,3,000000000002,NULL,'2015-11-26 03:29:18'),('ugam solutions','hebbal','kusha.pande@gmail.com','retail analytics',1,5,5,1,3,000000000004,NULL,'2015-11-26 03:29:18');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger entiresAfterInsertCompany after insert on company
for each row
begin
   insert  ignore into activities (category,Entry,location,speciality) values ('company',new.company_name, new.company_location,new.company_speciality);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `gym`
--

DROP TABLE IF EXISTS `gym`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gym` (
  `gym_name` varchar(100) NOT NULL,
  `gym_location` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `gym_speciality` varchar(100) NOT NULL,
  `value_for_money` float unsigned DEFAULT '0',
  `equipments` float unsigned DEFAULT '0',
  `trainers` float unsigned DEFAULT '0',
  `ambience` float unsigned DEFAULT '0',
  `attr_5` float unsigned DEFAULT '0',
  `user_exp` float unsigned DEFAULT NULL,
  `user_review` varchar(100) DEFAULT NULL,
  `postedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`gym_name`,`gym_location`,`postedOn`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gym`
--

LOCK TABLES `gym` WRITE;
/*!40000 ALTER TABLE `gym` DISABLE KEYS */;
INSERT INTO `gym` VALUES ('golds gym','hsr layout','iveeshal@gmail.com','fitness',1,5,5,5,0,3.5,NULL,'2015-11-26 03:35:44'),('magnum gym','hsr layout','kusha.pande@gmail.com','fitness',4,3,3,3,0,3.5,'','0000-00-00 00:00:00'),('pink fitness','hsr layout','kusha.pande@gmail.com','fitness',4,3,2,3,0,NULL,NULL,'2015-11-26 03:35:44'),('snap fitness','hsr layout','iveeshal@gmail.com','fitnes',4,5,5,4,0,4,NULL,'2015-11-26 03:35:44');
/*!40000 ALTER TABLE `gym` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger entiresAfterInsertGym after insert on gym
for each row
begin
  insert  ignore into activities (category,Entry,location,speciality) values ('gym',new.gym_name, new.gym_location,new.gym_speciality);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `restraurant`
--

DROP TABLE IF EXISTS `restraurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restraurant` (
  `restraurant_name` varchar(100) NOT NULL,
  `restraurant_location` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `restraurant_speciality` varchar(100) NOT NULL,
  `value_for_money` float unsigned DEFAULT '0',
  `food` float unsigned DEFAULT '0',
  `service` float unsigned DEFAULT '0',
  `ambience` float unsigned DEFAULT '0',
  `quality` float unsigned DEFAULT '0',
  `user_exp` float unsigned DEFAULT '0',
  `user_review` varchar(255) DEFAULT NULL,
  `postedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`restraurant_name`,`restraurant_location`,`postedOn`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restraurant`
--

LOCK TABLES `restraurant` WRITE;
/*!40000 ALTER TABLE `restraurant` DISABLE KEYS */;
INSERT INTO `restraurant` VALUES ('3\'oh3','indiranagar','kusha.pande@gmail.com','restrobar',5,5,5,5,5,0,NULL,'2015-11-26 01:04:03'),('bakester','indiranagar','kusha.pande@gmail.com','pizza',4,3,4,3,5,5,NULL,'2015-11-14 00:01:54'),('black rabbit','indiranagar','iveeshal@gmail.com','pub',3,2,4,5,5,5,'','2015-11-14 00:59:01'),('cafe masala','MG Road','iveeshal@gmail.com','indian',2,4,5,5,4,0,NULL,'2015-11-14 00:54:40'),('chai patty','indiranagar','iveeshal@gmail.com','snacks',4,3,5,5,3,0,NULL,'2015-11-26 01:01:26'),('fatty bao','indiranagar','kusha.pande@gmail.com','restrobar',5,5,5,5,5,5,NULL,'2015-11-26 01:09:16'),('hard rock cafe','st.marks road','kusha.pande@gmail.com','pub',5,5,5,5,5,5,NULL,'2015-11-26 03:38:58'),('Imly','Indiranagar','kusha.pande@gmail.com','indian',3,4,5,5,3,3,'food not so good','2015-11-13 23:33:57'),('Little Italy','Indiranagar','kusha.pande@gmail.com','italian',2,3,2,5,2,1,'','2015-11-13 23:33:57'),('Little Italy','Indiranagar','iveeshal@gmail.com','italian',1,1,1,1,1,1,NULL,'2015-11-13 23:48:05'),('Little Italy','kormangala','iveeshal@hotmail.com','italian',4,3,5,1,3,0,'','2015-11-13 23:53:44'),('smalllys','frazer town','kusha.pande@gmail.com','restrobar',5,5,5,5,5,5,'','2015-11-26 03:38:58'),('social','church street','kusha.pande@gmail.com','pub',3,5,5,5,5,4.5,'','2015-11-26 03:38:58'),('Stoner','Indiranagar','kusha.pande@gmail.com','ice cream',3,5,5,4,5,5,'okay','2015-11-13 23:36:43'),('stoner','INDIRANAGAR','iveeshal@gmail.com','icecream',5,5,5,0,5,5,NULL,'2015-11-14 01:07:58'),('vapor','indirangar','iveeshal@gmail.com','pub',2,1,4,4,3,5,NULL,'2015-11-14 00:57:20');
/*!40000 ALTER TABLE `restraurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger entiresAfterInsertRestraurant after insert on restraurant
for each row
begin
  insert  ignore into activities (category,Entry,location,speciality) values ('restraurant',new.restraurant_name, new.restraurant_location,new.restraurant_speciality);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `salon`
--

DROP TABLE IF EXISTS `salon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salon` (
  `salon_name` varchar(100) NOT NULL,
  `salon_location` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `salon_speciality` varchar(100) NOT NULL,
  `value_for_money` float unsigned DEFAULT '0',
  `staff_service` float unsigned DEFAULT '0',
  `customer_satisfaction` float unsigned DEFAULT NULL,
  `quality_of_products_used` float unsigned DEFAULT '0',
  `attr5` float unsigned DEFAULT '0',
  `user_exp` float unsigned DEFAULT '0',
  `user_review` varchar(100) DEFAULT NULL,
  `postedOn` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`salon_name`,`salon_location`,`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salon`
--

LOCK TABLES `salon` WRITE;
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
INSERT INTO `salon` VALUES ('bodycraft','indiranagar','kusha.pande@gmail.com','beaunty',5,5,5,5,0,5,NULL,'2015-11-26 01:54:52'),('bodycraft','kormanagala','kusha.pande@gmail.com','spa',3,5,5,5,0,4.5,NULL,'2015-11-26 03:40:18'),('bodycraft','ulsoor','kusha.pande@gmail.com','spa',2,5,5,5,0,5,NULL,'2015-11-26 00:57:18'),('lakme','hsr layout','kusha.pande@gmail.com','beauty',2,2,1,5,0,2,'nothing so great','2015-11-14 01:46:58'),('lakme','kormangala','kusha.pande@gmail.com','beauty',4,3,2,0,0,3,NULL,'2015-11-14 01:46:58'),('rita beauty parlour','kormangala','kusha.pande@gmail.com','beauty',3,5,5,0,0,5,NULL,'2015-11-14 01:46:58'),('shehnaz','indiranagar','kusha.pande@gmail.com','beauty',5,5,5,5,0,5,NULL,'2015-11-14 01:46:58'),('vlcc','indiranagar','kusha.pande@gmail.com','beauty services',5,5,5,5,0,3,'costly','2015-11-14 01:46:58'),('vlcc','kormanagala','kusha.pande@gmail.com','beauty',3,5,5,5,0,4,NULL,'2015-11-14 01:46:58'),('vlcc','whitefield','kusha.pande@gmail.com','beauty',5,4,3,5,0,4,NULL,'2015-11-14 01:46:58'),('ylg','hsr layout','kusha.pande@gmail.com','beauty',2,4,3,2,0,3,'','2015-11-14 01:46:58'),('ylg','indiranagar','kusha.pande@gmail.com','beauty',1,3,4,3,0,3,NULL,'2015-11-14 01:46:58'),('ylg','mg road','kusha.pande@gmail.com','beauty',3,2,3,3,0,2,NULL,NULL);
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger entiresAfterInsertSalon after insert on salon
for each row
begin
  insert ignore into activities (category,Entry,location,speciality) values ('salon',new.salon_name, new.salon_location,new.salon_speciality);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'gimmeFive'
--

--
-- Dumping routines for database 'gimmeFive'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-30  1:06:52
