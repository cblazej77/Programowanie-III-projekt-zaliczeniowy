package Enitities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "frekwencja", schema = "public", catalog = "ikyxpswp")
public class FrekwencjaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idf", nullable = false)
    private Long idf;
    @Basic
    @Column(name = "idp", nullable = false)
    private Long idp;
    @Basic
    @Column(name = "idu", nullable = false)
    private Long idu;
    @Basic
    @Column(name = "data", nullable = true)
    private Date data;
    @Basic
    @Column(name = "godzina", nullable = true)
    private Integer godzina;
    @Basic
    @Column(name = "rodzaj", nullable = true, length = 20)
    private String rodzaj;
    @ManyToOne
    @JoinColumn(name = "idp", referencedColumnName = "idp", nullable = false, insertable = false, updatable = false)
    private PrzedmiotyEntity przedmiotyByIdp;
    @ManyToOne
    @JoinColumn(name = "idu", referencedColumnName = "idu", nullable = false, insertable = false, updatable = false)
    private UczniowieEntity uczniowieByIdu;

    public Long getIdf() {
        return idf;
    }

    public void setIdf(Long idf) {
        this.idf = idf;
    }

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getGodzina() {
        return godzina;
    }

    public void setGodzina(Integer godzina) {
        this.godzina = godzina;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Override
    public String toString() {
        return "FrekwencjaEntity{" +
                "idf=" + idf +
                ", idp=" + idp +
                ", idu=" + idu +
                ", data=" + data +
                ", godzina=" + godzina +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrekwencjaEntity that = (FrekwencjaEntity) o;
        return Objects.equals(idf, that.idf) && Objects.equals(idp, that.idp) && Objects.equals(idu, that.idu) && Objects.equals(data, that.data) && Objects.equals(godzina, that.godzina) && Objects.equals(rodzaj, that.rodzaj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idf, idp, idu, data, godzina, rodzaj);
    }

    public PrzedmiotyEntity getPrzedmiotyByIdp() {
        return przedmiotyByIdp;
    }

    public void setPrzedmiotyByIdp(PrzedmiotyEntity przedmiotyByIdp) {
        this.przedmiotyByIdp = przedmiotyByIdp;
    }

    public UczniowieEntity getUczniowieByIdu() {
        return uczniowieByIdu;
    }

    public void setUczniowieByIdu(UczniowieEntity uczniowieByIdu) {
        this.uczniowieByIdu = uczniowieByIdu;
    }
}
