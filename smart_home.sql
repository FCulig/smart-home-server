/*
SQLyog Community v12.09 (64 bit)
MySQL - 8.0.15 : Database - smart_home
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smart_home` /*!40100 DEFAULT CHARACTER SET ascii COLLATE ascii_bin */;

USE `smart_home`;

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `id` bigint(20) NOT NULL,
  `mac` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  `name` varchar(255) COLLATE ascii_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

/*Data for the table `device` */

insert  into `device`(`id`,`mac`,`name`) values (14,NULL,NULL),(15,NULL,NULL),(16,NULL,NULL),(17,'test',NULL),(18,'test',NULL);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (19);

/*Table structure for table `temperature` */

DROP TABLE IF EXISTS `temperature`;

CREATE TABLE `temperature` (
  `id` bigint(20) NOT NULL,
  `recorded_at` datetime(6) DEFAULT NULL,
  `temperature` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

/*Data for the table `temperature` */

insert  into `temperature`(`id`,`recorded_at`,`temperature`) values (1,'2020-09-25 14:58:24.930000',22.3),(2,'2020-09-25 14:58:27.893000',22.3),(3,'2020-09-25 14:58:28.646000',22.3),(4,'2020-09-25 14:58:29.197000',22.3),(5,'2020-09-25 14:58:29.715000',22.3),(6,'2020-10-03 08:55:37.182000',22.3),(7,'2020-10-03 08:55:40.253000',22.3),(8,'2020-10-03 08:55:41.317000',22.3),(9,'2020-10-03 08:55:42.001000',22.3),(10,'2020-10-03 08:55:42.646000',22.3),(11,'2020-10-03 08:55:43.216000',22.3),(12,'2020-10-03 08:55:43.740000',22.3),(13,'2020-10-03 08:55:44.287000',22.3);

/* Procedure structure for procedure `GET_ALL_TEMPERATURES` */

/*!50003 DROP PROCEDURE IF EXISTS  `GET_ALL_TEMPERATURES` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_ALL_TEMPERATURES`()
BEGIN  
	SELECT * FROM `temperature`; 
	END */$$
DELIMITER ;

/* Procedure structure for procedure `GET_DEVICE_WITH_MAC` */

/*!50003 DROP PROCEDURE IF EXISTS  `GET_DEVICE_WITH_MAC` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_DEVICE_WITH_MAC`(IN in_mac Varchar(255))
BEGIN  
	SELECT * FROM `device` where `mac` = in_mac; 
	END */$$
DELIMITER ;

/* Procedure structure for procedure `GET_TEMPERATURES_AFTER` */

/*!50003 DROP PROCEDURE IF EXISTS  `GET_TEMPERATURES_AFTER` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_TEMPERATURES_AFTER`(IN start_time datetime)
BEGIN  
	SELECT * FROM `temperature` where `recorded_at` > start_time; 
	END */$$
DELIMITER ;

/* Procedure structure for procedure `GET_TEMPERATURES_BEFORE` */

/*!50003 DROP PROCEDURE IF EXISTS  `GET_TEMPERATURES_BEFORE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_TEMPERATURES_BEFORE`(IN start_time datetime)
BEGIN  
	SELECT * FROM `temperature` where `recorded_at` < start_time; 
	END */$$
DELIMITER ;

/* Procedure structure for procedure `GET_TEMPERATURES_BETWEEN` */

/*!50003 DROP PROCEDURE IF EXISTS  `GET_TEMPERATURES_BETWEEN` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_TEMPERATURES_BETWEEN`(IN start_time datetime, IN end_time datetime)
BEGIN  
	SELECT * FROM `temperature` where `recorded_at` > start_time and `recorded_at` < end_time; 
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
