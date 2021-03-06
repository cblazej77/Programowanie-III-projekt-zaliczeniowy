package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Oceny {

    @Id
    @SequenceGenerator(
            name = "oceny_sequence",
            sequenceName = "oceny_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "oceny_sequence"
    )
    @Column(
            name = "ido",
            updatable = false
    )
    private Long ido;
    @Column(
            name = "nazwa",
            nullable = false
    )
    private String nazwa;
    @Column(
            name = "ocena",
            nullable = false
    )
    private Double ocena;

    @Column(
            name = "idu",
            nullable = false
    )
    private Long idu;
    @Column(
            name = "idp",
            nullable = false
    )
    private Long idp;

    public Oceny() {
    }

    public Oceny(Long ido, String nazwa, Double ocena, Long idu, Long idp) {
        this.ido = ido;
        this.nazwa = nazwa;
        this.ocena = ocena;
        this.idu = idu;
        this.idp = idp;
    }

    public Oceny(String nazwa, Double ocena, Long idu, Long idp) {
        this.nazwa = nazwa;
        this.ocena = ocena;
        this.idu = idu;
        this.idp = idp;
    }

    public Long getIdo() {
        return ido;
    }

    public void setIdo(Long ido) {
        this.ido = ido;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    @Override
    public String toString() {
        return "Oceny{" +
                "ido=" + ido +
                ", nazwa='" + nazwa + '\'' +
                ", ocena=" + ocena +
                ", idu=" + idu +
                ", idp=" + idp +
                '}';
    }
}
