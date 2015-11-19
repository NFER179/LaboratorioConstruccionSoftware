-- MySQL dump 10.13  Distrib 5.5.20, for Win32 (x86)
--
-- Host: localhost    Database: pizzeriawild
-- ------------------------------------------------------
-- Server version	5.5.20

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `categoria_id` char(8) NOT NULL DEFAULT '',
  `descripcion` char(100) DEFAULT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES ('BEBIDAS','Bebidas'),('CARNE','Deribados de vaca, pollo y pescado.'),('CEREAL','Productos derivados de cereales ejem. harinas.'),('LACTEO','Categorias para todos los productos derivados de la leche.'),('POSTR','postre'),('VERDU','Productos de Verduleria.');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `nombres` char(50) DEFAULT NULL,
  `apellido` char(30) DEFAULT NULL,
  `direccion` char(50) DEFAULT NULL,
  `tel` char(20) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Pepito','Gomez','Avenida Siempreviva 4323','011-4952-7401'),(2,'Carlos','Perez','Tucuman 400','11-38460249'),(3,'Gaston','Barrionuevo','Cordoba 400','011-15-2573-1592'),(5,'Mauro','Abella','Corrientes 5000','1125794638');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combo`
--

DROP TABLE IF EXISTS `combo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combo` (
  `combo_id` char(20) NOT NULL DEFAULT '',
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `descr` char(30) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`combo_id`,`effdt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo`
--

LOCK TABLES `combo` WRITE;
/*!40000 ALTER TABLE `combo` DISABLE KEYS */;
/*!40000 ALTER TABLE `combo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_delivery` int(11) NOT NULL DEFAULT '0',
  `empleado_id` int(11) DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `obs` mediumtext,
  PRIMARY KEY (`effdt`,`num_delivery`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES ('2015-10-12',1,1,'03:57:47','7i7i7'),('2015-11-17',1,1,'07:11:30',''),('2015-11-17',2,6,'08:36:44','tttttttttttttttttttt'),('2015-11-17',3,7,'08:37:38','ddddddddddddddddddddd');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_venta`
--

DROP TABLE IF EXISTS `delivery_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_venta` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_delivery` int(11) NOT NULL DEFAULT '0',
  `fecha_venta` date DEFAULT NULL,
  `num_venta` int(11) NOT NULL DEFAULT '0',
  `estado` enum('pendiente','entregado','no entregado') DEFAULT NULL,
  `obs_noentregado` char(100) DEFAULT NULL,
  PRIMARY KEY (`effdt`,`num_delivery`,`num_venta`),
  KEY `fecha_venta` (`fecha_venta`,`num_venta`),
  CONSTRAINT `delivery_venta_ibfk_1` FOREIGN KEY (`effdt`, `num_delivery`) REFERENCES `delivery` (`effdt`, `num_delivery`),
  CONSTRAINT `delivery_venta_ibfk_2` FOREIGN KEY (`fecha_venta`, `num_venta`) REFERENCES `venta` (`effdt`, `num_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_venta`
--

LOCK TABLES `delivery_venta` WRITE;
/*!40000 ALTER TABLE `delivery_venta` DISABLE KEYS */;
INSERT INTO `delivery_venta` VALUES ('2015-10-12',1,'2015-11-12',1,'no entregado','grgrg'),('2015-11-17',1,'2015-11-13',1,'entregado',''),('2015-11-17',2,'2015-11-17',1,'entregado',''),('2015-11-17',2,'2015-11-17',2,'entregado',''),('2015-11-17',3,'2015-11-17',3,'entregado','');
/*!40000 ALTER TABLE `delivery_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estilos`
--

DROP TABLE IF EXISTS `estilos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estilos` (
  `id_estilo` char(30) NOT NULL DEFAULT '',
  `codigo` char(200) DEFAULT NULL,
  PRIMARY KEY (`id_estilo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estilos`
--

LOCK TABLES `estilos` WRITE;
/*!40000 ALTER TABLE `estilos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estilos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia_prima`
--

DROP TABLE IF EXISTS `materia_prima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia_prima` (
  `materia_prima` char(50) NOT NULL DEFAULT '',
  `unidad` enum('Kg','Lts','Unidad') DEFAULT NULL,
  PRIMARY KEY (`materia_prima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_prima`
--

LOCK TABLES `materia_prima` WRITE;
/*!40000 ALTER TABLE `materia_prima` DISABLE KEYS */;
INSERT INTO `materia_prima` VALUES ('AtÃƒÂºn','Kg'),('coca 2l x 8','Unidad'),('crma','Lts'),('Cuadril','Kg'),('Harina 000','Kg'),('Harina Integral','Kg'),('Leche Descremada','Lts'),('Leche Larga Vida','Lts'),('Pechuga','Kg'),('Rucula','Kg'),('Tomate','Kg'),('Tomate Cherry','Kg'),('Tomate en Lata','Unidad'),('tomatosss','Kg');
/*!40000 ALTER TABLE `materia_prima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mp_categoria`
--

DROP TABLE IF EXISTS `mp_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mp_categoria` (
  `categoria_id` char(8) NOT NULL DEFAULT '',
  `materia_prima` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`categoria_id`,`materia_prima`),
  KEY `materia_prima` (`materia_prima`),
  CONSTRAINT `mp_categoria_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`categoria_id`),
  CONSTRAINT `mp_categoria_ibfk_2` FOREIGN KEY (`materia_prima`) REFERENCES `materia_prima` (`materia_prima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mp_categoria`
--

LOCK TABLES `mp_categoria` WRITE;
/*!40000 ALTER TABLE `mp_categoria` DISABLE KEYS */;
INSERT INTO `mp_categoria` VALUES ('CARNE','AtÃƒÂºn'),('BEBIDAS','coca 2l x 8'),('POSTR','crma'),('CARNE','Cuadril'),('CEREAL','Harina 000'),('CEREAL','Harina Integral'),('LACTEO','Leche Descremada'),('LACTEO','Leche Larga Vida'),('CARNE','Pechuga'),('VERDU','Rucula'),('VERDU','Tomate'),('VERDU','Tomate Cherry'),('VERDU','Tomate en Lata'),('VERDU','tomatosss');
/*!40000 ALTER TABLE `mp_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mp_proveedor`
--

DROP TABLE IF EXISTS `mp_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mp_proveedor` (
  `proveedor_id` char(11) NOT NULL DEFAULT '',
  `categoria_id` char(8) NOT NULL DEFAULT '',
  `materia_prima` char(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`proveedor_id`,`categoria_id`,`materia_prima`),
  KEY `categoria_id` (`categoria_id`,`materia_prima`),
  CONSTRAINT `mp_proveedor_ibfk_1` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`proveedor_id`),
  CONSTRAINT `mp_proveedor_ibfk_2` FOREIGN KEY (`categoria_id`, `materia_prima`) REFERENCES `mp_categoria` (`categoria_id`, `materia_prima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mp_proveedor`
--

LOCK TABLES `mp_proveedor` WRITE;
/*!40000 ALTER TABLE `mp_proveedor` DISABLE KEYS */;
INSERT INTO `mp_proveedor` VALUES ('HEREFORD','CARNE','Cuadril'),('HEREFORD','CARNE','Pechuga'),('TRESTRIGOS','CEREAL','Harina 000'),('SERENISIMA','LACTEO','Leche Larga Vida'),('COTOPROV','VERDU','Tomate');
/*!40000 ALTER TABLE `mp_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_pedido` int(11) NOT NULL DEFAULT '0',
  `estado` enum('Guardado','Enviado','Recibido') DEFAULT NULL,
  `fecha_envio` date DEFAULT NULL,
  `ref_num_pedido` int(11) DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `costo` int(11) DEFAULT NULL,
  PRIMARY KEY (`effdt`,`num_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES ('2015-07-21',1,'Recibido','2015-07-21',1,'2015-11-13',1000),('2015-10-01',1,'Guardado','2015-10-01',1,'2015-10-04',120);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_mp`
--

DROP TABLE IF EXISTS `pedido_mp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_mp` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_pedido` int(11) NOT NULL DEFAULT '0',
  `materia_prima` char(50) NOT NULL DEFAULT '',
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`effdt`,`num_pedido`,`materia_prima`),
  KEY `materia_prima` (`materia_prima`),
  CONSTRAINT `pedido_mp_ibfk_1` FOREIGN KEY (`effdt`, `num_pedido`) REFERENCES `pedido` (`effdt`, `num_pedido`),
  CONSTRAINT `pedido_mp_ibfk_2` FOREIGN KEY (`materia_prima`) REFERENCES `materia_prima` (`materia_prima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_mp`
--

LOCK TABLES `pedido_mp` WRITE;
/*!40000 ALTER TABLE `pedido_mp` DISABLE KEYS */;
INSERT INTO `pedido_mp` VALUES ('2015-07-21',1,'Harina 000',100),('2015-07-21',1,'Harina Integral',30),('2015-10-01',1,'Cuadril',70),('2015-10-01',1,'Pechuga',50);
/*!40000 ALTER TABLE `pedido_mp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_proveedor`
--

DROP TABLE IF EXISTS `pedido_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_proveedor` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_pedido` int(11) NOT NULL DEFAULT '0',
  `proveedor_id` char(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`effdt`,`num_pedido`,`proveedor_id`),
  KEY `proveedor_id` (`proveedor_id`),
  CONSTRAINT `pedido_proveedor_ibfk_1` FOREIGN KEY (`effdt`, `num_pedido`) REFERENCES `pedido` (`effdt`, `num_pedido`),
  CONSTRAINT `pedido_proveedor_ibfk_2` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedor` (`proveedor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_proveedor`
--

LOCK TABLES `pedido_proveedor` WRITE;
/*!40000 ALTER TABLE `pedido_proveedor` DISABLE KEYS */;
INSERT INTO `pedido_proveedor` VALUES ('2015-10-01',1,'HEREFORD'),('2015-07-21',1,'TRESTRIGOS');
/*!40000 ALTER TABLE `pedido_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `product_id` char(4) NOT NULL DEFAULT '',
  `descripcion` char(100) DEFAULT NULL,
  `mixta` char(1) DEFAULT NULL,
  `cocina` char(1) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('BEBI','Bebida','N','N'),('EMPA','Empanada','N','Y'),('FAIN','Faina','N','Y'),('PIZZ','Pizza','Y','Y'),('test','sssseeee','Y','N');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_combo`
--

DROP TABLE IF EXISTS `producto_combo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_combo` (
  `combo_id` char(20) NOT NULL DEFAULT '',
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `product_id` char(4) NOT NULL DEFAULT '',
  `sabor` char(100) NOT NULL DEFAULT '',
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`combo_id`,`effdt`,`product_id`,`sabor`),
  KEY `product_id` (`product_id`,`sabor`),
  CONSTRAINT `producto_combo_ibfk_1` FOREIGN KEY (`combo_id`, `effdt`) REFERENCES `combo` (`combo_id`, `effdt`),
  CONSTRAINT `producto_combo_ibfk_2` FOREIGN KEY (`product_id`, `sabor`) REFERENCES `sabor_producto` (`product_id`, `sabor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_combo`
--

LOCK TABLES `producto_combo` WRITE;
/*!40000 ALTER TABLE `producto_combo` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_combo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `proveedor_id` char(11) NOT NULL DEFAULT '',
  `nombre` char(100) DEFAULT NULL,
  `telefono` char(20) DEFAULT NULL,
  `mail` char(30) DEFAULT NULL,
  `activo` char(1) DEFAULT NULL,
  PRIMARY KEY (`proveedor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('COTOPROV','Proveedor de cadena supermercado COTO','39279517','cotopedido@coto.com.ar','Y'),('HEREFORD','Carniceria Hereford','0237-462946','g.perez@gmail.com.ar','Y'),('SANCOR','Sancor SA.','907548264','pedido@sancor.com.ar','N'),('SERENISIMA','La Serenisima SA.','3571949572','pedidos@serenicima.com','Y'),('TRESTRIGOS','Molino Tres Trigos','392-24-61-6','pedido@molinos.com.ar','Y');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repartidor`
--

DROP TABLE IF EXISTS `repartidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repartidor` (
  `empleado_id` int(11) NOT NULL DEFAULT '0',
  `nombre` char(30) DEFAULT NULL,
  `apellido` char(30) DEFAULT NULL,
  `tel` char(14) DEFAULT NULL,
  `direccion` char(30) DEFAULT NULL,
  `vehiculo_id` char(10) DEFAULT NULL,
  `tipo_vehiculo` char(20) DEFAULT NULL,
  `modelo_vehiculo` char(30) DEFAULT NULL,
  `activo` char(1) DEFAULT NULL,
  PRIMARY KEY (`empleado_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repartidor`
--

LOCK TABLES `repartidor` WRITE;
/*!40000 ALTER TABLE `repartidor` DISABLE KEYS */;
INSERT INTO `repartidor` VALUES (1,'Rene','Gado','12344321','Cercano','fwi 154','auto','Audi R8','Y'),(2,'Alfredo','Bolt','98766789','Lejos','teh 057','moto','Yamaha R1','Y'),(3,'nicolas daniel','fernandez','661449730','bolivia 2577','fui154','auto','audi R8','N'),(4,'dwd','qf','sdffeq','now','noqwd','ob','foen','Y'),(5,'ddd','ddd','3333','fewwf','eef223','2342','23e3e','Y'),(6,'damian','Perez','662539047','pasteur','ejf294','porche','auto','Y'),(7,'damian','perez','23472693','didide','dhe926','ferrari','deportivo','Y');
/*!40000 ALTER TABLE `repartidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sabor_producto`
--

DROP TABLE IF EXISTS `sabor_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sabor_producto` (
  `product_id` char(4) NOT NULL DEFAULT '',
  `sabor` char(100) NOT NULL DEFAULT '',
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`,`sabor`),
  CONSTRAINT `sabor_producto_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `producto` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sabor_producto`
--

LOCK TABLES `sabor_producto` WRITE;
/*!40000 ALTER TABLE `sabor_producto` DISABLE KEYS */;
INSERT INTO `sabor_producto` VALUES ('BEBI','Coca-Cola 1,5 Lts',16),('BEBI','Coca-Cola 600 cc',11),('EMPA','Frita Carne Cortada a Cuchillo',8),('EMPA','Horno Carne Cortada a Cuchillo',8),('EMPA','Horno Carnes Picada',7),('FAIN','Apio',7),('PIZZ','Crudo y Tomates Cherry',120),('PIZZ','Muzzarella',100),('test','test',54),('test','tet',32);
/*!40000 ALTER TABLE `sabor_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_venta` int(11) NOT NULL DEFAULT '0',
  `cliente` char(80) DEFAULT NULL,
  `direccion` char(50) DEFAULT NULL,
  `tel_cliente` char(20) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `estado` enum('Pendiente','Armado','Viaje','Cancelado','Facturado') DEFAULT NULL,
  `observaciones` mediumtext,
  `delivery` char(1) DEFAULT NULL,
  `obs_delivery` mediumtext,
  PRIMARY KEY (`effdt`,`num_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES ('2015-07-21',1,'nicolas','bolivia 2577','011-15-66149730',120,'22:27:36','Pendiente','ninguna.','N',''),('2015-11-12',1,'Gomez Pepito','Avenida Siempreviva 4323','011-4952-7401',33,'03:57:33','Cancelado','','Y',''),('2015-11-13',1,'Perez Carlos','Tucuman 400','11-38460249',3361,'07:18:34','Facturado','','Y','ojo con el perro'),('2015-11-17',1,'Abella Mauro','Corrientes 5000','1125794638',14208,'08:35:43','Facturado','ede','Y','eeee'),('2015-11-17',2,'Perez Carlos','Tucuman 400','11-38460249',512,'08:36:02','Facturado','dedd','Y','eeerfrtrf'),('2015-11-17',3,'Perez Carlos','Tucuman 400','11-38460249',70,'08:36:59','Facturado','','Y','amantte de la faina');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta_producto`
--

DROP TABLE IF EXISTS `venta_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta_producto` (
  `effdt` date NOT NULL DEFAULT '0000-00-00',
  `num_venta` int(11) NOT NULL DEFAULT '0',
  `producto` char(4) NOT NULL DEFAULT '',
  `sabor` char(250) NOT NULL DEFAULT '',
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`effdt`,`num_venta`,`producto`,`sabor`),
  KEY `producto` (`producto`,`sabor`),
  CONSTRAINT `venta_producto_ibfk_1` FOREIGN KEY (`effdt`, `num_venta`) REFERENCES `venta` (`effdt`, `num_venta`),
  CONSTRAINT `venta_producto_ibfk_2` FOREIGN KEY (`producto`, `sabor`) REFERENCES `sabor_producto` (`product_id`, `sabor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta_producto`
--

LOCK TABLES `venta_producto` WRITE;
/*!40000 ALTER TABLE `venta_producto` DISABLE KEYS */;
INSERT INTO `venta_producto` VALUES ('2015-11-12',1,'BEBI','Coca-Cola 600 cc',3),('2015-11-13',1,'BEBI','Coca-Cola 1,5 Lts',23),('2015-11-13',1,'FAIN','Apio',99),('2015-11-13',1,'PIZZ','Muzzarella',23),('2015-11-17',1,'test','tet',444),('2015-11-17',2,'BEBI','Coca-Cola 1,5 Lts',2),('2015-11-17',2,'PIZZ','Crudo y Tomates Cherry',4),('2015-11-17',3,'FAIN','Apio',10);
/*!40000 ALTER TABLE `venta_producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-17 20:43:02
