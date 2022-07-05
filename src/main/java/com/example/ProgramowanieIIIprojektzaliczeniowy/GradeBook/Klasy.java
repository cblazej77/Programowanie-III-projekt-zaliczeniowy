package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Klasy {

    @Id
    @SequenceGenerator(
            name = "klasy_sequence",
            sequenceName = "klasy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "klasy_sequence"
    )
    @Column(
            name = "idk",
            updatable = false
    )
    private Long idk;
    @Column(
            name = "nazwa",
            nullable = false
    )
    private String nazwa;
    @Column(
            name = "datarozpoczecia",
            nullable = false
    )
    private LocalDate datarozpoczecia;
    @Column(
            name = "nauczyciel_idn",
            nullable = false
    )
    private Integer nauczyciel_idn;

    @OneToMany(mappedBy = "idk")
    private Set<Uczniowie> uczniowies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idk")
    private Set<PrzedmiotyKlas> przedmiotyklas = new LinkedHashSet<>();

    public Set<PrzedmiotyKlas> getPrzedmiotyklas() {
        return przedmiotyklas;
    }

    public void setPrzedmiotyklas(Set<PrzedmiotyKlas> przedmiotyklas) {
        this.przedmiotyklas = przedmiotyklas;
    }

    public Set<Uczniowie> getUczniowies() {
        return uczniowies;
    }

    public void setUczniowies(Set<Uczniowie> uczniowies) {
        this.uczniowies = uczniowies;
    }

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
