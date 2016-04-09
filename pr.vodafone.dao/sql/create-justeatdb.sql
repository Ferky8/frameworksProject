-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: justeat
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Current Database: `justeat`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `justeat` /*!40100 DEFAULT CHARACTER SET latin1 */;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON justeat.*
           TO asf@'%'
           IDENTIFIED BY 'asf';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON justeat.*
           TO asf@localhost
           IDENTIFIED BY 'asf';

USE `justeat`;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('111','Marta Lopez','C\\Iparraguirre 4','marta@gmail.com'),('222','Aitor Angulo','Avda. Madariaga 5, Bilbao','aitor@gmail.com'),('333','Monica Fernandez','C\\Correos 5, Portugalete','monica@gmail.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementos`
--

DROP TABLE IF EXISTS `elementos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementos` (
  `idElemento` int(11) NOT NULL auto_increment,
  `cantidad` int(3) NOT NULL,
  `nombre` varchar(45) default NULL,
  `importe` float NOT NULL,
  `pedido` int(11) NOT NULL,
  PRIMARY KEY  (`idElemento`),
  KEY `pedido` (`pedido`),
  CONSTRAINT `pedido` FOREIGN KEY (`pedido`) REFERENCES `pedidos` (`idPedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementos`
--

LOCK TABLES `elementos` WRITE;
/*!40000 ALTER TABLE `elementos` DISABLE KEYS */;
INSERT INTO `elementos` VALUES (1,3,'Pinchos morunos',14.0,666111000),(2,2,'Gambas',9.5,666111000),(3,1,'Arroz',8.0,666111000),(4,2,'Pastinacas',20.0,666111111),(5,2,'Lentejas',30.0,666222000),(6,3,'Solomillos',30.0,666222000),(7,4,'Croquetas',30.0,666222000),(8,2,'Cardo',30.0,666222000);
/*!40000 ALTER TABLE `elementos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL auto_increment,
  `restaurante` varchar(15) NOT NULL,
  `fecha` varchar(10) default NULL,
  `entregado` tinyint(1) NOT NULL,
  `tipoEntrega` varchar(45) default NULL,
  `tipoPago` varchar(45) default NULL,
  `promocion` varchar(100) default NULL,
  `dni` varchar(8) NOT NULL,
  PRIMARY KEY  (`idPedido`),
  KEY `cliente` (`dni`),
  CONSTRAINT `dni` FOREIGN KEY (`dni`) REFERENCES `clientes` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  KEY `restaurante` (`restaurante`),
  CONSTRAINT `restaurante` FOREIGN KEY (`restaurante`) REFERENCES `restaurantes` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (666111000,'1','2006-08-03',1,'Urgente','Metalico','Ninguna','111'),(666111111,'2','2009-01-01',0,'Normal','Tarjeta','3 por 2','111'),(666222000,'1','2010-03-01',0,NULL,NULL,'Ninguna','222'),(666333000,'3','2005-11-20',1,'Horaria','Metalico','50% en verduras','333');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantes`
--

DROP TABLE IF EXISTS `restaurantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantes` (
  `idRestaurante` varchar(15) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipoComida` varchar(45) NOT NULL,
  `precioMedio` float NOT NULL,
  `puntuacion` float default NULL,
  `tiempoMedio` float default NULL,
  `ofertaActual` float default NULL,
  PRIMARY KEY  (`idRestaurante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantes`
--

LOCK TABLES `restaurantes` WRITE;
/*!40000 ALTER TABLE `restaurantes` DISABLE KEYS */;
INSERT INTO `restaurantes` VALUES ('1','Casa Paco','Tradicional',30.0,8.5,40,0.0),('2','Casa Vicky','Innovadora',20.0,9,50,0.1),('3','La mandarra','Experimental',25.0,9.5,40,0.05);
/*!40000 ALTER TABLE `restaurantes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-12-29 20:23:50
