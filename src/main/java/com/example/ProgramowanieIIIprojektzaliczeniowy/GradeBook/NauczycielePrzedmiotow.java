package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity (
        name = "nauczycieleprzedmiotow"
)
@Table (
        name = "nauczycieleprzedmiotow"
)
public class NauczycielePrzedmiotow {

    @Id
    @SequenceGenerator(
            name = "nauczycieleprzedmiotow_sequence",
            sequenceName = "nauczycieleprzedmiotow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "nauczycieleprzedmiotow_sequence"
    )
    @Column(
            name = "idnp",
            updatable = false
    )
    private Long idnp;
    @Column(
            name = "idn",
            nullable = false
    )
    private Long idn;
    @Column(
            name = "idp",
            nullable = false
    )
    private Long idp;

    public NauczycielePrzedmiotow() {
    }

    public NauczycielePrzedmiotow(Long idnp, Long idn, Long idp) {
        this.idnp = idnp;
        this.idn = idn;
        this.idp = idp;
    }

    public NauczycielePrzedmiotow(Long idn, Long idp) {
        this.idn = idn;
        this.idp = idp;
    }

    public Long getIdnp() {
        return idnp;
    }

    public void setIdnp(Long idnp) {
        this.idnp = idnp;
    }

    public Long getIdn() {
        return idn;
    }

    public void setIdn(Long idn) {
        this.idn = idn;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    @Override
    public String toString() {
        return "NauczycielePrzedmiotow{" +
                "idnp=" + idnp +
                ", idn=" + idn +
                ", idp=" + idp +
                '}';
    }
}
