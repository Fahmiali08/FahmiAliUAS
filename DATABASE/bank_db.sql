/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.5-10.1.31-MariaDB : Database - bank_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bank_db`;

/*Table structure for table `tabungan_tbl` */

DROP TABLE IF EXISTS `tabungan_tbl`;

CREATE TABLE `tabungan_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `kredit` int(11) DEFAULT NULL,
  `debet` int(11) DEFAULT NULL,
  `saldo` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=latin1;

/*Data for the table `tabungan_tbl` */

LOCK TABLES `tabungan_tbl` WRITE;

insert  into `tabungan_tbl`(`id`,`nik`,`nama`,`kredit`,`debet`,`saldo`,`create_time`) values (446,'1526','Fahmi Ali',10000000,0,10000000,'2019-09-30 13:54:51'),(447,'1526','Fahmi Ali',0,20000,9980000,'2019-09-30 13:55:09'),(448,'2615','Ninda Try Alviani',12000000,0,12000000,'2019-09-30 13:55:39'),(449,'2615','Ninda Try Alviani',0,2000000,10000000,'2019-09-30 13:56:00'),(450,'1526','Fahmi Ali',10000000,0,19980000,'2019-09-30 13:56:39');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
