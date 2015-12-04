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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-30  1:02:37
