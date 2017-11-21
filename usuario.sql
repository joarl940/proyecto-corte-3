-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2017 a las 16:34:36
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `serpiente`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(100) NOT NULL,
  `foto` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `cedula` int(100) NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `edad` int(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_registro` date NOT NULL,
  `puntaje` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `foto`, `cedula`, `nombre`, `apellido`, `edad`, `fecha_nacimiento`, `fecha_registro`, `puntaje`) VALUES
(1, 'foto', 1235, 'jose', 'muñoz', 23, '1994-02-19', '2017-11-12', 45),
(2, 'C:\\Users\\Jose\\Desktop\\foto1.jpg', 1074187335, 'arley', 'lara', 23, '1994-06-18', '2017-11-12', 10),
(3, 'C:\\Users\\Jose\\Pictures\\fotos\\7af2b5135e7cce23e2ebd8e5c10898d8.jpg', 123456, 'feliepe', 'caceres', 19, '1995-03-23', '2017-11-14', 60),
(4, 'C:\\Users\\Jose\\Pictures\\DSC01577.JPG', 1015, 'marcela', 'castiblanco', 18, '1997-01-30', '2017-11-15', 23),
(5, 'C:\\Users\\Jose\\Pictures\\DSC01572.JPG', 123456, 'omaira', 'lara', 45, '1974-01-30', '2017-11-15', 4),
(7, 'C:\\Users\\Jose\\Pictures\\DSC01571.JPG', 123456, 'ricardo', 'rodriguez', 23, '1993-03-13', '2017-11-18', 20),
(9, 'C:\\Users\\Jose\\Pictures\\DSC01571.JPG', 123455, 'steven', 'hernandez', 45, '1994-02-19', '2017-11-18', 5),
(10, 'C:\\Users\\Jose\\Pictures\\DSC01570.JPG', 1072593507, 'victor', 'preciado', 21, '1996-11-04', '2017-11-21', 0),
(11, 'C:\\Users\\Jose\\Desktop\\historial.png', 1073157928, 'STEVEN', 'HERNANDEZ', 28, '2017-11-16', '2017-11-21', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
