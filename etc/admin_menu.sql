-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: admin
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` varchar(50) NOT NULL,
  `label` varchar(20) NOT NULL,
  `path` varchar(200) DEFAULT '0',
  `order` smallint(6) DEFAULT '1',
  `level` smallint(6) DEFAULT '1' COMMENT '层级，方便根据层级查询',
  `url` varchar(200) DEFAULT NULL,
  `type` smallint(6) DEFAULT '1' COMMENT '扩展不同菜单时用',
  `style` varchar(50) DEFAULT NULL COMMENT 'ui 样式',
  `disabled` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('51','Job Manager','0,quartzmanager',51,2,'/quartz/list',0,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('approval','Approval','0,checker',32,2,'/approval',1,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('checker','CHECKER','0',3,1,'/checker',1,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('maker','MAKER','0',2,1,'/maker',1,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('menu','Memu Management','0,system',2,1,'/menu',0,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('quartzmanager','QUARTZ MANAGEMENT','0',41,1,'/',1,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('registration','Registration','0,maker',1,2,'/register',1,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('role','Role Management','0,system',3,3,'/role',0,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('system','SYSTEM MANAGEMENT','0',1,1,'/',0,NULL,0);
INSERT INTO `menu` (`id`, `label`, `path`, `order`, `level`, `url`, `type`, `style`, `disabled`) VALUES ('user','User Management','0,system',4,2,'/user',0,NULL,0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-14 10:59:36
