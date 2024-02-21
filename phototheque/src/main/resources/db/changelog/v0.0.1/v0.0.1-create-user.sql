CREATE SEQUENCE categorie_id_seq;
CREATE TABLE Categorie(
   Id_Categorie INT DEFAULT nextval('categorie_id_seq') PRIMARY KEY,
   Nom VARCHAR(50),
   Nombre_img INT
);

CREATE SEQUENCE utilisateur_id_seq;
CREATE TABLE Utilisateur(
   Id_User INT DEFAULT nextval('utilisateur_id_seq') PRIMARY KEY,
   Pseudo VARCHAR(50),
   Nom VARCHAR(50),
   Prenom VARCHAR(50),
   Mdp VARCHAR(50)
);

CREATE SEQUENCE element_img_id_seq;
CREATE TABLE Element_img(
   Id_Element_img INT DEFAULT nextval('element_img_id_seq') PRIMARY KEY,
   Nom_elem VARCHAR(50)
);

CREATE SEQUENCE image_id_seq;
CREATE TABLE Image(
   Id_Image INT DEFAULT nextval('image_id_seq') PRIMARY KEY,
   Nom VARCHAR(50),
   Description TEXT,
   Taille DECIMAL(15,2),
   Date_crea TIMESTAMP,
   Date_modif TIMESTAMP,
   Individu BOOLEAN,
   route VARCHAR(150),
   Id_User INT NOT NULL,
   Id_Categorie INT NOT NULL,
   FOREIGN KEY(Id_User) REFERENCES Utilisateur(Id_User),
   FOREIGN KEY(Id_Categorie) REFERENCES Categorie(Id_Categorie)
);

CREATE TABLE afficher(
   Id_Image INT,
   Id_Element_img INT,
   PRIMARY KEY(Id_Image, Id_Element_img),
   FOREIGN KEY(Id_Image) REFERENCES Image(Id_Image),
   FOREIGN KEY(Id_Element_img) REFERENCES Element_img(Id_Element_img)
);