package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class NauczycielePrzedmiotow {

    private Long idnp;
    private Long idn;
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
