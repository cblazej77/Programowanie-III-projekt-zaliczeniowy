package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

public class Przedmioty {

    private Long idp;
    private String nazwa;

    public Przedmioty() {
    }

    public Przedmioty(Long idp, String nazwa) {
        this.idp = idp;
        this.nazwa = nazwa;
    }

    public Przedmioty(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Przedmioty{" +
                "idp=" + idp +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
