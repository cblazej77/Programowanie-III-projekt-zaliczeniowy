package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Nauczyciele {

    @Id
    @SequenceGenerator(
            name = "nauczyciele_sequence",
            sequenceName = "nauczyciele_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "nauczyciele_sequence"
    )
    @Column(
            name = "idn",
            updatable = false
    )
    private Long idn;
    @Column(
            name = "idu",
            nullable = false
    )
    private Long idu;

    @OneToMany(mappedBy = "nauczyciel_idn")
    private Set<Klasy> klasies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idn")
    private Set<NauczycielePrzedmiotow> nauczycieleprzedmiotows = new LinkedHashSet<>();

    public Set<NauczycielePrzedmiotow> getNauczycieleprzedmiotows() {
        return nauczycieleprzedmiotows;
    }

    public void setNauczycieleprzedmiotows(Set<NauczycielePrzedmiotow> nauczycieleprzedmiotows) {
        this.nauczycieleprzedmiotows = nauczycieleprzedmiotows;
    }

    public Set<Klasy> getKlasies() {
        return klasies;
    }

    public void setKlasies(Set<Klasy> klasies) {
        this.klasies = klasies;
    }

    public Nauczyciele() {
    }

    public Nauczyciele(Long idn, Long idu) {
        this.idn = idn;
        this.idu = idu;
    }

    public Nauczyciele(Long idu) {
        this.idu = idu;
    }

    public Long getIdn() {
        return idn;
    }

    public void setIdn(Long idn) {
        this.idn = idn;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    @Override
    public String toString() {
        return "Nauczyciele{" +
                "idn=" + idn +
                ", idu=" + idu +
                '}';
    }
}
