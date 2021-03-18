-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 18 mars 2021 à 10:21
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionrh`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

DROP TABLE IF EXISTS `adresses`;
CREATE TABLE IF NOT EXISTS `adresses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_postal` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `rue` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `ville` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competences`
--

DROP TABLE IF EXISTS `competences`;
CREATE TABLE IF NOT EXISTS `competences` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competences_formations`
--

DROP TABLE IF EXISTS `competences_formations`;
CREATE TABLE IF NOT EXISTS `competences_formations` (
  `competences_id` bigint(20) NOT NULL,
  `formations_id` bigint(20) NOT NULL,
  KEY `FK3mu965377ya4y9uwp4xlmoodt` (`formations_id`),
  KEY `FK2gqj33dlqln3cvddk6bugupms` (`competences_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competences_postes`
--

DROP TABLE IF EXISTS `competences_postes`;
CREATE TABLE IF NOT EXISTS `competences_postes` (
  `competences_requises_id` bigint(20) NOT NULL,
  `postes_id` bigint(20) NOT NULL,
  KEY `FKbrkxoqgmqt0hrvjb3mon552i5` (`postes_id`),
  KEY `FK1gfwx4ofiqoxi7s6r0dx0w5jh` (`competences_requises_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competences_salaries`
--

DROP TABLE IF EXISTS `competences_salaries`;
CREATE TABLE IF NOT EXISTS `competences_salaries` (
  `competences_id` bigint(20) NOT NULL,
  `salaries_id` bigint(20) NOT NULL,
  KEY `FKbrprfdhqwk7rl88nrasly0kk8` (`salaries_id`),
  KEY `FK4n34vgc70k1fcvvar8weh12wk` (`competences_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `comptesrendus`
--

DROP TABLE IF EXISTS `comptesrendus`;
CREATE TABLE IF NOT EXISTS `comptesrendus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `compte_rendu` varchar(255) NOT NULL,
  `date_creation` date NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `domaines`
--

DROP TABLE IF EXISTS `domaines`;
CREATE TABLE IF NOT EXISTS `domaines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titre` varchar(150) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `entreprises`
--

DROP TABLE IF EXISTS `entreprises`;
CREATE TABLE IF NOT EXISTS `entreprises` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `adresse_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeq8m9pfs3dersxbj4xmh48md1` (`adresse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `entretiens`
--

DROP TABLE IF EXISTS `entretiens`;
CREATE TABLE IF NOT EXISTS `entretiens` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_entretien` date NOT NULL,
  `version` int(11) NOT NULL,
  `compte_rendu_id` bigint(20) DEFAULT NULL,
  `manager_entretien_id` bigint(20) NOT NULL,
  `salarie_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2sbypxo6q8sj8pq0gdd54x988` (`compte_rendu_id`),
  KEY `FKl6ialtobekapieukfe1dplwoo` (`manager_entretien_id`),
  KEY `FKaei6i26f8mybea37mfi8htelw` (`salarie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formations`
--

DROP TABLE IF EXISTS `formations`;
CREATE TABLE IF NOT EXISTS `formations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `duree` float DEFAULT NULL,
  `prix` float NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formations_salaries`
--

DROP TABLE IF EXISTS `formations_salaries`;
CREATE TABLE IF NOT EXISTS `formations_salaries` (
  `formations_id` bigint(20) NOT NULL,
  `salaries_id` bigint(20) NOT NULL,
  KEY `FK409fne3eeoj82l1c2dnqfj8hm` (`salaries_id`),
  KEY `FK4ssarm17svwx9xfibfxck8xon` (`formations_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `postes`
--

DROP TABLE IF EXISTS `postes`;
CREATE TABLE IF NOT EXISTS `postes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_fin` date DEFAULT NULL,
  `fichier_contrat` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `volume_horaire` float DEFAULT NULL,
  `volume_journalier` float DEFAULT NULL,
  `lieu_travail_id` bigint(20) NOT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `salarie_id` bigint(20) NOT NULL,
  `titre_poste_id` bigint(20) NOT NULL,
  `type_contrat_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnje9rild1k14tfd7m0cb6q6r6` (`lieu_travail_id`),
  KEY `FKgxd2e22wou7limt1q9sw8iwdq` (`manager_id`),
  KEY `FKki7nepp86abubieiswpqmq32l` (`salarie_id`),
  KEY `FKnggsls50cejh2omlyfbvjq6o7` (`titre_poste_id`),
  KEY `FKajsrdxavkrph1bmj5uxmi14c2` (`type_contrat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titre` varchar(150) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `roles_salaries`
--

DROP TABLE IF EXISTS `roles_salaries`;
CREATE TABLE IF NOT EXISTS `roles_salaries` (
  `roles_id` bigint(20) NOT NULL,
  `salaries_id` bigint(20) NOT NULL,
  KEY `FKkg7w5paphlb7l513adcbsbk7l` (`salaries_id`),
  KEY `FKlmsvu7r80yhcqcah4b744md1d` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salaries`
--

DROP TABLE IF EXISTS `salaries`;
CREATE TABLE IF NOT EXISTS `salaries` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_naissance` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobil_personnel` varchar(50) DEFAULT NULL,
  `mobile_professionnel` varchar(50) DEFAULT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `si_manager` bit(1) NOT NULL,
  `tel_personnel` varchar(50) DEFAULT NULL,
  `tel_professionnel` varchar(50) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `adresse_id` bigint(20) NOT NULL,
  `domaine_id` bigint(20) NOT NULL,
  `entreprise_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaldobb7ppo8t0d3e787blanaj` (`adresse_id`),
  KEY `FKln9ravrfp2iws6354fb9ngq` (`domaine_id`),
  KEY `FKa8iae7a2lnrhc3nedrrgj3wk1` (`entreprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `titrespostes`
--

DROP TABLE IF EXISTS `titrespostes`;
CREATE TABLE IF NOT EXISTS `titrespostes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `typescontrats`
--

DROP TABLE IF EXISTS `typescontrats`;
CREATE TABLE IF NOT EXISTS `typescontrats` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(150) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `competences_formations`
--
ALTER TABLE `competences_formations`
  ADD CONSTRAINT `FK2gqj33dlqln3cvddk6bugupms` FOREIGN KEY (`competences_id`) REFERENCES `competences` (`id`),
  ADD CONSTRAINT `FK3mu965377ya4y9uwp4xlmoodt` FOREIGN KEY (`formations_id`) REFERENCES `formations` (`id`);

--
-- Contraintes pour la table `competences_postes`
--
ALTER TABLE `competences_postes`
  ADD CONSTRAINT `FK1gfwx4ofiqoxi7s6r0dx0w5jh` FOREIGN KEY (`competences_requises_id`) REFERENCES `competences` (`id`),
  ADD CONSTRAINT `FKbrkxoqgmqt0hrvjb3mon552i5` FOREIGN KEY (`postes_id`) REFERENCES `postes` (`id`);

--
-- Contraintes pour la table `competences_salaries`
--
ALTER TABLE `competences_salaries`
  ADD CONSTRAINT `FK4n34vgc70k1fcvvar8weh12wk` FOREIGN KEY (`competences_id`) REFERENCES `competences` (`id`),
  ADD CONSTRAINT `FKbrprfdhqwk7rl88nrasly0kk8` FOREIGN KEY (`salaries_id`) REFERENCES `salaries` (`id`);

--
-- Contraintes pour la table `entreprises`
--
ALTER TABLE `entreprises`
  ADD CONSTRAINT `FKeq8m9pfs3dersxbj4xmh48md1` FOREIGN KEY (`adresse_id`) REFERENCES `adresses` (`id`);

--
-- Contraintes pour la table `entretiens`
--
ALTER TABLE `entretiens`
  ADD CONSTRAINT `FK2sbypxo6q8sj8pq0gdd54x988` FOREIGN KEY (`compte_rendu_id`) REFERENCES `comptesrendus` (`id`),
  ADD CONSTRAINT `FKaei6i26f8mybea37mfi8htelw` FOREIGN KEY (`salarie_id`) REFERENCES `salaries` (`id`),
  ADD CONSTRAINT `FKl6ialtobekapieukfe1dplwoo` FOREIGN KEY (`manager_entretien_id`) REFERENCES `salaries` (`id`);

--
-- Contraintes pour la table `formations_salaries`
--
ALTER TABLE `formations_salaries`
  ADD CONSTRAINT `FK409fne3eeoj82l1c2dnqfj8hm` FOREIGN KEY (`salaries_id`) REFERENCES `salaries` (`id`),
  ADD CONSTRAINT `FK4ssarm17svwx9xfibfxck8xon` FOREIGN KEY (`formations_id`) REFERENCES `formations` (`id`);

--
-- Contraintes pour la table `postes`
--
ALTER TABLE `postes`
  ADD CONSTRAINT `FKajsrdxavkrph1bmj5uxmi14c2` FOREIGN KEY (`type_contrat_id`) REFERENCES `typescontrats` (`id`),
  ADD CONSTRAINT `FKgxd2e22wou7limt1q9sw8iwdq` FOREIGN KEY (`manager_id`) REFERENCES `salaries` (`id`),
  ADD CONSTRAINT `FKki7nepp86abubieiswpqmq32l` FOREIGN KEY (`salarie_id`) REFERENCES `salaries` (`id`),
  ADD CONSTRAINT `FKnggsls50cejh2omlyfbvjq6o7` FOREIGN KEY (`titre_poste_id`) REFERENCES `titrespostes` (`id`),
  ADD CONSTRAINT `FKnje9rild1k14tfd7m0cb6q6r6` FOREIGN KEY (`lieu_travail_id`) REFERENCES `entreprises` (`id`);

--
-- Contraintes pour la table `roles_salaries`
--
ALTER TABLE `roles_salaries`
  ADD CONSTRAINT `FKkg7w5paphlb7l513adcbsbk7l` FOREIGN KEY (`salaries_id`) REFERENCES `salaries` (`id`),
  ADD CONSTRAINT `FKlmsvu7r80yhcqcah4b744md1d` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`);

--
-- Contraintes pour la table `salaries`
--
ALTER TABLE `salaries`
  ADD CONSTRAINT `FKa8iae7a2lnrhc3nedrrgj3wk1` FOREIGN KEY (`entreprise_id`) REFERENCES `entreprises` (`id`),
  ADD CONSTRAINT `FKaldobb7ppo8t0d3e787blanaj` FOREIGN KEY (`adresse_id`) REFERENCES `adresses` (`id`),
  ADD CONSTRAINT `FKln9ravrfp2iws6354fb9ngq` FOREIGN KEY (`domaine_id`) REFERENCES `domaines` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
