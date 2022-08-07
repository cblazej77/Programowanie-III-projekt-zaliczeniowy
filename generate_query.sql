CREATE TABLE frekwencja (
    idf     INTEGER NOT NULL,
    idp     INTEGER NOT NULL,
    idu     INTEGER NOT NULL,
    data    DATE,
    godzina INTEGER,
    rodzaj  VARCHAR(20)
);

ALTER TABLE frekwencja ADD CONSTRAINT frekwencja_pk PRIMARY KEY ( idf );

CREATE TABLE klasy (
    idk             INTEGER NOT NULL,
    nazwa           VARCHAR(20) NOT NULL,
    datarozpoczecia DATE,
    wychowawca      INTEGER NOT NULL
);

ALTER TABLE klasy ADD CONSTRAINT idk PRIMARY KEY ( idk );

CREATE TABLE lekcje (
    idl        INTEGER NOT NULL,
    semestr    INTEGER,
    dzien      VARCHAR(20),
    godzina    INTEGER,
    klasa      INTEGER NOT NULL,
    przedmiot  INTEGER NOT NULL,
    nauczyciel INTEGER NOT NULL
);

ALTER TABLE lekcje ADD CONSTRAINT lekcje_pk PRIMARY KEY ( idl );

CREATE TABLE nauczyciele (
    idn  INTEGER NOT NULL,
    idus INTEGER NOT NULL
);

ALTER TABLE nauczyciele ADD CONSTRAINT nauczyciel_pk PRIMARY KEY ( idn );

CREATE TABLE nauczycieleprzedmiotow (
    idnp INTEGER NOT NULL,
    idn  INTEGER NOT NULL,
    idp  INTEGER NOT NULL
);

ALTER TABLE nauczycieleprzedmiotow ADD CONSTRAINT nauczycieleprzedmiotow_pk PRIMARY KEY ( idnp );

CREATE TABLE oceny (
    ido   INTEGER NOT NULL,
    nazwa VARCHAR(20),
    ocena REAL NOT NULL,
    idu   INTEGER NOT NULL,
    idp   INTEGER NOT NULL
);

ALTER TABLE oceny ADD CONSTRAINT oceny_pk PRIMARY KEY ( ido );

CREATE TABLE przedmioty (
    idp   INTEGER NOT NULL,
    nazwa VARCHAR(20)
);

ALTER TABLE przedmioty ADD CONSTRAINT przedmiot_pk PRIMARY KEY ( idp );

CREATE TABLE przedmiotyklas (
    idpk INTEGER NOT NULL,
    idp  INTEGER NOT NULL,
    idk  INTEGER NOT NULL
);

ALTER TABLE przedmiotyklas ADD CONSTRAINT przedmiotyklas_pk PRIMARY KEY ( idpk );

CREATE TABLE uczniowie (
    idu          INTEGER NOT NULL,
    nrwdzienniku INTEGER,
    idk          INTEGER NOT NULL,
    idus         INTEGER NOT NULL,
    idurodzica   INTEGER NOT NULL
);

ALTER TABLE uczniowie ADD CONSTRAINT idu PRIMARY KEY ( idu );

CREATE TABLE uzytkownicy (
    idus     INTEGER NOT NULL,
    login    VARCHAR(20),
    haslo    VARCHAR(20),
    imie     VARCHAR(20),
    nazwisko VARCHAR(20),
    rola     VARCHAR(20)
);

ALTER TABLE uzytkownicy ADD CONSTRAINT uzytkownicy_pk PRIMARY KEY ( idus );

ALTER TABLE uzytkownicy ADD CONSTRAINT uzytkownicy__un UNIQUE ( login );

ALTER TABLE frekwencja
    ADD CONSTRAINT frekwencja_p_fk FOREIGN KEY ( idp )
        REFERENCES przedmioty ( idp );

ALTER TABLE frekwencja
    ADD CONSTRAINT frekwencja_u_fk FOREIGN KEY ( idu )
        REFERENCES uczniowie ( idu );

ALTER TABLE lekcje
    ADD CONSTRAINT idkv2 FOREIGN KEY ( klasa )
        REFERENCES klasy ( idk );

ALTER TABLE lekcje
    ADD CONSTRAINT idn FOREIGN KEY ( nauczyciel )
        REFERENCES nauczyciele ( idn );

ALTER TABLE lekcje
    ADD CONSTRAINT idp FOREIGN KEY ( przedmiot )
        REFERENCES przedmioty ( idp );

ALTER TABLE uczniowie
    ADD CONSTRAINT idurodzica FOREIGN KEY ( idurodzica )
        REFERENCES uzytkownicy ( idus );

ALTER TABLE uczniowie
    ADD CONSTRAINT klasa FOREIGN KEY ( idk )
        REFERENCES klasy ( idk );

ALTER TABLE nauczyciele
    ADD CONSTRAINT nauczyciele_uzytkownicy_fk FOREIGN KEY ( idus )
        REFERENCES uzytkownicy ( idus );

ALTER TABLE nauczycieleprzedmiotow
    ADD CONSTRAINT nauczycieleprzedmiotow_n_fk FOREIGN KEY ( idn )
        REFERENCES nauczyciele ( idn );

ALTER TABLE nauczycieleprzedmiotow
    ADD CONSTRAINT nauczycieleprzedmiotow_p_fk FOREIGN KEY ( idp )
        REFERENCES przedmioty ( idp );

ALTER TABLE oceny
    ADD CONSTRAINT oceny_przedmioty_fk FOREIGN KEY ( idp )
        REFERENCES przedmioty ( idp );

ALTER TABLE oceny
    ADD CONSTRAINT oceny_uczen_fk FOREIGN KEY ( idu )
        REFERENCES uczniowie ( idu );

ALTER TABLE przedmiotyklas
    ADD CONSTRAINT przedmiotyklas_k_fk FOREIGN KEY ( idk )
        REFERENCES klasy ( idk );

ALTER TABLE przedmiotyklas
    ADD CONSTRAINT przedmiotyklas_p_fk FOREIGN KEY ( idp )
        REFERENCES przedmioty ( idp );

ALTER TABLE uczniowie
    ADD CONSTRAINT uczniowie_uzytkownicy_fk FOREIGN KEY ( idus )
        REFERENCES uzytkownicy ( idus );

ALTER TABLE klasy
    ADD CONSTRAINT wychowawca FOREIGN KEY ( wychowawca )
        REFERENCES nauczyciele ( idn );
