CREATE TABLE categories (
    no_categorie INT AUTO_INCREMENT NOT NULL,
    libelle VARCHAR(30) NOT NULL,
    PRIMARY KEY (no_categorie)
);

CREATE TABLE encheres (
    no_utilisateur INT NOT NULL,
    no_article INT NOT NULL,
    date_enchere DATETIME NOT NULL,
    montant_enchere INT NOT NULL,
    PRIMARY KEY (no_utilisateur, no_article)
);

CREATE TABLE retraits (
    no_article INT NOT NULL,
    rue VARCHAR(30) NOT NULL,
    code_postal VARCHAR(15) NOT NULL,
    ville VARCHAR(30) NOT NULL,
    PRIMARY KEY (no_article)
);

CREATE TABLE utilisateurs (
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
    administrateur BIT NOT NULL,
    PRIMARY KEY (no_utilisateur)
);

CREATE TABLE articles_vendus (
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
    FOREIGN KEY (no_utilisateur) REFERENCES utilisateurs(no_utilisateur) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (no_categorie) REFERENCES categories(no_categorie) ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER TABLE encheres
    ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY (no_article)
    REFERENCES ARTICLES_VENDUS(no_article) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE retraits
    ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY (no_article)
    REFERENCES articles_vendus(no_article) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE articles_vendus
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY (no_utilisateur)
    REFERENCES utilisateurs(no_utilisateur) ON DELETE NO ACTION ON UPDATE NO ACTION;
    
INSERT INTO categories (libelle) VALUES
    ('Informatique'),
    ('Ameublement'),
    ('Vêtement'),
    ('Sport & Loisirs'),
    ('Autre');
INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie)
VALUES
    ('Ordinateur portable', 'Un ordinateur puissant pour tous vos besoins informatiques.', '2023-09-01', '2023-09-10', 800.00, 1, 1),
    ('Canapé en cuir', 'Un canapé confortable en cuir pour votre salon.', '2023-09-02', '2023-09-11', 500.00, 2, 2),
    ('Chemise élégante', 'Une chemise formelle pour les occasions spéciales.', '2023-09-03', '2023-09-12', 40.00, 3, 3),
    ('Raquette de tennis', 'Une raquette légère pour les amateurs de tennis.', '2023-09-04', '2023-09-13', 75.00, 4, 4),
    ('PC de bureau', 'Un ordinateur de bureau rapide et performant.', '2023-09-05', '2023-09-14', 600.00, 2, 1),
    ('Table à manger', 'Une grande table en bois pour les repas en famille.', '2023-09-06', '2023-09-15', 250.00, 1, 2),
    ('Robe de soirée', 'Une robe élégante pour briller lors de soirées.', '2023-09-07', '2023-09-16', 70.00, 3, 3),
    ('Ballon de football', 'Un ballon de football officiel pour vos matchs.', '2023-09-08', '2023-09-17', 20.00, 4, 4),
    ('Imprimante multifonction', 'Une imprimante pour tous vos besoins d\'impression.', '2023-09-09', '2023-09-18', 120.00, 2, 1),
    ('Chaise pliante', 'Une chaise pliable idéale pour les activités extérieures.', '2023-09-10', '2023-09-19', 15.00, 1, 2);
    
INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES
    ('john_doe', 'Doe', 'John', 'john@example.com', '1234567890', '123 Main St', '12345', 'Cityville', 'motdepasse1', 100, 0),
    ('jane_smith', 'Smith', 'Jane', 'jane@example.com', '9876543210', '456 Elm St', '54321', 'Townsville', 'motdepasse2', 150, 0),
    ('alex_jones', 'Jones', 'Alex', 'alex@example.com', '5551234567', '789 Oak St', '67890', 'Villagetown', 'motdepasse3', 200, 1),
    ('emily_wilson', 'Wilson', 'Emily', 'emily@example.com', '7778889999', '101 Pine St', '13579', 'Hamletville', 'motdepasse4', 50, 0),
    ('michael_brown', 'Brown', 'Michael', 'michael@example.com', '1112223333', '222 Cedar St', '24680', 'Countrytown', 'motdepasse5', 300, 0),
    ('sarah_miller', 'Miller', 'Sarah', 'sarah@example.com', '4445556666', '333 Birch St', '98765', 'Cityborough', 'motdepasse6', 75, 0),
    ('david_wilson', 'Wilson', 'David', 'david@example.com', '8889990000', '444 Maple St', '56789', 'Townville', 'motdepasse7', 250, 0),
    ('lisa_jackson', 'Jackson', 'Lisa', 'lisa@example.com', '3334445555', '555 Walnut St', '43210', 'Villageville', 'motdepasse8', 175, 0),
    ('chris_smith', 'Smith', 'Chris', 'chris@example.com', '6667778888', '666 Pine St', '24680', 'Hamletburg', 'motdepasse9', 200, 0),
    ('jessica_davis', 'Davis', 'Jessica', 'jessica@example.com', '9990001111', '777 Oak St', '13579', 'Countryville', 'motdepasse10', 120, 0);
    INSERT INTO retraits (no_article, rue, code_postal, ville)
VALUES
    (1, '123 Rue A', '75001', 'Paris'),
    (2, '456 Rue B', '75002', 'Paris'),
    (3, '789 Rue C', '75003', 'Paris'),
    (4, '101 Rue D', '75004', 'Paris'),
    (5, '202 Rue E', '75005', 'Paris'),
    (6, '303 Rue F', '75006', 'Paris'),
    (7, '404 Rue G', '75007', 'Paris'),
    (8, '505 Rue H', '75008', 'Paris'),
    (9, '606 Rue I', '75009', 'Paris'),
    (10, '707 Rue J', '75010', 'Paris');


