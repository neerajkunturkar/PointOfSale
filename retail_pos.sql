-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: pos
-- ------------------------------------------------------
-- Server version	5.5.43

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
-- Table structure for table `cart_detail`
--

DROP TABLE IF EXISTS `cart_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `invoice_no` varchar(255) NOT NULL,
  `status` varchar(64) NOT NULL,
  `bill_date` date NOT NULL,
  `total_amount` double(10,2) DEFAULT '0.00',
  `total_items` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_detail`
--

LOCK TABLES `cart_detail` WRITE;
/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_product_detail`
--

DROP TABLE IF EXISTS `cart_product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_product_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `cart_detail_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `quantity` int(10) NOT NULL,
  `total_price` double(7,2) DEFAULT NULL,
  `unit_tax` double(7,2) DEFAULT NULL,
  `unit_price` double(7,2) DEFAULT NULL,
  `total_tax` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cartItemFK` (`product_id`),
  KEY `cartDetailFK` (`cart_detail_id`),
  CONSTRAINT `cartDetailFKConst` FOREIGN KEY (`cart_detail_id`) REFERENCES `cart_detail` (`id`),
  CONSTRAINT `cartItemFKConst` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_product_detail`
--

LOCK TABLES `cart_product_detail` WRITE;
/*!40000 ALTER TABLE `cart_product_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pcode` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2018-04-12 23:43:53','2018-04-12 23:43:53',1,1,'\0','P00000001','Product 1'),(2,'2018-04-12 23:43:53','2018-04-12 23:43:53',1,1,'\0','P00000002','Product 2'),(3,'2018-04-14 14:53:48','2018-04-14 14:53:48',1,1,'\0','PEP0001','PEPSI COLD DRINK'),(4,'2018-04-14 14:53:48','2018-04-14 14:53:48',1,1,'\0','WHL1983','WHEEL GREEN BAR'),(5,'2018-04-14 14:53:48','2018-04-14 14:53:48',1,1,'\0','PEARS23349','PEARS SOAP'),(6,'2018-04-14 14:53:48','2018-04-14 14:53:48',1,1,'\0','ALLO8253','ALL OUT MSQTO');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_price`
--

DROP TABLE IF EXISTS `product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `price` double(7,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_price`
--

LOCK TABLES `product_price` WRITE;
/*!40000 ALTER TABLE `product_price` DISABLE KEYS */;
INSERT INTO `product_price` VALUES (1,'2018-04-14 15:12:07','2018-04-14 15:12:07',1,1,'\0',199.99),(2,'2018-04-14 15:12:07','2018-04-14 15:12:07',1,1,'\0',86.50),(3,'2018-04-14 15:12:07','2018-04-14 15:12:07',1,1,'\0',5.00),(4,'2018-04-14 15:12:07','2018-04-14 15:12:07',1,1,'\0',9.99),(5,'2018-04-14 15:15:40','2018-04-14 15:15:40',1,1,'\0',122.50),(6,'2018-04-14 15:15:40','2018-04-14 15:15:40',1,1,'\0',50.00),(7,'2018-04-14 15:15:40','2018-04-14 15:15:40',1,1,'\0',75.00),(8,'2018-04-14 15:15:40','2018-04-14 15:15:40',1,1,'\0',140.00);
/*!40000 ALTER TABLE `product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_sku`
--

DROP TABLE IF EXISTS `product_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `sku` varchar(255) NOT NULL,
  `sku_code` varchar(255) NOT NULL,
  `sku_description` varchar(512) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isku_code` (`sku_code`),
  KEY `skuProductFK` (`product_id`),
  KEY `isku_prd` (`sku`,`product_id`),
  KEY `iskuprd` (`product_id`),
  CONSTRAINT `skuProductFKConst` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sku`
--

LOCK TABLES `product_sku` WRITE;
/*!40000 ALTER TABLE `product_sku` DISABLE KEYS */;
INSERT INTO `product_sku` VALUES (1,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','PEPSI ZERO SUGAR 500 ML','PEPZERSUG','PEPSI ZERO SUGAR 500 ML',3),(2,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','PEPSI ZERO SUGAR 1L','PEPZERSUG1L','PEPSI ZERO SUGAR 1L',3),(3,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','PEPSI ZERO SUGAR DIET 1L','PEPZERSUGD1L','PEPSI ZERO SUGAR DIET 1L',3),(4,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','PEPSI ZERO SUGAR DIET 500 ML','PEPZERSUGD','PEPSI ZERO SUGAR DIET 500 ML',3),(5,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','WHEEL GREEN BAR RS.10','WHGB10','WHEEL GREEN BAR RS.10',4),(6,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','WHEEL GREEN BAR RS.5','WHGB5','WHEEL GREEN BAR RS.5',4),(7,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','PEARS PACK OF 4','PEARSPCK4','PEARS PACK OF 4',5),(8,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','PEARS SOAP','PEARS','PEARS SOAP',5),(9,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','ALL OUT REFILL PACK OF 3','ALLOUTPCK3','ALL OUT REFILL PACK OF 3',6),(10,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','ALL OUT REFILL PACK OF 2','ALLOUTPCK2','ALL OUT REFILL PACK OF 2',6),(11,'2018-04-14 14:59:25','2018-04-14 14:59:25',1,1,'\0','ALL OUT COMBI','ALLOUTCMBI','ALL OUT COMBI',6);
/*!40000 ALTER TABLE `product_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_upc`
--

DROP TABLE IF EXISTS `product_upc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_upc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `upc` varchar(255) NOT NULL,
  `product_sku_id` bigint(20) NOT NULL,
  `inventory_stock` int(10) DEFAULT '0',
  `product_price_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `skuUpcProductFK` (`product_sku_id`),
  CONSTRAINT `skuUpcProductFKConst` FOREIGN KEY (`product_sku_id`) REFERENCES `product_sku` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_upc`
--

LOCK TABLES `product_upc` WRITE;
/*!40000 ALTER TABLE `product_upc` DISABLE KEYS */;
INSERT INTO `product_upc` VALUES (1,'2018-04-14 15:09:17','2018-04-15 11:20:31',1,1,'\0','49000 01134',1,40,7),(2,'2018-04-14 15:09:17','2018-04-15 17:07:20',1,2,'\0','12345 5477',2,36,5),(3,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','12000 0859',3,50,2),(4,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','1414 99999',4,50,5),(5,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','52000 33864',5,50,4),(6,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','36093 01005',6,50,3),(7,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','23756 54854',7,50,2),(8,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','35380468438',8,50,6),(9,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','25386 0258',9,50,1),(10,'2018-04-14 15:09:17','2018-04-15 17:07:50',1,2,'\0','2358 454854',10,42,5),(11,'2018-04-14 15:09:17','2018-04-14 15:09:17',1,1,'\0','3587 0240',11,50,8);
/*!40000 ALTER TABLE `product_upc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax_bracket`
--

DROP TABLE IF EXISTS `tax_bracket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tax_bracket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `product_id` bigint(20) NOT NULL,
  `applicable_tax` double(10,2) DEFAULT '0.00',
  `unit` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `taxProdFK` (`product_id`),
  CONSTRAINT `taxProdFKConst` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax_bracket`
--

LOCK TABLES `tax_bracket` WRITE;
/*!40000 ALTER TABLE `tax_bracket` DISABLE KEYS */;
INSERT INTO `tax_bracket` VALUES (1,'2018-04-15 16:36:15','2018-04-15 16:36:15',1,1,'\0',3,10.00,'PERCENTAGE'),(2,'2018-04-15 18:29:06','2018-04-15 18:29:06',1,1,'\0',5,25.00,'PERCENTAGE');
/*!40000 ALTER TABLE `tax_bracket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(512) DEFAULT 'niraj',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'ABC'),(2,'DEF'),(3,'GHI'),(4,'JKL');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(512) NOT NULL,
  `email` varchar(512) NOT NULL,
  `mobile_no` varchar(512) NOT NULL,
  `auth_token` varchar(512) DEFAULT NULL,
  `last_login_date` date DEFAULT NULL,
  `locale` varchar(255) DEFAULT NULL,
  `role` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2018-04-12 12:03:27','2018-04-12 12:03:27',1,1,'\0','admin','5f4dcc3b5aa765d61d8327deb882cf99','admin@pl.com','1234509876',NULL,NULL,NULL,NULL),(3,'2018-04-13 00:43:43','2018-04-15 18:23:24',1,3,'\0','niraj','5f4dcc3b5aa765d61d8327deb882cf99','nk@pl.com','1234569870','Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuaXJhaiIsImV4cCI6MTUyNDY2MDgwNH0.WyoIaBB_8AIXeHGMqrYotk_MUTWt_ZM7m4OcUZy-AD0my40NPdgA0uatsQDeG75lKxMbqOvNMw0oQqPSE8Gqfw','2018-04-15','en','USER'),(4,'2018-04-15 16:32:42','2018-04-15 18:24:41',1,4,'\0','avinash','5f4dcc3b5aa765d61d8327deb882cf99','at@pl.com','1234567890','Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhdmluYXNoIiwiZXhwIjoxNTI0NjYwODgxfQ.yo8ZJRKN5rOCSRgPiEYEgyIzdsFLSKLud4KXka5Uqt9XJ36ELsf4coavvPiMLZTcstXZfwPH1G-yE37_I6sPVQ','2018-04-15','fr','USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pos'
--

--
-- Dumping routines for database 'pos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 19:02:39
