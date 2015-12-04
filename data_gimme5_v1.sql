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
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (13,'coaching','byju','hsr layout','CAT'),(14,'coaching','byju','kormangala','CAT'),(15,'coaching','joshi classes','banshankari','Maths'),(16,'coaching','KT','hebbal','chemistry'),(17,'coaching','rajiv','domloor','physics'),(18,'coaching','RJS','BTM','big data'),(19,'coaching','varnaaz','banshankari','software technologies'),(20,'coaching','xyz','btm','java'),(21,'company','glassbeam','mg road','log analytics'),(22,'company','robert bosch','kormanagala','product company'),(23,'company','tavant technologies','kormangala','game development'),(24,'company','ugam solutions','hebbal','retail analytics'),(25,'gym','golds gym','hsr layout','fitness'),(26,'gym','magnum gym','hsr layout','fitness'),(27,'gym','pink fitness','hsr layout','fitness'),(28,'gym','snap fitness','hsr layout','fitnes'),(29,'restraurant','3\'oh3','indiranagar','restrobar'),(30,'restraurant','bakester','indiranagar','pizza'),(31,'restraurant','black rabbit','indiranagar','pub'),(32,'restraurant','cafe masala','MG Road','indian'),(33,'restraurant','chai patty','indiranagar','snacks'),(34,'restraurant','fatty bao','indiranagar','restrobar'),(35,'restraurant','hard rock cafe','st.marks road','pub'),(36,'restraurant','Imly','Indiranagar','indian'),(37,'restraurant','Little Italy','Indiranagar','italian'),(39,'restraurant','Little Italy','kormangala','italian'),(40,'restraurant','smalllys','frazer town','restrobar'),(41,'restraurant','social','church street','pub'),(42,'restraurant','Stoner','Indiranagar','ice cream'),(44,'restraurant','vapor','indirangar','pub'),(45,'salon','bodycraft','indiranagar','beaunty'),(46,'salon','bodycraft','kormanagala','spa'),(47,'salon','bodycraft','ulsoor','spa'),(48,'salon','lakme','hsr layout','beauty'),(49,'salon','lakme','kormangala','beauty'),(50,'salon','rita beauty parlour','kormangala','beauty'),(51,'salon','shehnaz','indiranagar','beauty'),(52,'salon','vlcc','indiranagar','beauty services'),(53,'salon','vlcc','kormanagala','beauty'),(54,'salon','vlcc','whitefield','beauty'),(55,'salon','ylg','hsr layout','beauty'),(56,'salon','ylg','indiranagar','beauty'),(57,'salon','ylg','mg road','beauty');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('coaching','subjects','value for money','staff','effectiveness','material','crowd'),('company','domain','salary','work culture','technologies','appraisal','employee satisfaction'),('gym','speciality','value for money','equipments','trainers','ambience',''),('restaurant','cuisine','value for money','food','service','ambience','quality'),('salon','speciality','value for money','staff service','customer satisfaction','quality of product used','');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `coaching`
--

LOCK TABLES `coaching` WRITE;
/*!40000 ALTER TABLE `coaching` DISABLE KEYS */;
INSERT INTO `coaching` VALUES ('byju','hsr layout','iveeshal@gmail.com','CAT',2,4,5,5,1,3.4,NULL,'2015-11-14 02:24:06'),('byju','kormangala','iveeshal@gmail.com','CAT',3,4,5,5,2,5,'','2015-11-14 02:24:06'),('joshi classes','banshankari','iveeshal','Maths',2,4,5,3,1,4,NULL,'2015-11-14 02:24:06'),('KT','hebbal','kusha.pande@gmail.com','chemistry',1,5,5,0,5,4.5,NULL,'2015-11-14 02:24:06'),('rajiv','domloor','kusha.pande@gmail.com','physics',1,3,5,0,1,2,NULL,'2015-11-14 02:24:06'),('RJS','BTM','kusha.pande@gmail.com','big data',4,3,5,4,3,3.5,'okay','2015-11-14 02:24:06'),('varnaaz','banshankari','kusha.pande@gmail.com','software technologies',2,4,3,3,1,0,NULL,'2015-11-26 03:31:37'),('xyz','btm','iveeshal@gmail.com','java',5,5,5,5,5,5,'good','2015-11-23 11:29:08');
/*!40000 ALTER TABLE `coaching` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('glassbeam','mg road','kusha.pande@glassbeam.com','log analytics',2,1,1,1,1,000000000000,NULL,'2015-11-26 03:29:18'),('robert bosch','kormanagala','iveesal@gmail.com','product company',1,5,2,1,5,000000000000,NULL,'2015-11-26 03:29:18'),('tavant technologies','kormangala','kusha.pande@gmail.com','game development',3,3,2,1,3,000000000002,NULL,'2015-11-26 03:29:18'),('ugam solutions','hebbal','kusha.pande@gmail.com','retail analytics',1,5,5,1,3,000000000004,NULL,'2015-11-26 03:29:18');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gym`
--

LOCK TABLES `gym` WRITE;
/*!40000 ALTER TABLE `gym` DISABLE KEYS */;
INSERT INTO `gym` VALUES ('golds gym','hsr layout','iveeshal@gmail.com','fitness',1,5,5,5,0,3.5,NULL,'2015-11-26 03:35:44'),('magnum gym','hsr layout','kusha.pande@gmail.com','fitness',4,3,3,3,0,3.5,'','0000-00-00 00:00:00'),('pink fitness','hsr layout','kusha.pande@gmail.com','fitness',4,3,2,3,0,NULL,NULL,'2015-11-26 03:35:44'),('snap fitness','hsr layout','iveeshal@gmail.com','fitnes',4,5,5,4,0,4,NULL,'2015-11-26 03:35:44');
/*!40000 ALTER TABLE `gym` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `restraurant`
--

LOCK TABLES `restraurant` WRITE;
/*!40000 ALTER TABLE `restraurant` DISABLE KEYS */;
INSERT INTO `restraurant` VALUES ('3\'oh3','indiranagar','kusha.pande@gmail.com','restrobar',5,5,5,5,5,0,NULL,'2015-11-26 01:04:03'),('bakester','indiranagar','kusha.pande@gmail.com','pizza',4,3,4,3,5,5,NULL,'2015-11-14 00:01:54'),('black rabbit','indiranagar','iveeshal@gmail.com','pub',3,2,4,5,5,5,'','2015-11-14 00:59:01'),('cafe masala','MG Road','iveeshal@gmail.com','indian',2,4,5,5,4,0,NULL,'2015-11-14 00:54:40'),('chai patty','indiranagar','iveeshal@gmail.com','snacks',4,3,5,5,3,0,NULL,'2015-11-26 01:01:26'),('fatty bao','indiranagar','kusha.pande@gmail.com','restrobar',5,5,5,5,5,5,NULL,'2015-11-26 01:09:16'),('hard rock cafe','st.marks road','kusha.pande@gmail.com','pub',5,5,5,5,5,5,NULL,'2015-11-26 03:38:58'),('Imly','Indiranagar','kusha.pande@gmail.com','indian',3,4,5,5,3,3,'food not so good','2015-11-13 23:33:57'),('Little Italy','Indiranagar','kusha.pande@gmail.com','italian',2,3,2,5,2,1,'','2015-11-13 23:33:57'),('Little Italy','Indiranagar','iveeshal@gmail.com','italian',1,1,1,1,1,1,NULL,'2015-11-13 23:48:05'),('Little Italy','kormangala','iveeshal@hotmail.com','italian',4,3,5,1,3,0,'','2015-11-13 23:53:44'),('smalllys','frazer town','kusha.pande@gmail.com','restrobar',5,5,5,5,5,5,'','2015-11-26 03:38:58'),('social','church street','kusha.pande@gmail.com','pub',3,5,5,5,5,4.5,'','2015-11-26 03:38:58'),('Stoner','Indiranagar','kusha.pande@gmail.com','ice cream',3,5,5,4,5,5,'okay','2015-11-13 23:36:43'),('stoner','INDIRANAGAR','iveeshal@gmail.com','icecream',5,5,5,0,5,5,NULL,'2015-11-14 01:07:58'),('vapor','indirangar','iveeshal@gmail.com','pub',2,1,4,4,3,5,NULL,'2015-11-14 00:57:20');
/*!40000 ALTER TABLE `restraurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `salon`
--

LOCK TABLES `salon` WRITE;
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
INSERT INTO `salon` VALUES ('bodycraft','indiranagar','kusha.pande@gmail.com','beaunty',5,5,5,5,0,5,NULL,'2015-11-26 01:54:52'),('bodycraft','kormanagala','kusha.pande@gmail.com','spa',3,5,5,5,0,4.5,NULL,'2015-11-26 03:40:18'),('bodycraft','ulsoor','kusha.pande@gmail.com','spa',2,5,5,5,0,5,NULL,'2015-11-26 00:57:18'),('lakme','hsr layout','kusha.pande@gmail.com','beauty',2,2,1,5,0,2,'nothing so great','2015-11-14 01:46:58'),('lakme','kormangala','kusha.pande@gmail.com','beauty',4,3,2,0,0,3,NULL,'2015-11-14 01:46:58'),('rita beauty parlour','kormangala','kusha.pande@gmail.com','beauty',3,5,5,0,0,5,NULL,'2015-11-14 01:46:58'),('shehnaz','indiranagar','kusha.pande@gmail.com','beauty',5,5,5,5,0,5,NULL,'2015-11-14 01:46:58'),('vlcc','indiranagar','kusha.pande@gmail.com','beauty services',5,5,5,5,0,3,'costly','2015-11-14 01:46:58'),('vlcc','kormanagala','kusha.pande@gmail.com','beauty',3,5,5,5,0,4,NULL,'2015-11-14 01:46:58'),('vlcc','whitefield','kusha.pande@gmail.com','beauty',5,4,3,5,0,4,NULL,'2015-11-14 01:46:58'),('ylg','hsr layout','kusha.pande@gmail.com','beauty',2,4,3,2,0,3,'','2015-11-14 01:46:58'),('ylg','indiranagar','kusha.pande@gmail.com','beauty',1,3,4,3,0,3,NULL,'2015-11-14 01:46:58'),('ylg','mg road','kusha.pande@gmail.com','beauty',3,2,3,3,0,2,NULL,NULL);
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-30  1:04:35
