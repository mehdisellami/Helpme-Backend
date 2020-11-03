-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 27 oct. 2020 à 15:27
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_helpme`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent_client`
--

DROP TABLE IF EXISTS `adherent_client`;
CREATE TABLE IF NOT EXISTS `adherent_client` (
  `id_adherent_client` int NOT NULL,
  `pseudo_adherent_client` text NOT NULL,
  `nom_adherent_client` varchar(50) NOT NULL,
  `prenom_adherent_client` varchar(50) NOT NULL,
  `date_inscription_adherent_client` date NOT NULL,
  `sexe_adherent_client` tinyint(1) NOT NULL,
  `ref_id_coordonnes_gps_client` int DEFAULT NULL,
  PRIMARY KEY (`id_adherent_client`),
  KEY `fk_client_gps` (`ref_id_coordonnes_gps_client`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `adherent_client`
--

INSERT INTO `adherent_client` (`id_adherent_client`, `pseudo_adherent_client`, `nom_adherent_client`, `prenom_adherent_client`, `date_inscription_adherent_client`, `sexe_adherent_client`, `ref_id_coordonnes_gps_client`) VALUES
(1, 'jean', 'marc', 'jean', '2020-10-27', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `adherent_livreur`
--

DROP TABLE IF EXISTS `adherent_livreur`;
CREATE TABLE IF NOT EXISTS `adherent_livreur` (
  `id_adherent_livreur` int NOT NULL,
  `pseudo_adherent_livreur` text NOT NULL,
  `nom_adherent_livreur` varchar(50) NOT NULL,
  `prenom_adherent_livreur` varchar(50) NOT NULL,
  `date_naissance_livreur` date NOT NULL,
  `sexe_livreur` int NOT NULL,
  `ref_id_mission` int DEFAULT NULL,
  `ref_id_coordonnes_gps_livreur` int DEFAULT NULL,
  KEY `fk_livreur_mission` (`ref_id_mission`),
  KEY `fk_livreur_gps` (`ref_id_coordonnes_gps_livreur`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `adherent_livreur`
--

INSERT INTO `adherent_livreur` (`id_adherent_livreur`, `pseudo_adherent_livreur`, `nom_adherent_livreur`, `prenom_adherent_livreur`, `date_naissance_livreur`, `sexe_livreur`, `ref_id_mission`, `ref_id_coordonnes_gps_livreur`) VALUES
(1, 'Paul', 'Dupond', 'Paul', '1998-10-01', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `coordonnees_gps`
--

DROP TABLE IF EXISTS `coordonnees_gps`;
CREATE TABLE IF NOT EXISTS `coordonnees_gps` (
  `id_coordonnees_gps` int NOT NULL,
  `longitude` int DEFAULT NULL,
  `latitude` int DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `coordonnees_gps`
--

INSERT INTO `coordonnees_gps` (`id_coordonnees_gps`, `longitude`, `latitude`) VALUES
(1, 2, 49),
(2, 2, 49);

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

DROP TABLE IF EXISTS `mission`;
CREATE TABLE IF NOT EXISTS `mission` (
  `id_mission` int NOT NULL,
  `titre_mission` text NOT NULL,
  `thematique_mission` text NOT NULL,
  `description_mission` text NOT NULL,
  `prix_mission` int NOT NULL,
  `pourboire_mission` int NOT NULL,
  `ref_adherent_client` int DEFAULT NULL,
  KEY `fk_client_mission` (`ref_adherent_client`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`id_mission`, `titre_mission`, `thematique_mission`, `description_mission`, `prix_mission`, `pourboire_mission`, `ref_adherent_client`) VALUES
(1, 'Acheter du pain à la boulangerie', 'achat ', 'je ne peux pas me déplacer\r\nEst -ce que quelqu\'un peut passer à la boulangerie m\'acheter du pain', 3, 2, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
