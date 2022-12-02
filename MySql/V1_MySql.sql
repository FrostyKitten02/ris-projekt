DROP TABLE IF EXISTS uporabnik;

CREATE TABLE uporabnik (
    id BIGINT NOT NULL UNIQUE auto_increment,
    ime VARCHAR(255) NOT NULL,
    priimek VARCHAR(255) NOT NULL,
    datum_rojstva DATE,
    drzavljanstvo VARCHAR(255),
    je_zaposlen BOOLEAN NOT NULL,
    aktiven BOOLEAN NOT NULL,
    geslo VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
)