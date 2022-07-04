package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

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
    private Long idn;
    private Long idu;

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
