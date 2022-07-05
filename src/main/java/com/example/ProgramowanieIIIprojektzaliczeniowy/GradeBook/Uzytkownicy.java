package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Uzytkownicy {

    @Id
    @SequenceGenerator(
            name = "uzytkownicy_sequence",
            sequenceName = "uzytkownicy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "uzytkownicy_sequence"
    )
    @Column(
            name = "idu",
            updatable = false
    )
    private Long idu;
    @Column(
            name = "login",
            nullable = false
    )
    private String login;
    @Column(
            name = "haslo",
            nullable = false
    )
    private String haslo;
    @Column(
            name = "imie",
            nullable = false
    )
    private String imie;
    @Column(
            name = "nazwisko",
            nullable = false
    )
    private String nazwisko;
    @Column(
            name = "rola",
            nullable = false
    )
    private String rola;

    @OneToMany(mappedBy = "idu")
    private Set<Nauczyciele> nauczycieles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idurodzica")
    private Set<Uczniowie> uczniowies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "iduucznia")
    private Set<Uczniowie> uczniowies1 = new LinkedHashSet<>();

    public Set<Uczniowie> getUczniowies1() {
        return uczniowies1;
    }

    public void setUczniowies1(Set<Uczniowie> uczniowies1) {
        this.uczniowies1 = uczniowies1;
    }

    public Set<Uczniowie> getUczniowies() {
        return uczniowies;
    }

    public void setUczniowies(Set<Uczniowie> uczniowies) {
        this.uczniowies = uczniowies;
    }

    public Set<Nauczyciele> getNauczycieles() {
        return nauczycieles;
    }

    public void setNauczycieles(Set<Nauczyciele> nauczycieles) {
        this.nauczycieles = nauczycieles;
    }

    public Uzytkownicy() {
    }

    public Uzytkownicy(Long idu, String login, String haslo, String imie, String nazwisko, String rola) {
        this.idu = idu;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rola = rola;
    }

    public Uzytkownicy(String login, String haslo, String imie, String nazwisko, String rola) {
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rola = rola;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    @Override
    public String toString() {
        return "Uzytkownicy{" +
                "idu=" + idu +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", rola='" + rola + '\'' +
                '}';
    }
}
