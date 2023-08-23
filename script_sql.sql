-- Script de création de la base de données ENCHERES
-- Type: MySQL
use eni_encheres;
CREATE TABLE CATEGORIES (
    no_categorie INT AUTO_INCREMENT NOT NULL,
    libelle VARCHAR(30) NOT NULL,
    PRIMARY KEY (no_categorie)
);

CREATE TABLE ENCHERES (
    no_utilisateur INT NOT NULL,
    no_article INT NOT NULL,
    date_enchere DATETIME NOT NULL,
    montant_enchere INT NOT NULL,
    PRIMARY KEY (no_utilisateur, no_article)
);

CREATE TABLE RETRAITS (
    no_article INT NOT NULL,
    rue VARCHAR(30) NOT NULL,
    code_postal VARCHAR(15) NOT NULL,
    ville VARCHAR(30) NOT NULL,
    PRIMARY KEY (no_article)
);

CREATE TABLE UTILISATEURS (
    no_utilisateur INT AUTO_INCREMENT NOT NULL,
    pseudo VARCHAR(30) NOT NULL,
    nom VARCHAR(30) NOT NULL,
    prenom VARCHAR(30) NOT NULL,
    email VARCHAR(20) NOT NULL,
    telephone VARCHAR(15),
    rue VARCHAR(30) NOT NULL,
    code_postal VARCHAR(10) NOT NULL,
    ville VARCHAR(30) NOT NULL,
    mot_de_passe VARCHAR(30) NOT NULL,
    credit INT NOT NULL,
    administrateur TINYINT(1) NOT NULL,
    PRIMARY KEY (no_utilisateur)
);
pseudoinsert into utilisateurs ( pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)
values ( 'Michel_Pseudo','Jean_Nom','Michel','michel@email.com','0560544','2 rue michel','45151','Michelville','lemdp',0,1);
CREATE TABLE ARTICLES_VENDUS (
    no_article INT AUTO_INCREMENT NOT NULL,
    nom_article VARCHAR(30) NOT NULL,
    description VARCHAR(300) NOT NULL,
    date_debut_encheres DATE NOT NULL,
    date_fin_encheres DATE NOT NULL,
    prix_initial INT,
    prix_vente INT,
    no_utilisateur INT NOT NULL,
    no_categorie INT NOT NULL,
    PRIMARY KEY (no_article),
    FOREIGN KEY (no_utilisateur) REFERENCES UTILISATEURS (no_utilisateur) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (no_categorie) REFERENCES CATEGORIES (no_categorie) ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER TABLE ARTICLES_VENDUS ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY (no_utilisateur) REFERENCES UTILISATEURS (no_utilisateur) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ENCHERES ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY (no_article) REFERENCES ARTICLES_VENDUS (no_article) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE RETRAITS ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY (no_article) REFERENCES ARTICLES_VENDUS (no_article) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ARTICLES_VENDUS ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY (no_categorie) REFERENCES CATEGORIES (no_categorie) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ARTICLES_VENDUS ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY (no_utilisateur) REFERENCES UTILISATEURS (no_utilisateur) ON DELETE NO ACTION ON UPDATE NO ACTION;