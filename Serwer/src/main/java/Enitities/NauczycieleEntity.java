package Enitities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "nauczyciele", schema = "public", catalog = "ikyxpswp")
public class NauczycieleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idn", nullable = false)
    private Long idn;
    @Basic
    @Column(name = "idus", nullable = false)
    private Long idus;
    @OneToMany(mappedBy = "nauczycieleByWychowawca")
    private Collection<KlasyEntity> klasiesByIdn;
    @ManyToOne
    @JoinColumn(name = "idus", referencedColumnName = "idus", nullable = false, insertable = false, updatable = false)
    private UzytkownicyEntity uzytkownicyByIdus;
    @OneToMany(mappedBy = "nauczycieleByIdn")
    private Collection<NauczycieleprzedmiotowEntity> nauczycieleprzedmiotowsByIdn;

    @Override
    public String toString() {
        return "NauczycieleEntity{" +
                "idn=" + idn +
                ", idus=" + idus +
                '}';
    }

    public Long getIdn() {
        return idn;
    }

    public void setIdn(Long idn) {
        this.idn = idn;
    }

    public Long getIdus() {
        return idus;
    }

    public void setIdus(Long idus) {
        this.idus = idus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NauczycieleEntity that = (NauczycieleEntity) o;
        return Objects.equals(idn, that.idn) && Objects.equals(idus, that.idus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idn, idus);
    }

    public Collection<KlasyEntity> getKlasiesByIdn() {
        return klasiesByIdn;
    }

    public void setKlasiesByIdn(Collection<KlasyEntity> klasiesByIdn) {
        this.klasiesByIdn = klasiesByIdn;
    }

    public UzytkownicyEntity getUzytkownicyByIdus() {
        return uzytkownicyByIdus;
    }

    public void setUzytkownicyByIdus(UzytkownicyEntity uzytkownicyByIdus) {
        this.uzytkownicyByIdus = uzytkownicyByIdus;
    }

    public Collection<NauczycieleprzedmiotowEntity> getNauczycieleprzedmiotowsByIdn() {
        return nauczycieleprzedmiotowsByIdn;
    }

    public void setNauczycieleprzedmiotowsByIdn(Collection<NauczycieleprzedmiotowEntity> nauczycieleprzedmiotowsByIdn) {
        this.nauczycieleprzedmiotowsByIdn = nauczycieleprzedmiotowsByIdn;
    }
}
