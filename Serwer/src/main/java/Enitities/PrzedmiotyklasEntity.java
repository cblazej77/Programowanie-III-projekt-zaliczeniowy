package Enitities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "przedmiotyklas", schema = "public", catalog = "ikyxpswp")
public class PrzedmiotyklasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpk", nullable = false)
    private Long idpk;
    @Basic
    @Column(name = "idp", nullable = false)
    private Long idp;
    @Basic
    @Column(name = "idk", nullable = false)
    private Long idk;
    @ManyToOne
    @JoinColumn(name = "idp", referencedColumnName = "idp", nullable = false, insertable = false, updatable = false)
    private PrzedmiotyEntity przedmiotyByIdp;
    @ManyToOne
    @JoinColumn(name = "idk", referencedColumnName = "idk", nullable = false, insertable = false, updatable = false)
    private KlasyEntity klasyByIdk;

    @Override
    public String toString() {
        return "PrzedmiotyklasEntity{" +
                "idpk=" + idpk +
                ", idp=" + idp +
                ", idk=" + idk +
                '}';
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrzedmiotyklasEntity that = (PrzedmiotyklasEntity) o;
        return Objects.equals(idpk, that.idpk) && Objects.equals(idp, that.idp) && Objects.equals(idk, that.idk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpk, idp, idk);
    }

    public PrzedmiotyEntity getPrzedmiotyByIdp() {
        return przedmiotyByIdp;
    }

    public void setPrzedmiotyByIdp(PrzedmiotyEntity przedmiotyByIdp) {
        this.przedmiotyByIdp = przedmiotyByIdp;
    }

    public KlasyEntity getKlasyByIdk() {
        return klasyByIdk;
    }

    public void setKlasyByIdk(KlasyEntity klasyByIdk) {
        this.klasyByIdk = klasyByIdk;
    }
}
