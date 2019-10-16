-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 16 oct. 2019 à 15:42
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tech_event`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `Id_Article` int(11) NOT NULL AUTO_INCREMENT,
  `Id_User` int(11) NOT NULL,
  `Nom_Article` varchar(255) NOT NULL,
  `Contenu_Article` varchar(255) NOT NULL,
  `Date_Article` varchar(255) NOT NULL,
  `Image_Article` varchar(255) NOT NULL,
  `Id_Event` int(11) NOT NULL,
  PRIMARY KEY (`Id_Article`),
  KEY `Id_User` (`Id_User`),
  KEY `Id_Event` (`Id_Event`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `Id_Commentaire` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Sujet` int(11) NOT NULL,
  `Id_User` int(11) NOT NULL,
  `Contenu_Commentaire` varchar(255) NOT NULL,
  `Temps_Commentaire` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Commentaire`),
  KEY `Id_Sujet` (`Id_Sujet`),
  KEY `Id_User` (`Id_User`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `Id_Event` int(11) NOT NULL AUTO_INCREMENT,
  `Descr_Event` varchar(255) NOT NULL,
  `Image_Event` varchar(255) NOT NULL,
  `Titre_Event` varchar(255) NOT NULL,
  `Date_Event` varchar(255) NOT NULL,
  `Localisation` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Event`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `Id_Reclamation` int(11) NOT NULL AUTO_INCREMENT,
  `Id_User` int(11) NOT NULL,
  `Titre_Reclamation` varchar(255) NOT NULL,
  `Contenu_Reclamation` varchar(255) NOT NULL,
  `Etat_Reclamation` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Reclamation`),
  KEY `Id_User` (`Id_User`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `Id_Res` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Event` int(11) NOT NULL,
  `Id_User` int(11) NOT NULL,
  `Date_Event` varchar(255) NOT NULL,
  `Etat_Res` varchar(255) NOT NULL,
  `E_mailU` varchar(255) NOT NULL,
  `NumTel` int(11) NOT NULL,
  `Descr_Event` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Res`),
  KEY `Id_Event` (`Id_Event`),
  KEY `Id_User` (`Id_User`),
  KEY `Date_Event` (`Date_Event`),
  KEY `E_mailU` (`E_mailU`),
  KEY `NumTel` (`NumTel`),
  KEY `Descr_Event` (`Descr_Event`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

DROP TABLE IF EXISTS `sujet`;
CREATE TABLE IF NOT EXISTS `sujet` (
  `Id_Sujet` int(11) NOT NULL AUTO_INCREMENT,
  `Id_User` int(11) NOT NULL,
  `Titre_Sujet` varchar(255) NOT NULL,
  `Contenu_Sujet` varchar(255) NOT NULL,
  `Temps_Sujet` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Sujet`),
  KEY `Id_User` (`Id_User`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `Id_User` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(255) NOT NULL,
  `Mdp` varchar(255) NOT NULL,
  `E_mailU` varchar(255) NOT NULL,
  `NomU` varchar(255) NOT NULL,
  `PrenomU` varchar(255) NOT NULL,
  `CIN` int(11) NOT NULL,
  `DateNaissance` varchar(255) NOT NULL,
  `NumTel` int(11) NOT NULL,
  `PhotoProfil` varchar(255) NOT NULL,
  `RoleU` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_User`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
