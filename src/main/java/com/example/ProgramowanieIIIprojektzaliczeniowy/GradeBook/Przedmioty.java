package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Przedmioty {

    @Id
    @SequenceGenerator(
            name = "przedmioty_sequence",
            sequenceName = "przedmioty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "przedmioty_sequence"
    )
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
