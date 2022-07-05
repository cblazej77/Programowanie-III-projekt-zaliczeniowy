package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

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
    @Column(
            name = "idp",
            updatable = false
    )
    private Long idp;
    @Column(
            name = "nazwa",
            nullable = false
    )
    private String nazwa;

    @OneToMany(mappedBy = "idp")
    private Set<Oceny> ocenies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idp")
    private Set<Frekwencja> frekwencjas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idp")
    private Set<NauczycielePrzedmiotow> nauczycieleprzedmiotows = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idp")
    private Set<PrzedmiotyKlas> przedmiotyklas = new LinkedHashSet<>();

    public Set<PrzedmiotyKlas> getPrzedmiotyklas() {
        return przedmiotyklas;
    }

    public void setPrzedmiotyklas(Set<PrzedmiotyKlas> przedmiotyklas) {
        this.przedmiotyklas = przedmiotyklas;
    }

    public Set<NauczycielePrzedmiotow> getNauczycieleprzedmiotows() {
        return nauczycieleprzedmiotows;
    }

    public void setNauczycieleprzedmiotows(Set<NauczycielePrzedmiotow> nauczycieleprzedmiotows) {
        this.nauczycieleprzedmiotows = nauczycieleprzedmiotows;
    }

    public Set<Frekwencja> getFrekwencjas() {
        return frekwencjas;
    }

    public void setFrekwencjas(Set<Frekwencja> frekwencjas) {
        this.frekwencjas = frekwencjas;
    }

    public Set<Oceny> getOcenies() {
        return ocenies;
    }

    public void setOcenies(Set<Oceny> ocenies) {
        this.ocenies = ocenies;
    }

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
