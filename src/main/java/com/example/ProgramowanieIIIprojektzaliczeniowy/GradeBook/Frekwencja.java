package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Frekwencja {

    @Id
    @SequenceGenerator(
            name = "frekwencja_sequence",
            sequenceName = "frekwencja_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "frekwencja_sequence"
    )
    @Column(
            name = "idf",
            updatable = false
    )
    private Long idf;
    @Column(
            name = "idp",
            nullable = false
    )
    private Long idp;

    @Column(
            name = "iducz",
            nullable = false
    )
    private Long iducz;
    @Column(
            name = "data",
            nullable = false
    )
    private LocalDate data;
    @Column(
            name = "godzina",
            nullable = false
    )
    private Integer godzina;
    @Column(
            name = "rodzaj",
            nullable = false
    )
    private String rodzaj;

    public Frekwencja() {
    }

    public Frekwencja(Long idf, Long idp, Long iducz, LocalDate data, Integer godzina, String rodzaj) {
        this.idf = idf;
        this.idp = idp;
        this.iducz = iducz;
        this.data = data;
        this.godzina = godzina;
        this.rodzaj = rodzaj;
    }

    public Frekwencja(Long idp, Long iducz, LocalDate data, Integer godzina, String rodzaj) {
        this.idp = idp;
        this.iducz = iducz;
        this.data = data;
        this.godzina = godzina;
        this.rodzaj = rodzaj;
    }

    public Long getIdf() {
        return idf;
    }

    public void setIdf(Long idf) {
        this.idf = idf;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public Long getIducz() {
        return iducz;
    }

    public void setIducz(Long iducz) {
        this.iducz = iducz;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getGodzina() {
        return godzina;
    }

    public void setGodzina(Integer godzina) {
        this.godzina = godzina;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Override
    public String toString() {
        return "Frekwencja{" +
                "idf=" + idf +
                ", idp=" + idp +
                ", iducz=" + iducz +
                ", data=" + data +
                ", godzina=" + godzina +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }
}
