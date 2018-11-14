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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `username` varchar(20) NOT NULL COMMENT '登录名称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `salt` varchar(50) DEFAULT '0' COMMENT '密码的盐',
  `disabled` smallint(6) NOT NULL DEFAULT '1' COMMENT '0、禁用 1、正常',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginname` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `salt`, `disabled`, `createTime`, `lastTime`) VALUES ('1','root','5442b02dabc5ed9401be4dfe1ca8adb9','jonsychen@hotmail.com','r',0,'2016-09-27 19:53:20','2016-09-27 19:53:22');
INSERT INTO `user` (`id`, `username`, `password`, `email`, `salt`, `disabled`, `createTime`, `lastTime`) VALUES ('8891e12f-81a7-43cd-8ab8-4accdf141f96','david','5442b02dabc5ed9401be4dfe1ca8adb9','wsh_8818@163.com','0',1,'2016-10-31 21:16:47',NULL);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `salt`, `disabled`, `createTime`, `lastTime`) VALUES ('aaf62456-d96c-4aae-bff0-90330a7d7a02','frank','52d76781a799f857f35e3bb50c94c21e','jonsychen@hotmail.com','0',0,'2016-11-04 18:12:34',NULL);
INSERT INTO `user` (`id`, `username`, `password`, `email`, `salt`, `disabled`, `createTime`, `lastTime`) VALUES ('e70ddb43-ea5d-431f-bc25-2b455f3e0818','wang','f0c3f84d9701cc2c679e087762a6cdf8','wsh_8818@163.com','&y\"A(.JOVs',0,'2018-11-06 11:03:11',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
