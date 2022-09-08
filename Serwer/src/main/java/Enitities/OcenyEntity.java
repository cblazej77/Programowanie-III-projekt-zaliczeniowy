package Enitities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "oceny", schema = "public", catalog = "ikyxpswp")
public class OcenyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ido", nullable = false)
    private Long ido;
    @Basic
    @Column(name = "nazwa", nullable = true, length = 20)
    private String nazwa;
    @Basic
    @Column(name = "ocena", nullable = false, precision = 0)
    private Float ocena;
    @Basic
    @Column(name = "idu", nullable = false)
    private Long idu;
    @Basic
    @Column(name = "idp", nullable = false)
    private Long idp;
    @ManyToOne
    @JoinColumn(name = "idu", referencedColumnName = "idu", nullable = false, insertable = false, updatable = false)
    private UczniowieEntity uczniowieByIdu;
    @ManyToOne
    @JoinColumn(name = "idp", referencedColumnName = "idp", nullable = false, insertable = false, updatable = false)
    private PrzedmiotyEntity przedmiotyByIdp;

    @Override
    public String toString() {
        return "OcenyEntity{" +
                "ido=" + ido +
                ", nazwa='" + nazwa + '\'' +
                ", ocena=" + ocena +
                ", idu=" + idu +
                ", idp=" + idp +
                '}';
    }

    public Long getIdo() {
        return ido;
    }

    public void setIdo(Long ido) {
        this.ido = ido;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OcenyEntity that = (OcenyEntity) o;
        return Objects.equals(ido, that.ido) && Objects.equals(nazwa, that.nazwa) && Objects.equals(ocena, that.ocena) && Objects.equals(idu, that.idu) && Objects.equals(idp, that.idp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ido, nazwa, ocena, idu, idp);
    }

    public UczniowieEntity getUczniowieByIdu() {
        return uczniowieByIdu;
    }

    public void setUczniowieByIdu(UczniowieEntity uczniowieByIdu) {
        this.uczniowieByIdu = uczniowieByIdu;
    }

    public PrzedmiotyEntity getPrzedmiotyByIdp() {
        return przedmiotyByIdp;
    }

    public void setPrzedmiotyByIdp(PrzedmiotyEntity przedmiotyByIdp) {
        this.przedmiotyByIdp = przedmiotyByIdp;
    }
}
