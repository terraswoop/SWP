--DROP DATABASE IF EXISTS Bestellung;
--CREATE DATABASE Bestellung;

CREATE TABLE Kunde(
	ID Serial primary key,
	TitelV varchar(255),
	Vorname varchar(255),
	Nachname varchar(255),
	TitelN varchar(255)
);

CREATE TABLE Adresse(
	ID Serial primary key,
    Stadt varchar(255),
    Strasse varchar(255),
    PLZ int,
    Hnr varchar(255)
);

CREATE TABLE Bestellung_v3(
	ID Serial primary key,	
    Kunde_ID Integer,
    Adresse_Rechnung_ID Integer,
    Adresse_Liefer_ID Integer,
    foreign key (Kunde_ID) references Kunde (ID) on delete cascade,
    foreign key (Adresse_Liefer_ID) references Adresse (ID)
);

alter table bestellung_v3(
	drop foreign key (Kunde_ID) references Kunde (ID),
	add foreign key (Kunde_ID) references Kunde (ID) on delete cascade
);
CREATE TABLE Artikel(
	ID Serial primary key,
    Name varchar(255),
    Preis double precision
);

CREATE TABLE Bestellung_Artikel(
	Bestell_ID Serial,
    Artikel_ID Serial,
    Menge Integer,
    primary key(Bestell_ID, Artikel_ID),
    foreign key (Bestell_ID) references Bestellung_v3 (ID) on delete cascade,
    foreign key (Artikel_ID) references Artikel (ID)
);

--ALTER TABLE public.Bestellung_Artikel DROP CONSTRAINT bestellung_artikel_bestell_id_fkey;
--ALTER TABLE public.Bestellung_Artikel ADD CONSTRAINT Bestellung_id_fk FOREIGN KEY (bestell_id) REFERENCES public.bestellung_v3(id) ON DELETE CASCADE;