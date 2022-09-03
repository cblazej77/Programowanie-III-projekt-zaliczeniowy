package Enitities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "lekcje", schema = "public", catalog = "ikyxpswp")
public class LekcjeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idl", nullable = false)
    private Long idl;
    @Basic
    @Column(name = "semestr", nullable = true)
    private Integer semestr;
    @Basic
    @Column(name = "dzien", nullable = true, length = 20)
    private String dzien;
    @Basic
    @Column(name = "godzina", nullable = true)
    private Integer godzina;
    @Basic
    @Column(name = "klasa", nullable = false)
    private Long klasa;
    @Basic
    @Column(name = "przedmiot", nullable = false)
    private Long przedmiot;
    @Basic
    @Column(name = "nauczyciel", nullable = false)
    private Long nauczyciel;

    public Long getIdl() {
        return idl;
    }

    public void setIdl(Long idl) {
        this.idl = idl;
    }

    public Integer getSemestr() {
        return semestr;
    }

    public void setSemestr(Integer semestr) {
        this.semestr = semestr;
    }

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public Integer getGodzina() {
        return godzina;
    }

    public void setGodzina(Integer godzina) {
        this.godzina = godzina;
    }

    public Long getKlasa() {
        return klasa;
    }

    public void setKlasa(Long klasa) {
        this.klasa = klasa;
    }

    public Long getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Long przedmiot) {
        this.przedmiot = przedmiot;
    }

    public Long getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(Long nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    @Override
    public String toString() {
        return "LekcjeEntity{" +
                "idl=" + idl +
                ", semestr=" + semestr +
                ", dzien='" + dzien + '\'' +
                ", godzina=" + godzina +
                ", klasa=" + klasa +
                ", przedmiot=" + przedmiot +
                ", nauczyciel=" + nauczyciel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LekcjeEntity that = (LekcjeEntity) o;
        return Objects.equals(idl, that.idl) && Objects.equals(semestr, that.semestr) && Objects.equals(dzien, that.dzien) && Objects.equals(godzina, that.godzina) && Objects.equals(klasa, that.klasa) && Objects.equals(przedmiot, that.przedmiot) && Objects.equals(nauczyciel, that.nauczyciel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idl, semestr, dzien, godzina, klasa, przedmiot, nauczyciel);
    }
}
