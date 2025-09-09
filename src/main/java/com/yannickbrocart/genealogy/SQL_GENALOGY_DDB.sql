--
-- S Q L
--

CREATE DATABASE genealogy CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE genealogy;

--
-- Genealogy table
--
DROP TABLE IF EXISTS genealogy;
CREATE TABLE IF NOT EXISTS genealogy (
  id           			BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  name                  VARCHAR(90)        NOT NULL,
  creation_time         DATETIME           NOT NULL,
  last_access_time      DATETIME           DEFAULT NULL,
  last_modified_time    DATETIME           DEFAULT NULL,
  created_by_id         BIGINT UNSIGNED    NOT NULL,
  last_modified_by_id   BIGINT UNSIGNED    DEFAULT NULL,
  status                ENUM ('created', 'in_progress', 'pending', 'ended', 'canceled') DEFAULT 'created',
  PRIMARY KEY (id),  
  UNIQUE (name)
);
INSERT INTO genealogy (id, name, creation_time, last_access_time, last_modified_time, created_by_id, last_modified_by_id, status ) VALUES
(1, 'Généalogie de Yannick Brocart', '2025-02-01 21:25:33', '2025-02-19 15:33:02', '2025-02-19 16:47:11', 1, 1, 'created'),
(2, 'Généalogie des Rois Anglais',   '2025-02-05 14:02:22', '2025-02-16 16:33:01', '2025-02-16 19:43:07', 1, 2, 'created'),
(3, 'Généalogie de Louis XIV', 	     '2025-02-10 19:00:59', '2025-02-22 20:17:07', '2025-02-19 22:41:21', 1, 1, 'created'),
(4, 'Généalogie de Louis XVIII', 	 '2025-04-25 12:41:55', '2025-05-07 22:03:59', '2025-05-07 23:14:19', 5, 5, 'created'),
(5, 'Généalogie de Jean Moulins', 	 '2025-05-03 16:52:23', '2025-05-03 15:30:24', '2025-05-03 21:44:03', 4, 4, 'created');


--
-- User table
--
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  firstname             VARCHAR(90)        NOT NULL,
  lastname              VARCHAR(90)        NOT NULL,
  username              VARCHAR(90)        NOT NULL,
  email                 VARCHAR(180)       NOT NULL,
  registration_date     DATETIME           NOT NULL,
  roles                 ENUM ('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPER_ADMIN') DEFAULT 'ROLE_USER',
  is_verified           TINYINT(1)         DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE (username),
  UNIQUE (email)
);
INSERT INTO user (id, firstname, lastname, username, email, registration_date, roles, is_verified) VALUES
(1, 'Yannick',    'Brocart',  'yannickbrocart', 'mail@yannickbrocart.com', '2025-02-01 14:02:22', 'ROLE_ADMIN', 1),
(2, 'Franck',     'Desnoyer', 'fdesnoyer',      'f.desnoyer@free.fr',      '2025-02-15 22:21:19', 'ROLE_USER',  1),
(3, 'Amélie',     'Moriac',   'amelieM',        'moriac.amelie@gmail.com', '2025-04-22 16:59:22', 'ROLE_USER',  0),
(4, 'Jean',       'Dubois',   'jeandubois',     'jean.dubois@free.fr',     '2025-04-24 16:30:21', 'ROLE_USER',  1),
(5, 'Christelle', 'Noirot',   'chris-noirot',   'chnoirot@yahoo.fr',       '2025-04-29 20:32:44', 'ROLE_USER',  1);


--
-- Individual table
--
DROP TABLE IF EXISTS individual;
CREATE TABLE IF NOT EXISTS individual (
  id					BIGINT UNSIGNED	   NOT NULL        AUTO_INCREMENT,
  sex					ENUM ('Male', 'Female', 'Unknown', 'Intersex', 'Not recorded') DEFAULT NULL,
  individualEvents		BIGINT UNSIGNED    DEFAULT NULL,
  genealogy				BIGINT UNSIGNED    NOT NULL,
  childToFamily 		BIGINT UNSIGNED    DEFAULT NULL,
  isPrivate 			TINYINT(1) 	       DEFAULT true,
  PRIMARY KEY (id)
);
INSERT INTO individual (id, sex, individualEvents, genealogy, childToFamily, isPrivate) VALUES
(1, 'Male',   1, 1, 1,    false),
(2, 'Male',   2, 1, 2,    false),
(3, 'Female', 3, 1, 3,    false),
(4, 'Male',   4, 1, NULL, false),
(5, 'Female', 5, 1, NULL, false),
(6, 'Male',   6, 1, NULL, false),
(7, 'Female', 7, 1, NULL, false);


--
-- Family table
--
DROP TABLE IF EXISTS family;
CREATE TABLE IF NOT EXISTS family (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  genealogy				BIGINT UNSIGNED    NOT NULL,
  husband				BIGINT UNSIGNED    DEFAULT NULL,
  wife   				BIGINT UNSIGNED    DEFAULT NULL,
  PRIMARY KEY (id)
);
INSERT INTO family (id, genealogy, husband, wife) VALUES
(1, 1, 2, 3),
(2, 1, 4, 5),
(3, 1, 6, 7);

--
-- Constraint for Individual table
--
ALTER TABLE individual
  ADD CONSTRAINT FOREIGN KEY (genealogy) REFERENCES genealogy (id),
  ADD CONSTRAINT FOREIGN KEY (childToFamily) REFERENCES family (id);
  
--
-- Constraint for Family table
--
ALTER TABLE family
  ADD CONSTRAINT FOREIGN KEY (genealogy) REFERENCES genealogy (id),
  ADD CONSTRAINT FOREIGN KEY (husband) REFERENCES individual (id),
  ADD CONSTRAINT FOREIGN KEY (wife) REFERENCES individual (id);
    

--
-- IndividualEvent table
--
DROP TABLE IF EXISTS individual_events;
CREATE TABLE IF NOT EXISTS individual_events (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  birthDetail           BIGINT UNSIGNED    DEFAULT NULL,
  deathDetail           BIGINT UNSIGNED    DEFAULT NULL,
  PRIMARY KEY (id)
);
INSERT INTO individual_events (id, birth_detail, death_detail) VALUES
(1, 1, NULL),
(2, 2, NULL),
(3, 3, NULL),
(4, 8, 4),
(5, 9, 5),
(6, 10, 6),
(7, 11, 7);

--
-- Constraint for Individual table
--
ALTER TABLE individual
  ADD CONSTRAINT FOREIGN KEY (individualEvents) REFERENCES individual_events (id);
  
  
--
-- IndividualEventDetail table
--
DROP TABLE IF EXISTS individual_event_detail;
CREATE TABLE IF NOT EXISTS individual_event_detail (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  ageAtEvent            VARCHAR(13)        DEFAULT NULL,
  type                  VARCHAR(30)        DEFAULT NULL,
  date                  DATE               DEFAULT NULL,
  responsibleAgency     VARCHAR(120)       DEFAULT NULL,
  religiousAffiliation  VARCHAR(30)        DEFAULT NULL,
  cause                 VARCHAR(30)        DEFAULT NULL,
  place                 BIGINT UNSIGNED    DEFAULT NULL,
  PRIMARY KEY (id)
);
INSERT INTO individual_event_detail (id, ageAtEvent, type, date, responsibleAgency, religiousAffiliation, cause, place) VALUES
(1,  NULL, NULL, '1971-08-15', NULL, NULL, NULL, 1),
(2,  NULL, NULL, '1945-05-20', NULL, NULL, NULL, 1),
(3,  NULL, NULL, '1947-10-04', NULL, NULL, NULL, 1),
(4,  NULL, NULL, '1998-03-26', NULL, NULL, NULL, 1),
(5,  NULL, NULL, '2018-10-04', NULL, NULL, NULL, 1),
(6,  NULL, NULL, '2004-08-26', NULL, NULL, NULL, 1),
(7,  NULL, NULL, '2006-03-01', NULL, NULL, NULL, 1),
(8,  NULL, NULL, '1920-10-09', NULL, NULL, NULL, 1),
(9,  NULL, NULL, '1919-10-29', NULL, NULL, NULL, 1),
(10, NULL, NULL, '1920-09-15', NULL, NULL, NULL, 1),
(11, NULL, NULL, '1920-03-15', NULL, NULL, NULL, 1);

--
-- Constraint for IndividualEvents table
--
ALTER TABLE individual_events
  ADD CONSTRAINT FOREIGN KEY (birthDetail) REFERENCES individual_event_detail (id),
  ADD CONSTRAINT FOREIGN KEY (deathDetail) REFERENCES individual_event_detail (id);
  
  
--
-- Place table
--
DROP TABLE IF EXISTS place;
CREATE TABLE IF NOT EXISTS place (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  town	             	VARCHAR(120)       NOT NULL,
  inseeCode        		VARCHAR(5)         DEFAULT NULL,
  postalCode        	VARCHAR(5)         DEFAULT NULL,
  department        	VARCHAR(30)        DEFAULT NULL,
  region        		VARCHAR(30)        DEFAULT NULL,
  country        		VARCHAR(30)        DEFAULT NULL,
  latitude        		DOUBLE PRECISION   DEFAULT NULL,
  longitude        		DOUBLE PRECISION   DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE (inseeCode),
);
INSERT INTO place (id, town, inseeCode, postalCode, department, region, country, latitude, longitude) VALUES
(1, 'Montluçon', '03185', '03100', 'Allier', 'Auvergne-Rhône-Alpes', 'France', '46.3333', '2.6'),
(2, 'Nice', '06088', '06000', 'Alpes-Maritimes', "Provence-Alpes-Côte D'Azur", 'France', '43.7031', '7.2661'),
(3, 'Vieure', '03312',  '03430', 'Allier', 'Auvergne-Rhône-Alpes', 'France', '46.3007', '2.5236'),
(4, 'Digoin', '71176', '71160', 'Saône-Et-Loire', 'Bourgogne', 'France', '46.2858', '3.5903'),
(5, 'Saint-Amand Montrond', '18197', '18200', 'Cher', 'Centre-Val de Loire', 'France', '46.7167', '2.5167'),
(6, 'Désertines', '03098', '03630', 'Allier', 'Auvergne-Rhône-Alpes', 'France', '46.2121', '2.3721'),
(7, 'Chavenon', '03070', '03440', 'Allier', 'Auvergne-Rhône-Alpes', 'France', '46.2453', '2.5650'),
(8, 'Paray-Le-Monial', '71342', '71600', 'Saône-Et-Loire', 'Bourgogne', 'France', '46.2709', '4.0714'),
(9, 'Charolles', '71106', '71120', 'Saône-Et-Loire', 'Bourgogne', 'France', '46.2604', '4.1631'),
(10, 'Arcomps', '18009', '18200', 'Cher', 'Centre-Val de Loire', 'France', '46.4036', '2.2601'),
(11, 'Grasse', '06069', '06130', 'Alpes-Maritimes', "Provence-Alpes-Côte D'Azur", 'France', '43.40', '6.55'),
(12, 'Épineuil-Le-Fleuriel', '18089', '18360', 'Cher', 'Centre-Val de Loire', 'France', '46.3335', '2.3504'),
(13, 'Le Havre', '76351', '76600', 'Seine-Maritime', 'Normandie', 'France', '49.2924', '0.06'),
(14, 'Paris 12', '75112', '75012', 'Paris', 'Île-De-France', 'France', '48.5028', '2.2317'),
(15, 'Toulon', '83137', '83000', 'Var', "Provence-Alpes-Côte D'Azur", 'France', '43.0720', '5.5548'),
(16, 'Peille', '06091', '06440', 'Alpes-Maritimes', "Provence-Alpes-Côte D'Azur", 'France', '43.4814', '7.2410'),
(17, 'Saint-Pierre-Les-Étieux', '18231', '18210', 'Cher', 'Centre-Val de Loire', 'France', '46.4420', '2.3540'),
(18, 'Paris 14', '75114', '75014', 'Paris', 'Île-De-France', 'France', '48.4959', '2.1936');

--
-- Constraint for IndividualEventDetail table
--
ALTER TABLE individual_event_detail
  ADD CONSTRAINT FOREIGN KEY (place) REFERENCES place (id);
  
  
--
-- Name table
--
DROP TABLE IF EXISTS name;
CREATE TABLE IF NOT EXISTS name (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  individual			BIGINT UNSIGNED    NOT NULL,
  type	             	ENUM ('Aka"', 'Birth', 'Immigrant', 'Maiden', 'User defined', 'Married') DEFAULT NULL,
  name_pieces	       	BIGINT UNSIGNED    DEFAULT NULL,
  date	             	DATE               DEFAULT NULL,
  PRIMARY KEY (id)
);
INSERT INTO name (id, individual, type, name_pieces, date) VALUES
(1, 1, 'Birth', 1, '1971-08-15'),
(2, 2, 'Birth', 2, '1945-05-20'),
(3, 3, 'Birth', 3, '1947-10-04'),
(4, 4, 'Birth', 4, '1920-10-09'),
(5, 5, 'Birth', 5, '1919-10-29'),
(6, 6, 'Birth', 6, '1920-09-15'),
(7, 7 ,'Birth', 7, '1920-03-15');

--
-- Constraint for Name table
--
ALTER TABLE name
  ADD CONSTRAINT FOREIGN KEY (individual) REFERENCES individual (id);
  

--
-- NamePiece table
--
DROP TABLE IF EXISTS name_piece;
CREATE TABLE IF NOT EXISTS name_piece (
  id                    BIGINT UNSIGNED    NOT NULL        AUTO_INCREMENT,
  name					BIGINT UNSIGNED    NOT NULL,
  prefix	            VARCHAR(30)        DEFAULT NULL,
  given	            	VARCHAR(120)       DEFAULT NULL,
  nickname	            VARCHAR(30)        DEFAULT NULL,
  surnamePrefix	        VARCHAR(30)        DEFAULT NULL,
  surname	            VARCHAR(120)       DEFAULT NULL,
  suffix	            VARCHAR(30)        DEFAULT NULL,
  PRIMARY KEY (id)
);
INSERT INTO name_piece (id, name, prefix, given, nickname, surnamePrefix, surname, suffix) VALUES
(1, 1, NULL, 'Brocart',   NULL, NULL, 'Yannick',      NULL),
(2, 2, NULL, 'Brocart',   NULL, NULL, 'Pierre-Alain', NULL),
(3, 3, NULL, 'Lieudenot', NULL, NULL, 'Jacqueline',   NULL),
(4, 4, NULL, 'Brocart',   NULL, NULL, 'Marius',       NULL),
(5, 5, NULL, 'Cellière',  NULL, NULL, 'Odette',       NULL),
(6, 6, NULL, 'Lieudenot', NULL, NULL, 'René',         NULL),
(7, 7, NULL, 'Bravy',     NULL, NULL, 'Marie',        NULL);

--
-- Constraint for NamePiece table
--
ALTER TABLE name_piece
  ADD CONSTRAINT FOREIGN KEY (name) REFERENCES name (id);