package Enitities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "nauczycieleprzedmiotow", schema = "public", catalog = "ikyxpswp")
public class NauczycieleprzedmiotowEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idnp", nullable = false)
    private Long idnp;
    @Basic
    @Column(name = "idn", nullable = false)
    private Long idn;
    @Basic
    @Column(name = "idp", nullable = false)
    private Long idp;
    @ManyToOne
    @JoinColumn(name = "idn", referencedColumnName = "idn", nullable = false, insertable = false, updatable = false)
    private NauczycieleEntity nauczycieleByIdn;
    @ManyToOne
    @JoinColumn(name = "idp", referencedColumnName = "idp", nullable = false, insertable = false, updatable = false)
    private PrzedmiotyEntity przedmiotyByIdp;

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
        return "NauczycieleprzedmiotowEntity{" +
                "idnp=" + idnp +
                ", idn=" + idn +
                ", idp=" + idp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NauczycieleprzedmiotowEntity that = (NauczycieleprzedmiotowEntity) o;
        return Objects.equals(idnp, that.idnp) && Objects.equals(idn, that.idn) && Objects.equals(idp, that.idp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idnp, idn, idp);
    }

    public NauczycieleEntity getNauczycieleByIdn() {
        return nauczycieleByIdn;
    }

    public void setNauczycieleByIdn(NauczycieleEntity nauczycieleByIdn) {
        this.nauczycieleByIdn = nauczycieleByIdn;
    }

    public PrzedmiotyEntity getPrzedmiotyByIdp() {
        return przedmiotyByIdp;
    }

    public void setPrzedmiotyByIdp(PrzedmiotyEntity przedmiotyByIdp) {
        this.przedmiotyByIdp = przedmiotyByIdp;
    }
}
