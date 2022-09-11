package Enitities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "uczniowie", schema = "public", catalog = "ikyxpswp")
public class UczniowieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idu", nullable = false)
    private Long idu;
    @Basic
    @Column(name = "nrwdzienniku", nullable = true)
    private Integer nrwdzienniku;
    @Basic
    @Column(name = "idk", nullable = false)
    private Long idk;
    @Basic
    @Column(name = "idus", nullable = false)
    private Long idus;
    @Basic
    @Column(name = "idurodzica", nullable = false)
    private Long idurodzica;
    @OneToMany(mappedBy = "uczniowieByIdu")
    private Collection<FrekwencjaEntity> frekwencjasByIdu;
    @OneToMany(mappedBy = "uczniowieByIdu")
    private Collection<OcenyEntity> oceniesByIdu;
    @ManyToOne
    @JoinColumn(name = "idk", referencedColumnName = "idk", nullable = false, insertable = false, updatable = false)
    private KlasyEntity klasyByIdk;
    @ManyToOne
    @JoinColumn(name = "idus", referencedColumnName = "idus", nullable = false, insertable = false, updatable = false)
    private UzytkownicyEntity uzytkownicyByIdus;
    @ManyToOne
    @JoinColumn(name = "idurodzica", referencedColumnName = "idus", nullable = false, insertable = false, updatable = false)
    private UzytkownicyEntity uzytkownicyByIdurodzica;

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public Integer getNrwdzienniku() {
        return nrwdzienniku;
    }

    public void setNrwdzienniku(Integer nrwdzienniku) {
        this.nrwdzienniku = nrwdzienniku;
    }

    public Long getIdk() {
        return idk;
    }

    public void setIdk(Long idk) {
        this.idk = idk;
    }

    public Long getIdus() {
        return idus;
    }

    public void setIdus(Long idus) {
        this.idus = idus;
    }

    public Long getIdurodzica() {
        return idurodzica;
    }

    public void setIdurodzica(Long idurodzica) {
        this.idurodzica = idurodzica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UczniowieEntity that = (UczniowieEntity) o;
        return Objects.equals(idu, that.idu) && Objects.equals(nrwdzienniku, that.nrwdzienniku) && Objects.equals(idk, that.idk) && Objects.equals(idus, that.idus) && Objects.equals(idurodzica, that.idurodzica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idu, nrwdzienniku, idk, idus, idurodzica);
    }

    public Collection<FrekwencjaEntity> getFrekwencjasByIdu() {
        return frekwencjasByIdu;
    }

    public void setFrekwencjasByIdu(Collection<FrekwencjaEntity> frekwencjasByIdu) {
        this.frekwencjasByIdu = frekwencjasByIdu;
    }

    public Collection<OcenyEntity> getOceniesByIdu() {
        return oceniesByIdu;
    }

    public void setOceniesByIdu(Collection<OcenyEntity> oceniesByIdu) {
        this.oceniesByIdu = oceniesByIdu;
    }

    public KlasyEntity getKlasyByIdk() {
        return klasyByIdk;
    }

    public void setKlasyByIdk(KlasyEntity klasyByIdk) {
        this.klasyByIdk = klasyByIdk;
    }

    public UzytkownicyEntity getUzytkownicyByIdus() {
        return uzytkownicyByIdus;
    }

    public void setUzytkownicyByIdus(UzytkownicyEntity uzytkownicyByIdus) {
        this.uzytkownicyByIdus = uzytkownicyByIdus;
    }

    public UzytkownicyEntity getUzytkownicyByIdurodzica() {
        return uzytkownicyByIdurodzica;
    }

    public void setUzytkownicyByIdurodzica(UzytkownicyEntity uzytkownicyByIdurodzica) {
        this.uzytkownicyByIdurodzica = uzytkownicyByIdurodzica;
    }

    @Override
    public String toString() {
        return "UczniowieEntity{" +
                "idu=" + idu +
                ", nrwdzienniku=" + nrwdzienniku +
                ", idk=" + idk +
                ", idus=" + idus +
                ", idurodzica=" + idurodzica +
                '}';
    }
}
