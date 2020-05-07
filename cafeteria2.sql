-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for cafeteria2
CREATE DATABASE IF NOT EXISTS `cafeteria2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cafeteria2`;

-- Dumping structure for table cafeteria2.acceso
CREATE TABLE IF NOT EXISTS `acceso` (
  `idAcceso` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` tinyint(4) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idAcceso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.acceso: ~2 rows (approximately)
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT IGNORE INTO `acceso` (`idAcceso`, `Codigo`, `Nombre`) VALUES
	(1, 1, 'Administrador'),
	(2, 2, 'Vendedor');
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;

-- Dumping structure for table cafeteria2.cargar
CREATE TABLE IF NOT EXISTS `cargar` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime DEFAULT NULL,
  `Total` float DEFAULT NULL,
  PRIMARY KEY (`idCompra`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.cargar: ~38 rows (approximately)
/*!40000 ALTER TABLE `cargar` DISABLE KEYS */;
INSERT IGNORE INTO `cargar` (`idCompra`, `Fecha`, `Total`) VALUES
	(1, '2020-05-06 00:00:00', 2976.6),
	(2, '2020-05-06 21:58:10', 482.79),
	(3, '2020-05-06 22:05:50', 1198.8),
	(4, '2020-05-07 00:30:08', 0),
	(5, '2020-05-07 00:33:28', 180),
	(6, '2020-05-07 00:53:00', 0),
	(7, '2020-05-07 00:54:30', 0),
	(8, '2020-05-07 00:56:22', 79.92),
	(9, '2020-05-07 06:58:47', 70.97),
	(10, '2020-05-07 07:08:56', 136.53),
	(11, '2020-05-07 07:10:46', 497.8),
	(12, '2020-05-07 07:17:36', 1218.09),
	(14, '2020-05-07 08:05:18', 0),
	(15, '2020-05-07 08:07:16', 0),
	(16, '2020-05-07 08:08:27', 0),
	(17, '2020-05-07 08:10:05', 0),
	(18, '2020-05-07 08:11:56', 0),
	(19, '2020-05-07 08:14:32', 0),
	(20, '2020-05-07 08:17:22', 0),
	(22, '2020-05-07 08:25:30', 0),
	(23, '2020-05-07 08:27:46', 0),
	(24, '2020-05-07 08:29:00', 0),
	(25, '2020-05-07 09:39:34', 0),
	(26, '2020-05-07 09:40:40', 0),
	(27, '2020-05-07 09:44:16', 0),
	(29, '2020-05-07 09:47:24', 0),
	(30, '2020-05-07 09:48:18', 0),
	(31, '2020-05-07 09:49:21', 0),
	(32, '2020-05-07 09:50:11', 0),
	(33, '2020-05-07 09:53:15', 0),
	(34, '2020-05-07 10:30:11', 200),
	(35, '2020-05-07 10:31:04', 25),
	(36, '2020-05-07 14:37:57', 200),
	(38, '2020-05-07 15:15:37', 4),
	(39, '2020-05-07 15:15:58', 4),
	(42, '2020-05-07 15:37:51', 30),
	(46, '2020-05-07 17:22:05', 50),
	(47, '2020-05-07 17:38:22', 0);
/*!40000 ALTER TABLE `cargar` ENABLE KEYS */;

-- Dumping structure for table cafeteria2.cierre
CREATE TABLE IF NOT EXISTS `cierre` (
  `idCierre` int(11) NOT NULL AUTO_INCREMENT,
  `TotCargo` float DEFAULT NULL,
  `TotVenta` float DEFAULT NULL,
  `Utilidad` float DEFAULT NULL,
  `FechaCierre` datetime NOT NULL,
  PRIMARY KEY (`idCierre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.cierre: ~3 rows (approximately)
/*!40000 ALTER TABLE `cierre` DISABLE KEYS */;
INSERT IGNORE INTO `cierre` (`idCierre`, `TotCargo`, `TotVenta`, `Utilidad`, `FechaCierre`) VALUES
	(1, 130, 200, -70, '2020-05-07 14:48:42'),
	(2, 174, 4, 170, '2020-05-07 15:19:05'),
	(3, 174, 50, 124, '2020-05-07 17:23:55');
/*!40000 ALTER TABLE `cierre` ENABLE KEYS */;

-- Dumping structure for table cafeteria2.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL,
  `Telefono` varchar(8) DEFAULT NULL,
  `Nit` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.cliente: ~4 rows (approximately)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT IGNORE INTO `cliente` (`idCliente`, `Nombre`, `Direccion`, `Telefono`, `Nit`) VALUES
	(1, 'Donald', '+5021234-4567', '1239875', 123456),
	(2, 'Kelvin', 'D', '56565', 56896),
	(3, 'Erick', 'Xela', '45678996', 1234589),
	(4, 'Luis', 'Huehue', '45678996', 1234567);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Dumping structure for function cafeteria2.crearUsuario
DELIMITER //
CREATE FUNCTION `crearUsuario`(
	`vUsername` VARCHAR(30),
	`vClave` TINYTEXT,
	`vAcceso` INT
) RETURNS int(11)
BEGIN
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE Nombre=vUsername INTO cuenta;
    IF cuenta=0 THEN
		INSERT INTO usuario (Nombre,contrasenia,Acceso_idAcceso) VALUES (vUsername,MD5(vClave),vAcceso);
        RETURN 1;
	ELSE
		RETURN 0;
	END IF;
	RETURN -1;
END//
DELIMITER ;

-- Dumping structure for table cafeteria2.detallecompra
CREATE TABLE IF NOT EXISTS `detallecompra` (
  `idDC` int(11) NOT NULL AUTO_INCREMENT,
  `Costo` float DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Subtotal` float DEFAULT NULL,
  `compra_idCompra` int(11) NOT NULL,
  `menu_idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idDC`),
  KEY `fk_detalleCompra_compra1_idx` (`compra_idCompra`),
  KEY `fk_detalleCompra_menu1_idx` (`menu_idProducto`),
  CONSTRAINT `fk_detalleCompra_compra1` FOREIGN KEY (`compra_idCompra`) REFERENCES `cargar` (`idCompra`),
  CONSTRAINT `fk_detalleCompra_menu1` FOREIGN KEY (`menu_idProducto`) REFERENCES `menu` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.detallecompra: ~26 rows (approximately)
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT IGNORE INTO `detallecompra` (`idDC`, `Costo`, `Cantidad`, `Subtotal`, `compra_idCompra`, `menu_idProducto`) VALUES
	(1, 43, 10, 430, 1, 2),
	(2, 45, 10, 450, 1, 1),
	(3, 90, 1, 90, 1, 4),
	(4, 23, 4, 92, 4, 2),
	(5, 100, 99, 9900, 4, 4),
	(6, 2, 90, 180, 5, 2),
	(8, 4.99, 8, 39.92, 7, 4),
	(9, 4.87, 4, 19.48, 7, 2),
	(10, 9.99, 8, 79.92, 8, 3),
	(11, 11.8, 5, 59, 9, 3),
	(12, 3.99, 3, 11.97, 9, 4),
	(13, 9.99, 9, 89.91, 10, 3),
	(14, 7.77, 6, 46.62, 10, 4),
	(15, 4, 99, 396, 11, 5),
	(16, 101.8, 1, 101.8, 11, 5),
	(17, 1000.09, 1, 1000.09, 12, 6),
	(18, 109, 2, 218, 12, 6),
	(19, 33.4, 12, 400.8, 19, 2),
	(20, 3, 2, 6, 19, 1),
	(21, 1, 3, 3, 22, 1),
	(22, 32, 100, 3200, 33, 1),
	(23, 10, 20, 200, 34, 11),
	(24, 5, 5, 25, 35, 2),
	(25, 20, 10, 200, 36, 12),
	(26, 2, 2, 4, 38, 2),
	(27, 2, 2, 4, 39, 2),
	(28, 10, 3, 30, 42, 1),
	(31, 5, 10, 50, 46, 13);
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;

-- Dumping structure for table cafeteria2.detalleventa
CREATE TABLE IF NOT EXISTS `detalleventa` (
  `IdDV` int(11) NOT NULL AUTO_INCREMENT,
  `Precio` float DEFAULT NULL,
  `Cantididad` int(11) DEFAULT NULL,
  `Subtotal` float DEFAULT NULL,
  `menu_idProducto` int(11) NOT NULL,
  `venta_idVenta` int(11) NOT NULL,
  PRIMARY KEY (`IdDV`),
  KEY `fk_detalleVenta_menu1_idx` (`menu_idProducto`),
  KEY `fk_detalleVenta_venta1_idx` (`venta_idVenta`),
  CONSTRAINT `fk_detalleVenta_menu1` FOREIGN KEY (`menu_idProducto`) REFERENCES `menu` (`idProducto`),
  CONSTRAINT `fk_detalleVenta_venta1` FOREIGN KEY (`venta_idVenta`) REFERENCES `venta` (`idVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.detalleventa: ~4 rows (approximately)
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
INSERT IGNORE INTO `detalleventa` (`IdDV`, `Precio`, `Cantididad`, `Subtotal`, `menu_idProducto`, `venta_idVenta`) VALUES
	(2, 12, 10, 120, 3, 5),
	(3, 10, 1, 10, 5, 5),
	(4, 13, 2, 26, 2, 6),
	(7, 87, 2, 174, 1, 10);
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;

-- Dumping structure for function cafeteria2.insertarAlimento
DELIMITER //
CREATE FUNCTION `insertarAlimento`(NombreAli VARCHAR(200), Existen INT, Preciov FLOAT) RETURNS varchar(40) CHARSET utf8
BEGIN
	DECLARE Exis VARCHAR(200) DEFAULT ' ';
	IF EXISTS (select * from inventario inv where (inv.Nombre = NombreAli and inv.Existencias = Existen and inv.Precio_venta = Preciov)) 
	THEN
	set Exis = 'Si';
	else
	set Exis='NO';
	END IF;
	return Exis;
END//
DELIMITER ;

-- Dumping structure for function cafeteria2.login
DELIMITER //
CREATE FUNCTION `login`(
	`vUsername` VARCHAR(30),
	`vClave` TINYTEXT
) RETURNS int(11)
BEGIN
	DECLARE cifrado BLOB;
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE Nombre=vUsername INTO cuenta;
    IF cuenta=0 THEN
		RETURN -1;
	ELSE
		SELECT contrasenia FROM usuario WHERE Nombre=vUsername INTO cifrado;
        RETURN cifrado=MD5(vClave);
	END IF;
END//
DELIMITER ;

-- Dumping structure for table cafeteria2.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  `Precio` float DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.menu: ~13 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT IGNORE INTO `menu` (`idProducto`, `Nombre`, `Cantidad`, `Precio`) VALUES
	(1, 'Pie', 200, 87),
	(2, 'Pastel', 137, 13),
	(3, 'Omellete', 121, 12),
	(4, 'Paea', 216, 19),
	(5, 'Helado', 91, 10),
	(6, 'ki', 1, 999.99),
	(7, 'l', NULL, NULL),
	(8, 'a', NULL, NULL),
	(9, 'b', NULL, NULL),
	(10, 'PRUEBA', 300, 12),
	(11, 'Helado2', 20, 15),
	(12, 'Chocolates', 10, 5),
	(13, 'Vainilla', 10, 10);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Dumping structure for table cafeteria2.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `idProveedores` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.proveedores: ~3 rows (approximately)
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT IGNORE INTO `proveedores` (`idProveedores`, `Nombre`, `Direccion`, `empresa`, `numero`) VALUES
	(2, 'Xelac', '13 Calle', 'Xelac', 78945612),
	(3, 'Daniel', 'CDMX', 'Bimbo', 74125836),
	(4, 'Luis', 'ciudad', 'Xelapan', 78945612);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;

-- Dumping structure for function cafeteria2.restaurarClave
DELIMITER //
CREATE FUNCTION `restaurarClave`(
	`vUsarname` VARCHAR(45),
	`vIdadmin` VARCHAR(200),
	`vClave` BLOB
) RETURNS int(11)
BEGIN 
    DECLARE admin INT DEFAULT -1;
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE idUsuario = vIdadmin AND Acceso_idAcceso = 1 INTO admin; 
    IF admin = 0 THEN
       RETURN -1;
	END IF;
	SELECT COUNT(*) FROM usuario WHERE Nombre = vUsername INTO cuenta;
	IF cuenta = 1 THEN
		UPDATE usuario  SET contasenia  = MD5(vClave) WHERE Nombre = vUsername;
		RETURN 1;
	ELSE 
		RETURN 0;
	END IF;
	RETURN -2;
END//
DELIMITER ;

-- Dumping structure for table cafeteria2.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) NOT NULL,
  `Contrasenia` blob NOT NULL,
  `Acceso_idAcceso` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_Acceso1_idx` (`Acceso_idAcceso`),
  CONSTRAINT `fk_Usuario_Acceso1` FOREIGN KEY (`Acceso_idAcceso`) REFERENCES `acceso` (`idAcceso`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.usuario: ~4 rows (approximately)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT IGNORE INTO `usuario` (`idUsuario`, `Nombre`, `Contrasenia`, `Acceso_idAcceso`) VALUES
	(1, 'admin', _binary 0x3031393230323361376262643733323530353136663036396466313862353030, 1),
	(4, 'venta', _binary 0x3061663338323265303361626436653365373365363932393563336164346261, 2),
	(5, 'venta2', _binary 0x3061663338323265303361626436653365373365363932393563336164346261, 2),
	(6, 'ventas3', _binary 0x3731643432613730336333616266323131363061353833383635346562303338, 2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Dumping structure for table cafeteria2.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime DEFAULT NULL,
  `Total` float DEFAULT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Cliente_idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `fk_Venta_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Venta_Cliente1_idx` (`Cliente_idCliente`),
  CONSTRAINT `fk_Venta_Cliente1` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Venta_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table cafeteria2.venta: ~7 rows (approximately)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT IGNORE INTO `venta` (`idVenta`, `Fecha`, `Total`, `Usuario_idUsuario`, `Cliente_idCliente`) VALUES
	(2, '2020-05-07 00:00:00', 2079.98, 1, 2),
	(4, '2020-05-07 14:35:44', 156, 1, 1),
	(5, '2020-05-07 14:38:56', 130, 1, 2),
	(6, '2020-05-07 15:16:18', 26, 1, 2),
	(8, '2020-05-07 15:17:19', 174, 1, 1),
	(10, '2020-05-07 15:21:26', 174, 1, 1),
	(12, '2020-05-07 17:38:02', 0, 1, 1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

-- Dumping structure for trigger cafeteria2.elimiarDV
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER elimiarDV
	BEFORE DELETE ON detalleventa
	FOR EACH ROW 
	BEGIN 
		UPDATE menu 
		SET menu.Cantidad = menu.Cantidad + OLD.Cantididad
		WHERE OLD.menu_idProducto = menu.idProducto;
	END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger cafeteria2.eliminarDC
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `eliminarDC` BEFORE DELETE ON `detallecompra` FOR EACH ROW UPDATE menu
SET menu.Cantidad = menu.Cantidad - OLD.Cantidad
WHERE OLD.menu_idProducto = menu.idProducto//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger cafeteria2.fechaAct
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `fechaAct` BEFORE INSERT ON `cargar` FOR EACH ROW BEGIN
SET NEW.Fecha = NOW();
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger cafeteria2.InsertarFechaCierre
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER InsertarFechaCierre
	BEFORE INSERT ON cierre 
	FOR EACH ROW 
	BEGIN 
		SET NEW.FechaCierre = NOW();
	END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger cafeteria2.InsertarFechaVenta
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER InsertarFechaVenta
	BEFORE INSERT ON venta 
	FOR EACH ROW 
	BEGIN 
		SET NEW.Fecha = NOW();
	END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
