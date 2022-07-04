package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table
public class Uczniowie {

    @Id
    @SequenceGenerator(
            name = "uczniowie_sequence",
            sequenceName = "uczniowie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "uczniowie_sequence"
    )
    private Long iducz;
    private Long nrwdzienniku;
    private Long idk;
    private Long iduucznia;
    private Long idurodzica;

    public Uczniowie() {
    }

    public Uczniowie(Long iducz, Long nrwdzienniku, Long idk, Long iduucznia, Long idurodzica) {
        this.iducz = iducz;
        this.nrwdzienniku = nrwdzienniku;
        this.idk = idk;
        this.iduucznia = iduucznia;
        this.idurodzica = idurodzica;
    }

    public Uczniowie(Long nrwdzienniku, Long idk, Long iduucznia, Long idurodzica) {
        this.nrwdzienniku = nrwdzienniku;
        this.idk = idk;
        this.iduucznia = iduucznia;
        this.idurodzica = idurodzica;
    }

    public Long getIducz() {
        return iducz;
    }

    public void setIducz(Long iducz) {
        this.iducz = iducz;
    }

    public Long getNrwdzienniku() {
        return nrwdzienniku;
    }

    public void setNrwdzienniku(Long nrwdzienniku) {
        this.nrwdzienniku = nrwdzienniku;
    }

    public Long getIdk() {
        return idk;
    }

    public void setIdk(Long idk) {
        this.idk = idk;
    }

    public Long getIduucznia() {
        return iduucznia;
    }

    public void setIduucznia(Long iduucznia) {
        this.iduucznia = iduucznia;
    }

    public Long getIdurodzica() {
        return idurodzica;
    }

    public void setIdurodzica(Long idurodzica) {
        this.idurodzica = idurodzica;
    }

    @Override
    public String toString() {
        return "Uczniowie{" +
                "iducz=" + iducz +
                ", nrwdzienniku=" + nrwdzienniku +
                ", idk=" + idk +
                ", iduucznia=" + iduucznia +
                ", idurodzica=" + idurodzica +
                '}';
    }
}
