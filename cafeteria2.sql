-- --------------------------------------------------------
-- Host:                         127.0.0.1

-- Versión del servidor:         10.3.13-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- Versión del servidor:         10.4.12-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599

-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.

-- Volcando estructura de base de datos para cafeteria2
CREATE DATABASE IF NOT EXISTS `cafeteria2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cafeteria2`;

-- Volcando estructura para tabla cafeteria2.acceso
CREATE TABLE IF NOT EXISTS `acceso` (
  `idAcceso` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` tinyint(4) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idAcceso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.acceso: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
REPLACE INTO `acceso` (`idAcceso`, `Codigo`, `Nombre`) VALUES
	(1, 1, 'Administrador'),
	(2, 2, 'Vendedor');
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;

-- Volcando estructura para tabla cafeteria2.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL,
  `Telefono` varchar(8) DEFAULT NULL,
  `Nit` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
REPLACE INTO `cliente` (`idCliente`, `Nombre`, `Direccion`, `Telefono`, `Nit`) VALUES
	(1, 'Donald', '+5021234-4567', '1239875', 123456),
	(2, 'Kelvin', 'D', '56565', 56896);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla cafeteria2.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Costo` float NOT NULL,
  `proveedores_idProveedores` int(11) NOT NULL,
  `inventario_idInventario` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_proveedores1_idx` (`proveedores_idProveedores`),
  KEY `fk_Compra_inventario1_idx` (`inventario_idInventario`),
  CONSTRAINT `fk_Compra_inventario1` FOREIGN KEY (`inventario_idInventario`) REFERENCES `inventario` (`idInventario`),
  CONSTRAINT `fk_Compra_proveedores1` FOREIGN KEY (`proveedores_idProveedores`) REFERENCES `proveedores` (`idProveedores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.compra: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;

-- Volcando estructura para función cafeteria2.crearUsuario
DELIMITER //
CREATE FUNCTION `crearUsuario`(vUsername VARCHAR(30), vClave TINYTEXT, vAcceso INT) RETURNS int(11)
BEGIN
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE Nombre=vUsername INTO cuenta;
    IF cuenta=0 THEN
		INSERT INTO usuario (Nombre,contraseña,Accesos_id) VALUES (vUsername,MD5(vClave),vAcceso);
        RETURN 1;
CREATE DEFINER=`root`@`localhost` FUNCTION `crearUsuario`(nombre VARCHAR(200),  contra BLOB,  Accesos_id INT) RETURNS int(11)
BEGIN
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE Nombre=nombre INTO cuenta;
    IF cuenta=0 THEN
		INSERT INTO usuario (Nombre, Contrasenia, Acceso_idAcceso) VALUES (nombre,MD5(contra),Accesos_id);
      	RETURN 1;
	ELSE
		RETURN 0;
	END IF;
	RETURN -1;
END//
DELIMITER ;

-- Volcando estructura para función cafeteria2.insertarAlimento
DELIMITER //
CREATE FUNCTION `insertarAlimento`(NombreAli VARCHAR(200), Existen INT, Preciov FLOAT) RETURNS varchar(40) CHARSET utf8
BEGIN
	DECLARE Exis VARCHAR(200) DEFAULT ' ';
	IF EXISTS (select * from inventario inv where (inv.Nombre = NombreAli and inv.Existencias = Existen and inv.Precio_venta = Preciov)) 
CREATE DEFINER=`root`@`localhost` FUNCTION `insertarAlimento`() RETURNS varchar(40) CHARSET utf8
BEGIN
	DECLARE Exis Varchar(40) DEFAULT ' ';
	IF EXISTS (select * from inventario inv where (inv.Nombre = NombreAli and inv.Existencias = Exis and inv.Precio_venta = precio)) 
	THEN
	set Exis = 'Si';
	else
	set Exis='NO';
	END IF;
	return Exis;
END//
DELIMITER ;

-- Volcando estructura para tabla cafeteria2.inventario
CREATE TABLE IF NOT EXISTS `inventario` (
  `idInventario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) DEFAULT NULL,
  `Existencias` int(11) DEFAULT NULL,
  `Precio_venta` float DEFAULT NULL,
  PRIMARY KEY (`idInventario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.inventario: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
REPLACE INTO `inventario` (`idInventario`, `Nombre`, `Existencias`, `Precio_venta`) VALUES
	(1, 'Sandwich', 5, 10),
	(2, 'Pie de queso', 15, 5),
	(3, 'Sandwich de atún', 5, 13),
	(4, 'D', 1, 12);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;

-- Volcando estructura para función cafeteria2.login
DELIMITER //
CREATE FUNCTION `login`(vUsername VARCHAR(30), vClave TINYTEXT) RETURNS int(11)
BEGIN
	DECLARE cifrado BLOB;
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE Nombre=vUsername INTO cuenta;
    IF cuenta=0 THEN
		RETURN -1;
	ELSE
		SELECT contraseña FROM usuario WHERE Nombre=vUsername INTO cifrado;
        RETURN cifrado=MD5(vClave);
	END IF;
CREATE DEFINER=`root`@`localhost` FUNCTION `login`(vUsername VARCHAR(45), vClave BLOB) RETURNS int(11)
BEGIN
    DECLARE cifrado BLOB;
    DECLARE cuenta INT DEFAULT -1;
    SELECT COUNT(*) FROM usuario WHERE Nombre=vUsername INTO cuenta;
    IF cuenta=0 THEN
   	RETURN 1;
	ELSE
		SELECT contrasenia FROM usuario WHERE Nombre=vUsername INTO cifrado;
			RETURN cifrado = MD5(vClave);
	END IF; 
END//
DELIMITER ;

-- Volcando estructura para tabla cafeteria2.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `idArticulosVendidos` int(11) NOT NULL AUTO_INCREMENT,
  `Cantidad` int(11) DEFAULT NULL,
  `SubTotal` float DEFAULT NULL,
  `Inventario_idInventario` int(11) NOT NULL,
  PRIMARY KEY (`idArticulosVendidos`),
  KEY `fk_Articulos_vendidos_Inventario1_idx` (`Inventario_idInventario`),
  CONSTRAINT `fk_Articulos_vendidos_Inventario1` FOREIGN KEY (`Inventario_idInventario`) REFERENCES `inventario` (`idInventario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.menu: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Volcando estructura para tabla cafeteria2.menu_venta
CREATE TABLE IF NOT EXISTS `menu_venta` (
  `Id_Menu` int(11) NOT NULL AUTO_INCREMENT,
  `Venta_idVenta` int(11) NOT NULL,
  `Menu_idArticulosVendidos` int(11) NOT NULL,
  PRIMARY KEY (`Id_Menu`),
  KEY `fk_Venta_has_Menu_Menu1_idx` (`Menu_idArticulosVendidos`),
  KEY `fk_Venta_has_Menu_Venta1_idx` (`Venta_idVenta`),
  CONSTRAINT `fk_Venta_has_Menu_Menu1` FOREIGN KEY (`Menu_idArticulosVendidos`) REFERENCES `menu` (`idArticulosVendidos`),
  CONSTRAINT `fk_Venta_has_Menu_Venta1` FOREIGN KEY (`Venta_idVenta`) REFERENCES `venta` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.menu_venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `menu_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_venta` ENABLE KEYS */;

-- Volcando estructura para tabla cafeteria2.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `idProveedores` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.proveedores: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
REPLACE INTO `proveedores` (`idProveedores`, `Nombre`, `Direccion`, `empresa`, `numero`) VALUES
	(1, 'algo', 'quetzgo', 'xelapan', 12);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;

-- Volcando estructura para función cafeteria2.restaurarClave
DELIMITER //
CREATE FUNCTION `restaurarClave`(vUsarname VARCHAR(45), vIdadmin VARCHAR(200), vClave BLOB) RETURNS int(11)
CREATE DEFINER=`root`@`localhost` FUNCTION `restaurarClave`(vUsarname VARCHAR(45), vIdadmin VARCHAR(200), vClave BLOB) RETURNS int(11)
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

-- Volcando estructura para tabla cafeteria2.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(200) NOT NULL,
  `Contrasenia` blob NOT NULL,
  `Acceso_idAcceso` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_Acceso1_idx` (`Acceso_idAcceso`),
  CONSTRAINT `fk_Usuario_Acceso1` FOREIGN KEY (`Acceso_idAcceso`) REFERENCES `acceso` (`idAcceso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
REPLACE INTO `usuario` (`idUsuario`, `Nombre`, `Contrasenia`, `Acceso_idAcceso`) VALUES
	(1, 'admin', _binary 0x3031393230323361376262643733323530353136663036396466313862353030, 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla cafeteria2.venta
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cafeteria2.venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
