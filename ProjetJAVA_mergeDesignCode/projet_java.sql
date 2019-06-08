-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 23, 2019 at 04:52 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projet_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `annee_scolaire`
--

DROP TABLE IF EXISTS `annee_scolaire`;
CREATE TABLE IF NOT EXISTS `annee_scolaire` (
  `IdAnneeSco` int(11) NOT NULL AUTO_INCREMENT,
  `Annee_deb` int(11) NOT NULL,
  `Annee_fin` int(11) NOT NULL,
  PRIMARY KEY (`IdAnneeSco`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `annee_scolaire`
--

INSERT INTO `annee_scolaire` (`IdAnneeSco`, `Annee_deb`, `Annee_fin`) VALUES
(1, 2018, 2019);

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `IdBulletin` int(11) NOT NULL AUTO_INCREMENT,
  `Appreciation_generale` text NOT NULL,
  `IdTrimestre` int(11) NOT NULL,
  `IdEleve` int(11) NOT NULL,
  `IdNote` int(11) NOT NULL,
  PRIMARY KEY (`IdBulletin`),
  KEY `IdTrimestre` (`IdTrimestre`),
  KEY `IdEleve` (`IdEleve`),
  KEY `IdNote` (`IdNote`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bulletin`
--

INSERT INTO `bulletin` (`IdBulletin`, `Appreciation_generale`, `IdTrimestre`, `IdEleve`, `IdNote`) VALUES
(1, 'Travail satisfaisant dans l\'ensemble malgré quelques baisses passagères. Aymeric doit fournir plus d\'efforts !', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `IdClasse` int(11) NOT NULL AUTO_INCREMENT,
  `NomClasse` varchar(255) NOT NULL,
  `Niveau` varchar(255) NOT NULL,
  `IdAnneeSco` int(11) NOT NULL,
  PRIMARY KEY (`IdClasse`),
  KEY `IdAnneeSco` (`IdAnneeSco`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`IdClasse`, `NomClasse`, `Niveau`, `IdAnneeSco`) VALUES
(1, 'TD08', 'ING3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `IdEleve` int(11) NOT NULL AUTO_INCREMENT,
  `IdPersonne` int(11) NOT NULL,
  `IdClasse` int(11) NOT NULL,
  PRIMARY KEY (`IdEleve`),
  KEY `IdPersonne` (`IdPersonne`),
  KEY `IdClasse` (`IdClasse`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eleve`
--

INSERT INTO `eleve` (`IdEleve`, `IdPersonne`, `IdClasse`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `enseigner`
--

DROP TABLE IF EXISTS `enseigner`;
CREATE TABLE IF NOT EXISTS `enseigner` (
  `IdClasse` int(11) NOT NULL,
  `IdProf` int(11) NOT NULL,
  `IdMatiere` int(11) NOT NULL,
  KEY `IdClasse` (`IdClasse`),
  KEY `IdMatiere` (`IdMatiere`),
  KEY `IdProf` (`IdProf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enseigner`
--

INSERT INTO `enseigner` (`IdClasse`, `IdProf`, `IdMatiere`) VALUES
(1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `IdMatiere` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_matiere` varchar(255) NOT NULL,
  PRIMARY KEY (`IdMatiere`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matiere`
--

INSERT INTO `matiere` (`IdMatiere`, `Nom_matiere`) VALUES
(1, 'Mathematiques');

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `IdNote` int(11) NOT NULL AUTO_INCREMENT,
  `Valeur_note` float NOT NULL,
  `Appreciation_note` text,
  `IdMatiere` int(11) NOT NULL,
  `IdEleve` int(11) NOT NULL,
  PRIMARY KEY (`IdNote`),
  KEY `IdMatiere` (`IdMatiere`),
  KEY `IdEleve` (`IdEleve`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`IdNote`, `Valeur_note`, `Appreciation_note`, `IdMatiere`, `IdEleve`) VALUES
(1, 17, 'Très beau travail clochard !', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `IdPersonne` int(11) NOT NULL AUTO_INCREMENT,
  `Type_pers` varchar(255) NOT NULL,
  `Nom_pers` varchar(255) NOT NULL,
  `Prenom_pers` varchar(255) NOT NULL,
  `DateDeNaissance` date NOT NULL,
  PRIMARY KEY (`IdPersonne`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`IdPersonne`, `Type_pers`, `Nom_pers`, `Prenom_pers`, `DateDeNaissance`) VALUES
(1, 'eleve', 'MENAGER', 'Aymeric', '1998-10-16'),
(2, 'professeur', 'MECHKOUR', 'Houari', '1974-05-18');

-- --------------------------------------------------------

--
-- Table structure for table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `IdProf` int(11) NOT NULL AUTO_INCREMENT,
  `IdPersonne` int(11) NOT NULL,
  PRIMARY KEY (`IdProf`),
  KEY `IdPersonne` (`IdPersonne`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professeur`
--

INSERT INTO `professeur` (`IdProf`, `IdPersonne`) VALUES
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `IdTrimestre` int(11) NOT NULL AUTO_INCREMENT,
  `Numero_Trimestre` int(11) NOT NULL,
  `Date_Debut` date NOT NULL,
  `Date_Fin` date NOT NULL,
  `IdAnneeSco` int(11) NOT NULL,
  PRIMARY KEY (`IdTrimestre`),
  KEY `IdAnneeSco` (`IdAnneeSco`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trimestre`
--

INSERT INTO `trimestre` (`IdTrimestre`, `Numero_Trimestre`, `Date_Debut`, `Date_Fin`, `IdAnneeSco`) VALUES
(1, 1, '2018-09-01', '2018-12-20', 1),
(2, 2, '2018-12-21', '2019-03-20', 1),
(3, 3, '2019-03-21', '2019-06-20', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`IdTrimestre`) REFERENCES `trimestre` (`IdTrimestre`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`),
  ADD CONSTRAINT `bulletin_ibfk_3` FOREIGN KEY (`IdNote`) REFERENCES `note` (`IdNote`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`IdAnneeSco`) REFERENCES `annee_scolaire` (`IdAnneeSco`);

--
-- Constraints for table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `eleve_ibfk_1` FOREIGN KEY (`IdPersonne`) REFERENCES `personne` (`IdPersonne`),
  ADD CONSTRAINT `eleve_ibfk_2` FOREIGN KEY (`IdClasse`) REFERENCES `classe` (`IdClasse`);

--
-- Constraints for table `enseigner`
--
ALTER TABLE `enseigner`
  ADD CONSTRAINT `enseigner_ibfk_1` FOREIGN KEY (`IdClasse`) REFERENCES `classe` (`IdClasse`),
  ADD CONSTRAINT `enseigner_ibfk_2` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`),
  ADD CONSTRAINT `enseigner_ibfk_3` FOREIGN KEY (`IdProf`) REFERENCES `professeur` (`IdProf`);

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`IdMatiere`) REFERENCES `matiere` (`IdMatiere`),
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`IdEleve`) REFERENCES `eleve` (`IdEleve`);

--
-- Constraints for table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `professeur_ibfk_1` FOREIGN KEY (`IdPersonne`) REFERENCES `personne` (`IdPersonne`);

--
-- Constraints for table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `trimestre_ibfk_1` FOREIGN KEY (`IdAnneeSco`) REFERENCES `annee_scolaire` (`IdAnneeSco`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
