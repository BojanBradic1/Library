-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2016 at 08:19 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `biblioteka`
--

-- --------------------------------------------------------

--
-- Table structure for table `clan`
--

CREATE TABLE IF NOT EXISTS `clan` (
  `clan_id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nadimak` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`clan_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=25 ;

--
-- Dumping data for table `clan`
--

INSERT INTO `clan` (`clan_id`, `ime`, `prezime`, `nadimak`) VALUES
(1, 'John', 'Smith', 'Smithie'),
(4, 'Milan', 'Milanovic', 'Milantret'),
(5, 'jovan', 'jovanovic', 'sterija'),
(6, 'we', 'we', 'we'),
(7, 'asd', 'asd', 'asd'),
(11, 'asd', 'asd', ''),
(12, 'dogma', 'morali', 'srga'),
(13, 'krbulja', 'dirdulja', 'mrkulja'),
(14, 'djun', 'ribljumn', 'tkrl'),
(15, 'dio', 'cega', 'dijo'),
(16, 'srget', 'baget', ''),
(19, 'milantret', 'miloninjo', 'kurbla'),
(20, 'svoboda', 'stanko', 'palivoje'),
(21, 'asd', 'asd', 'asd'),
(22, 'birkez', 'gd', ''),
(23, 'birkez', 'gd', ''),
(24, 'birkez', 'gd', '');

-- --------------------------------------------------------

--
-- Table structure for table `iznajmljene_knjige`
--

CREATE TABLE IF NOT EXISTS `iznajmljene_knjige` (
  `id_knjige` int(11) NOT NULL,
  `id_clana` int(11) NOT NULL,
  PRIMARY KEY (`id_knjige`,`id_clana`),
  KEY `fk_clan` (`id_clana`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `iznajmljene_knjige`
--

INSERT INTO `iznajmljene_knjige` (`id_knjige`, `id_clana`) VALUES
(6, 1),
(7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kategorija`
--

CREATE TABLE IF NOT EXISTS `kategorija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=28 ;

--
-- Dumping data for table `kategorija`
--

INSERT INTO `kategorija` (`id`, `naziv`) VALUES
(1, 'Psihologija'),
(2, 'Beletristika'),
(3, 'Computer Science'),
(4, 'Naucna fantastika'),
(5, 'Porno-dinamika'),
(7, 'Naziv'),
(8, 'ksask'),
(9, 'jagodinka'),
(18, 'skaradeva'),
(19, 'sirugojna'),
(22, 'buljarice'),
(24, 'sormaz'),
(25, 'gambirozino pravo'),
(26, 'ertjk'),
(27, 'Horor');

-- --------------------------------------------------------

--
-- Table structure for table `knjiga`
--

CREATE TABLE IF NOT EXISTS `knjiga` (
  `knjiga_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pisac` int(11) NOT NULL,
  `naslov` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `kategorija_id` int(40) DEFAULT NULL,
  `izdavac` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`knjiga_id`),
  KEY `id_pisac` (`id_pisac`),
  KEY `kategorija_id` (`kategorija_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `knjiga`
--

INSERT INTO `knjiga` (`knjiga_id`, `id_pisac`, `naslov`, `kategorija_id`, `izdavac`) VALUES
(6, 1, 'asd', 1, 'asd'),
(7, 2, 'qwe', 2, 'qwe'),
(8, 5, 'daa', 3, 'kumun');

-- --------------------------------------------------------

--
-- Table structure for table `pisac`
--

CREATE TABLE IF NOT EXISTS `pisac` (
  `id_pisac` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_pisac`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Dumping data for table `pisac`
--

INSERT INTO `pisac` (`id_pisac`, `ime`, `prezime`) VALUES
(1, 'George', 'Martin'),
(2, 'Dundjer', 'Vajfert'),
(3, 'Jovica', 'Kurcugic'),
(4, 'Miroslavljevo', 'Jevandjelije'),
(5, 'TAdi', 'adas'),
(6, 'stiburjek', 'nijemci'),
(8, 'stjepe', 'budiveljnik'),
(9, 'ses', 'sanaka'),
(10, 'juri', 'balnicenko'),
(11, 'zjekoslav', 'mrkva'),
(12, 'nikola', 'djordjevic'),
(13, 'miroslav', 'pantelejmon'),
(14, '12345', '12345'),
(15, 'birokul', 'mrgan');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `iznajmljene_knjige`
--
ALTER TABLE `iznajmljene_knjige`
  ADD CONSTRAINT `fk_clan` FOREIGN KEY (`id_clana`) REFERENCES `clan` (`clan_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_knjiga` FOREIGN KEY (`id_knjige`) REFERENCES `knjiga` (`knjiga_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `knjiga`
--
ALTER TABLE `knjiga`
  ADD CONSTRAINT `fk_kategorija_knjige` FOREIGN KEY (`kategorija_id`) REFERENCES `kategorija` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pisac_knjige` FOREIGN KEY (`id_pisac`) REFERENCES `pisac` (`id_pisac`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
