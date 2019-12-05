-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 05 déc. 2019 à 03:05
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
-- Base de données :  `techevnet-test`
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
  `Image_Article` varchar(255) NOT NULL,
  `Titre_Event` varchar(255) NOT NULL,
  `nbrevue` int(11) NOT NULL,
  `Date_Article` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Article`),
  KEY `Id_User` (`Id_User`),
  KEY `Titre_Event` (`Titre_Event`)
) ENGINE=MyISAM AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`Id_Article`, `Id_User`, `Nom_Article`, `Contenu_Article`, `Image_Article`, `Titre_Event`, `nbrevue`, `Date_Article`) VALUES
(73, 1, '10 Tips to start your small business', 'Donec quis metus ac arcu luctus accumsan. Nunc in justo tincidunt, sodales nunc id, finibus nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce nec ante vitae lacus aliquet', 'news_1.jpg', 'evnement1', 364, '13:27:49 03/12/2019'),
(74, 1, 'Ideas for a better online marketing campaign', 'Donec quis metus ac arcu luctus accumsan. Nunc in justo tincidunt, sodales nunc id, finibus nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 'image_1.jpg', 'TSYP IEEE', 58, '14:50:45 03/12/2019'),
(75, 1, 'Tips to have an amazing conefrence call', 'Donec quis metus ac arcu luctus accumsan. Nunc in justo tincidunt, sodales nunc id, finibus nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra', 'image_2.jpg', 'TSYP IEEE', 35, '14:50:59 03/12/2019'),
(77, 2, 'Blockchain technology', 'Donec quis metus ac arcu luctus accumsan. Nunc in justo tincidunt, sodales nunc id, finibus nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce nec ante vitae lacus aliquet', 'image_3.jpg', 'xs', 31, '14:51:14 03/12/2019'),
(80, 1, 'What is all about us?', 'A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.  On her way she met a copy. The copy warned the Little Blind Text, that w', 'image_4.jpg', 'xs', 6, '14:52:03 03/12/2019'),
(83, 1, 'It is a long established fact a reader be distracted', 'I read that Invoice Ninja supports the variable pageNumber and pageCount. I put both variables in the code. Both variable are not supported. What am I doing wrong?variable pageNumber and pageCountI use the last version of Invoice Ninja.', 'image_4.jpg', 'TSYP IEEE', 0, '14:55:38 03/12/2019'),
(84, 1, 'Why Lead Generation is Key for Business Growth', 'A small river named Duden flows by their place and supplies it with the necessary regelialia.A small river named Duden flows by their place and supplies it with the necessary regelialia.A small river named Duden flows by their place and supplies it with t', 'image_4.jpg', 'TSYP IEEE', 2, '15:12:04 03/12/2019'),
(85, 2, 'PackagistThe PHP Package Repository', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur quidem laborum necessitatibus, ipsam impedit vitae autem, eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas earum impedit necessitatibus, nihil?', 'image_5.jpg', 'TSYP IEEE', 35, '19:14:10 03/12/2019');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`) VALUES
(1, 'Robotique'),
(2, 'Web'),
(3, 'Réseaux'),
(4, 'mobile');

-- --------------------------------------------------------

--
-- Structure de la table `categorierec`
--

DROP TABLE IF EXISTS `categorierec`;
CREATE TABLE IF NOT EXISTS `categorierec` (
  `IdRecCat` int(11) NOT NULL AUTO_INCREMENT,
  `NameCat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IdRecCat`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categorierec`
--

INSERT INTO `categorierec` (`IdRecCat`, `NameCat`) VALUES
(1, 'event'),
(2, 'workshop'),
(3, 'event'),
(4, 'workshop');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_com` int(11) NOT NULL AUTO_INCREMENT,
  `id_f` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_com` date NOT NULL,
  `description_com` varchar(255) NOT NULL,
  PRIMARY KEY (`id_com`),
  KEY `Id_Sujet` (`id_f`),
  KEY `Id_User` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_com`, `id_f`, `id_user`, `date_com`, `description_com`) VALUES
(229, 213, 5, '2019-12-03', 'xdxd'),
(230, 213, 6, '2019-12-03', 'sqs2'),
(232, 213, 6, '2019-12-03', 'comment'),
(234, 216, 6, '2019-12-03', 'hjlhljnljnlj'),
(235, 215, 1, '2019-12-03', 'ieee evenement'),
(236, 217, 1, '2019-12-03', 'wasli'),
(237, 217, 6, '2019-12-03', 'radhwenkkkkkkkkk'),
(238, 212, 7, '2019-12-03', 'szd'),
(239, 212, 7, '2019-12-04', 'okey'),
(240, 217, 7, '2019-12-04', 'okeyyy'),
(241, 219, 7, '2019-12-04', 'No comment'),
(242, 219, 7, '2019-12-04', 'comment'),
(243, 219, 1, '2019-12-04', 'okey'),
(244, 219, 2, '2019-12-05', 'karim'),
(245, 228, 2, '2019-12-05', 'hhhh'),
(246, 229, 2, '2019-12-05', 'km:,');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `Id_Event` int(11) NOT NULL AUTO_INCREMENT,
  `Descr_Event` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Image_Event` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Titre_Event` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DATED_EVENT` date NOT NULL,
  `DATEF_EVENT` date NOT NULL,
  `EMPLACEMENT` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Id_User` int(11) NOT NULL,
  `categorie_Event` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbr_place_E` int(11) NOT NULL,
  `nbr_r` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Event`),
  KEY `Id_User` (`Id_User`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`Id_Event`, `Descr_Event`, `Image_Event`, `Titre_Event`, `DATED_EVENT`, `DATEF_EVENT`, `EMPLACEMENT`, `Id_User`, `categorie_Event`, `nbr_place_E`, `nbr_r`) VALUES
(2, 'ghj', 'Image1.jpg', 'fghj', '2014-01-01', '2016-01-01', '8.963216, 3.26953', 1, 'Autre', 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie_id` int(11) NOT NULL,
  `tittre` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `localisation` varchar(50) NOT NULL,
  `dateD` date NOT NULL,
  `dateF` date NOT NULL,
  `nbrp` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `nbrpart` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_404021BFBCF5E72D` (`categorie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`id`, `categorie_id`, `tittre`, `description`, `localisation`, `dateD`, `dateF`, `nbrp`, `image`, `nbrpart`) VALUES
(9, 4, 'AndroidApp', 'formation globale sur android', 'Hong Kong', '2020-06-16', '2020-06-24', 12, 'and.jpg', 0),
(8, 2, 'Web apps', 'formation de développement web', 'Tunis', '2020-01-19', '2020-01-25', 20, 'ww.jpg', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `jaime`
--

DROP TABLE IF EXISTS `jaime`;
CREATE TABLE IF NOT EXISTS `jaime` (
  `Id_User` int(11) NOT NULL,
  `Id_Sujet` int(11) NOT NULL,
  `valeur_jaime` int(11) NOT NULL,
  PRIMARY KEY (`Id_User`,`Id_Sujet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `notifiable_entity`
--

DROP TABLE IF EXISTS `notifiable_entity`;
CREATE TABLE IF NOT EXISTS `notifiable_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `class` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `notifiable_entity`
--

INSERT INTO `notifiable_entity` (`id`, `identifier`, `class`) VALUES
(1, '1', 'AppBundle\\Entity\\User'),
(2, '2', 'AppBundle\\Entity\\User');

-- --------------------------------------------------------

--
-- Structure de la table `notifiable_notification`
--

DROP TABLE IF EXISTS `notifiable_notification`;
CREATE TABLE IF NOT EXISTS `notifiable_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_id` int(11) DEFAULT NULL,
  `notifiable_entity_id` int(11) DEFAULT NULL,
  `seen` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_ADCFE0FAEF1A9D84` (`notification_id`),
  KEY `IDX_ADCFE0FAC3A0A4F8` (`notifiable_entity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `notifiable_notification`
--

INSERT INTO `notifiable_notification` (`id`, `notification_id`, `notifiable_entity_id`, `seen`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 0),
(3, 2, 1, 1),
(4, 2, 2, 0),
(5, 3, 1, 1),
(6, 3, 2, 0),
(7, 4, 1, 1),
(8, 4, 2, 0),
(9, 5, 1, 1),
(10, 5, 2, 0),
(11, 6, 1, 1),
(12, 6, 2, 0),
(13, 7, 1, 1),
(14, 7, 2, 0),
(15, 8, 1, 1),
(16, 8, 2, 0),
(17, 9, 1, 1),
(18, 9, 2, 0),
(19, 10, 1, 1),
(20, 10, 2, 0),
(21, 11, 1, 1),
(22, 11, 2, 0),
(23, 12, 1, 1),
(24, 12, 2, 0),
(25, 13, 1, 1),
(26, 13, 2, 0),
(27, 14, 1, 1),
(28, 14, 2, 0),
(29, 15, 1, 1),
(30, 15, 2, 0),
(31, 16, 1, 1),
(32, 16, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

DROP TABLE IF EXISTS `notification`;
CREATE TABLE IF NOT EXISTS `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `subject` varchar(4000) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `link` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `notification`
--

INSERT INTO `notification` (`id`, `date`, `subject`, `message`, `link`) VALUES
(1, '2019-12-02 14:50:27', 'ticket ajouté par 1   ', ' aaa ', NULL),
(2, '2019-12-02 14:55:01', 'rec ajouté par 2   ', ' aaa ', NULL),
(3, '2019-12-02 19:33:17', 'ticket ajouté par 1   ', ' aaa ', NULL),
(4, '2019-12-02 21:34:40', 'ticket ajouté par 1   ', ' aaa ', NULL),
(5, '2019-12-02 22:39:09', 'ticket ajouté par 1   ', ' aaa ', NULL),
(6, '2019-12-03 16:35:41', 'ticket ajouté par 1   ', ' aaa ', NULL),
(7, '2019-12-03 16:45:06', 'ticket ajouté par 1   ', ' aaa ', NULL),
(8, '2019-12-03 21:27:50', 'ticket ajouté par 1   ', ' aaa ', NULL),
(9, '2019-12-03 21:28:01', 'ticket ajouté par 1   ', ' aaa ', NULL),
(10, '2019-12-03 22:29:34', 'ticket ajouté par 1   ', ' aaa ', NULL),
(11, '2019-12-04 12:03:09', 'ticket ajouté par 1   ', ' aaa ', NULL),
(12, '2019-12-04 12:40:41', 'Reclamation ajoute le 04/12/2019', ' aaa ', NULL),
(13, '2019-12-04 12:44:19', 'Reclamation ajoute le 04/12/2019 sous le nom user', ' aaa ', NULL),
(14, '2019-12-04 12:45:43', 'Reclamation ajoute le 04/12/2019 sous le nom user', '', NULL),
(15, '2019-12-04 12:51:48', 'Reclamation ajoute le 04/12/2019 par le user sous le nom user', '', NULL),
(16, '2019-12-04 15:14:43', 'Reclamation ajoute le 04/12/2019 par le user sous le nom user', '', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `formation_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  KEY `fk_formation_id` (`formation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id`, `formation_id`, `user_id`) VALUES
(1, 4, 4),
(2, 4, 4),
(3, 2, 4),
(4, 3, 4),
(5, 3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `id_pub` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pub_rat` (`id_pub`),
  KEY `fk_user_rat` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rating`
--

INSERT INTO `rating` (`id`, `id_user`, `note`, `id_pub`) VALUES
(2, 6, 2, 212),
(3, 6, 3, 212),
(4, 6, 5, 213),
(5, 6, 4, 213),
(6, 6, 2, 212),
(7, 6, 3, 212),
(8, 5, 4, 213),
(9, 5, 2, 212),
(10, 6, 4, 216),
(11, 1, 3, 217),
(12, 6, 1, 217),
(13, 6, 4, 213),
(14, 7, 5, 212),
(15, 7, 4, 219),
(16, 7, 5, 219),
(17, 7, 4, 219),
(18, 7, 4, 217),
(19, 7, 4, 212),
(20, 7, 4, 212);

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `Id_Reclamation` int(11) NOT NULL AUTO_INCREMENT,
  `Titre_Reclamation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Contenu_Reclamation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Etat_Reclamation` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date_R` date NOT NULL,
  `id` int(11) NOT NULL,
  `NameCat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ReponseRec` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id_Reclamation`),
  KEY `id` (`id`),
  KEY `NameCat` (`NameCat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reclamationadmin`
--

DROP TABLE IF EXISTS `reclamationadmin`;
CREATE TABLE IF NOT EXISTS `reclamationadmin` (
  `IdRecAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `IdRecMembre` int(11) NOT NULL,
  `NameCat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TitreRecMembre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateRecAmin` date NOT NULL,
  `ContenuRecAdmin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ReponseRecMembre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IdRecAdmin`),
  KEY `IdRecMembre` (`IdRecMembre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reclamationadmin`
--

INSERT INTO `reclamationadmin` (`IdRecAdmin`, `IdRecMembre`, `NameCat`, `TitreRecMembre`, `DateRecAmin`, `ContenuRecAdmin`, `ReponseRecMembre`) VALUES
(1, 1, 'event', 'zfzs', '2019-12-02', 'qsc', 'sdv'),
(2, 3, 'event', ';,,,,', '2019-12-02', 'klll', 'gbfrgb'),
(3, 5, 'workshop', 'dfvbdf', '2019-12-03', 'd dg', 'jgvb;yjv'),
(4, 7, 'workshop', 'kl,;k,lk', '2019-12-03', 'lk:n,:nk:', ',d,f,j'),
(5, 10, 'workshop', 'rgvf', '2019-12-04', 'rgvf', 'fgbf'),
(6, 11, 'event', 'tbrtgfbn', '2019-12-04', 'bfrtgbf', 'db wfg');

-- --------------------------------------------------------

--
-- Structure de la table `reclamationmembre`
--

DROP TABLE IF EXISTS `reclamationmembre`;
CREATE TABLE IF NOT EXISTS `reclamationmembre` (
  `IdRecMembre` int(11) NOT NULL AUTO_INCREMENT,
  `TitreRecMembre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateRecMembre` date NOT NULL,
  `ContenuRecMembre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `EtatRecMembre` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NameCat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`IdRecMembre`),
  KEY `NameCat` (`NameCat`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `reclamationmembre`
--

INSERT INTO `reclamationmembre` (`IdRecMembre`, `TitreRecMembre`, `DateRecMembre`, `ContenuRecMembre`, `EtatRecMembre`, `NameCat`, `id`) VALUES
(1, 'zfzs', '2019-12-02', 'qsc', 'non traiter', 'event', 2),
(3, ';,,,,', '2019-12-02', 'klll', 'en cours', 'event', 2),
(5, 'dfvbdf', '2019-12-02', 'd dg', 'en cours', 'workshop', 2),
(7, 'kl,;k,lk', '2019-12-03', 'lk:n,:nk:', 'en cours', 'workshop', 2),
(10, 'rgvf', '2019-12-03', 'rgvf', 'en cours', 'workshop', 2),
(11, 'tbrtgfbn', '2019-12-03', 'bfrtgbf', 'en cours', 'event', 2),
(12, ',;;;', '2019-12-04', 'jjj', 'non traiter', 'workshop', 2),
(13, 'cfcgfhjhkjlk', '2019-12-04', 'fh,gjh;kj', 'non traiter', 'workshop', 2),
(14, 'j,,kjhgf', '2019-12-04', 'lkiujyhtg', 'non traiter', 'workshop', 2),
(15, 'fgfhjklm', '2019-12-04', 'hfdgfjhjkhkl', 'non traiter', 'workshop', 2),
(16, 'sdfghjkl', '2019-12-04', 'sdfghjkl', 'non traiter', 'event', 2);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `Id_Res` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Event` int(11) NOT NULL,
  `Id_User` int(11) NOT NULL,
  `Etat_Res` varchar(255) NOT NULL,
  `Titre_Event` varchar(255) NOT NULL,
  `DATED_EVENT` date NOT NULL,
  `DATEF_EVENT` date NOT NULL,
  `ImageEvent` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Res`),
  KEY `Id_Event` (`Id_Event`),
  KEY `Id_User` (`Id_User`)
) ENGINE=MyISAM AUTO_INCREMENT=132 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`Id_Res`, `Id_Event`, `Id_User`, `Etat_Res`, `Titre_Event`, `DATED_EVENT`, `DATEF_EVENT`, `ImageEvent`) VALUES
(129, 55, 1, 'en cours', 'AM-TECH', '2014-01-01', '2014-01-01', 'images (2).jpg'),
(131, 2, 2, 'en cours', 'fghj', '2014-01-01', '2016-01-01', 'Image1.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

DROP TABLE IF EXISTS `sujet`;
CREATE TABLE IF NOT EXISTS `sujet` (
  `id_f` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `Etat` int(11) NOT NULL,
  `description_f` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `nbre_jaime` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_f`),
  KEY `Id_User` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sujet`
--

INSERT INTO `sujet` (`id_f`, `id_user`, `Etat`, `description_f`, `date`, `nbre_jaime`) VALUES
(212, 5, 1, 'anal', '2019-12-03', 17),
(213, 5, 1, 'abc', '2019-12-03', 8),
(215, 5, 1, 'forum 3', '2019-12-03', 0),
(216, 6, -1, 'kkk', '2019-12-03', 3),
(217, 1, 1, 'hachem11', '2019-12-03', 6),
(218, 6, -1, 'hhhhhhhhhhhhhhhhhh', '2019-12-03', 0),
(219, 7, 1, '<p>yeah what the fuck is here in the event ???</p>', '2019-12-04', 2),
(220, 7, 1, 'okpfez', '2019-12-04', 0),
(221, 7, -1, '<p>add a new event here</p>', '2019-12-04', 0),
(222, 7, 1, '<p>Rii</p>', '2019-12-04', 0),
(223, 7, 1, 'i want to fuck an anal bitch', '2019-12-04', 0),
(225, 6, 1, '<p>aaaaa</p>', '2019-12-04', 0),
(226, 1, 1, '<p>ok</p>', '2019-12-04', 0),
(228, 2, -1, 'ouh!ljbk', '2019-12-05', 0),
(229, 2, 1, 'forum fuck', '2019-12-05', 11);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_8D93D649C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`) VALUES
(1, 'admin', 'admin', 'admin@esprit.tn', 'admin@esprit.tn', 1, NULL, '$2y$13$b46n9NuvWy/gyOn8n4FQL.8/N3mZah8747pXrDhcF97X6dotAykMm', '2019-12-05 01:29:55', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}'),
(2, 'user', 'user', 'user@esprit.tn', 'user@esprit.tn', 1, NULL, '$2y$13$Yiv3jBF8Tm9mEDyHXXyD3.TjUE2QOYayzHwqP/7euVSzJQbvzjCye', '2019-12-05 01:48:21', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_AGENT\";}');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `notifiable_notification`
--
ALTER TABLE `notifiable_notification`
  ADD CONSTRAINT `FK_ADCFE0FAC3A0A4F8` FOREIGN KEY (`notifiable_entity_id`) REFERENCES `notifiable_entity` (`id`),
  ADD CONSTRAINT `FK_ADCFE0FAEF1A9D84` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`id`);

--
-- Contraintes pour la table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `fk_pub_rat` FOREIGN KEY (`id_pub`) REFERENCES `sujet` (`id_f`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
