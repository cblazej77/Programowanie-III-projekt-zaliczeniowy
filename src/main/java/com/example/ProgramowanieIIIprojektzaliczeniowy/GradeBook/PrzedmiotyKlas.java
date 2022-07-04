package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PrzedmiotyKlas {

    private Long idpk;
    private Long idp;
    private Long idk;

    public PrzedmiotyKlas() {
    }

    public PrzedmiotyKlas(Long idpk, Long idp, Long idk) {
        this.idpk = idpk;
        this.idp = idp;
        this.idk = idk;
    }

    public PrzedmiotyKlas(Long idp, Long idk) {
        this.idp = idp;
        this.idk = idk;
    }

    public Long getIdpk() {
        return idpk;
    }

    public void setIdpk(Long idpk) {
        this.idpk = idpk;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public Long getIdk() {
        return idk;
    }

    public void setIdk(Long idk) {
        this.idk = idk;
    }

    @Override
    public String toString() {
        return "PrzedmiotyKlas{" +
                "idpk=" + idpk +
                ", idp=" + idp +
                ", idk=" + idk +
                '}';
    }
}
