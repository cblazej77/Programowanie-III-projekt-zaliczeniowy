package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Klasy {

    private Long idk;
    private String nazwa;
    private LocalDate datarozpoczecia;
    private Integer nauczyciel_idn;

    public Klasy() {
    }

    public Klasy(Long idk, String nazwa, LocalDate datarozpoczecia, Integer nauczyciel_idn) {
        this.idk = idk;
        this.nazwa = nazwa;
        this.datarozpoczecia = datarozpoczecia;
        this.nauczyciel_idn = nauczyciel_idn;
    }

    public Klasy(String nazwa, LocalDate datarozpoczecia, Integer nauczyciel_idn) {
        this.nazwa = nazwa;
        this.datarozpoczecia = datarozpoczecia;
        this.nauczyciel_idn = nauczyciel_idn;
    }

    public Long getIdk() {
        return idk;
    }

    public void setIdk(Long idk) {
        this.idk = idk;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public LocalDate getDatarozpoczecia() {
        return datarozpoczecia;
    }

    public void setDatarozpoczecia(LocalDate datarozpoczecia) {
        this.datarozpoczecia = datarozpoczecia;
    }

    public Integer getNauczyciel_idn() {
        return nauczyciel_idn;
    }

    public void setNauczyciel_idn(Integer nauczyciel_idn) {
        this.nauczyciel_idn = nauczyciel_idn;
    }

    @Override
    public String toString() {
        return "Klasy{" +
                "idk=" + idk +
                ", nazwa='" + nazwa + '\'' +
                ", datarozpoczecia=" + datarozpoczecia +
                ", nauczyciel_idn=" + nauczyciel_idn +
                '}';
    }
}
