package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Frekwencja {

    @Id
    private Long idf;
    private Long idp;
    private Long iducz;
    private LocalDate data;
    private Integer godzina;
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
