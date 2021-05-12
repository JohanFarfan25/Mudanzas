-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2021 a las 20:46:25
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dashio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idcategorias` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `icono` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idcategorias`, `Nombre`, `icono`, `color`) VALUES
(1, 'Cajas', 'ti-package', 'text-primary border-primary'),
(2, 'Plastico', 'ti-hummer', 'text-primary border-primary'),
(3, 'Cintas', 'ti-home', 'text-success border-success'),
(4, 'Kits', 'ti-comments-smiley', 'text-warning border-warning');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProductos` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `imagen_ruta` varchar(255) DEFAULT NULL,
  `cantidad` varchar(45) NOT NULL,
  `valor_compra` double NOT NULL,
  `valor_venta` double DEFAULT NULL,
  `fk_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProductos`, `descripcion`, `nombre`, `imagen_ruta`, `cantidad`, `valor_compra`, `valor_venta`, `fk_categoria`) VALUES
(129, 'prueba ', 'prueba ', '20210505095405921.jpeg', '520', 520, 520, 2),
(130, 'Es muy peliona', 'caja rocio', '20210504163140698.jpeg', '1', 20, 20, 1),
(131, 'binnipel negro', 'binnipel negro', '20210504164240544.jpeg', '20', 25000, 25000, 2),
(132, 'binnipel negro', 'caja rocio', '20210504170053364.jpeg', '20', 25000, 25000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quotes`
--

CREATE TABLE `quotes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `numero_telefono` bigint(20) DEFAULT NULL,
  `origen` varchar(45) DEFAULT NULL,
  `direccion_origen` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `destino` varchar(45) DEFAULT NULL,
  `direccion_destino` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `tipo_mudanza` varchar(45) CHARACTER SET utf8 NOT NULL,
  `horario` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `fecha_mudanza` varchar(50) NOT NULL,
  `fecha_solicitud` datetime NOT NULL DEFAULT current_timestamp(),
  `Estado` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `quotes`
--

INSERT INTO `quotes` (`id`, `nombre`, `correo`, `numero_telefono`, `origen`, `direccion_origen`, `destino`, `direccion_destino`, `tipo_mudanza`, `horario`, `fecha_mudanza`, `fecha_solicitud`, `Estado`) VALUES
(22, 'johan', 'johanfarfan25@gmail.com', 3227111889, 'bogota', 'carrera', 'Pacho', 'carrera', 'Basico', 'Mañana', '2021-05-19', '2021-05-04 09:34:21', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `icono` varchar(60) DEFAULT NULL,
  `ruta` varchar(120) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `nombre`, `icono`, `ruta`, `descripcion`) VALUES
(1, 'Administrador', 'fa fa-cogs', '../administrador/index.xhtml', 'Lista de usuarios'),
(3, 'Gestion de productos', 'fa fa-desktop', '../productos/index.xhtml', 'Productos'),
(7, 'Usuario', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipoDocumento` varchar(20) DEFAULT NULL,
  `documento` bigint(20) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `clave` varchar(10) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT current_timestamp(),
  `ultimoIngreso` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombres`, `apellidos`, `tipoDocumento`, `documento`, `correo`, `clave`, `fechaRegistro`, `ultimoIngreso`) VALUES
(40, 'Admin', 'Confi Mudanzas', 'Cedula', 78979798, 'confimudanzas@gmail.com', '123456', '2021-05-04 16:13:13', NULL),
(41, 'Johan ', 'Farfan Sierra', 'Cedula', 12456, 'johanfarfan25@gmail.com', '123456', '2021-05-04 16:14:37', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `idUsuario` int(11) DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`idUsuario`, `idRol`) VALUES
(40, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idcategorias`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProductos`),
  ADD KEY `fk_cate_idx` (`fk_categoria`);

--
-- Indices de la tabla `quotes`
--
ALTER TABLE `quotes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `documento_UNIQUE` (`documento`),
  ADD UNIQUE KEY `correo_UNIQUE` (`correo`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idRol` (`idRol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idcategorias` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProductos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- AUTO_INCREMENT de la tabla `quotes`
--
ALTER TABLE `quotes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_cate` FOREIGN KEY (`fk_categoria`) REFERENCES `categorias` (`idcategorias`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `usuario_rol_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `usuario_rol_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
