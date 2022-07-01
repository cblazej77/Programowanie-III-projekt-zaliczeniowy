package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;


public class Uzytkownicy {

    private Long idu;
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String rola;

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
