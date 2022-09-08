import Enitities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;


// Klasa w której napisane są metody do obsługi bazy
public class Querries {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("MyUnit");


    public void addUzytkownik(String login, String haslo, String imie, String nazwisko, String rola) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UzytkownicyEntity uz = new UzytkownicyEntity();
        uz.setLogin(login);
        uz.setHaslo(haslo);
        uz.setImie(imie);
        uz.setNazwisko(nazwisko);
        uz.setRola(rola);
        entityManager.persist(uz);
        transaction.commit();
    }

    public void addUczen(Integer nrwdzienniku, Long idk, Long idus, Long idurodzica) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UczniowieEntity uczniowieEntity = new UczniowieEntity();
        uczniowieEntity.setNrwdzienniku(nrwdzienniku);
        uczniowieEntity.setIdk(idk);
        uczniowieEntity.setIdus(idus);
        uczniowieEntity.setIdurodzica(idurodzica);
        entityManager.persist(uczniowieEntity);
        transaction.commit();
    }

    public void addPrzedmiot(String nazwa) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        PrzedmiotyEntity przedmiotyEntity = new PrzedmiotyEntity(nazwa);
        entityManager.persist(przedmiotyEntity);
        transaction.commit();
    }

    public void addOcena(String nazwa, Float ocena, Long idu, Long idp) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        OcenyEntity ocenyEntity = new OcenyEntity();
        ocenyEntity.setOcena(ocena);
        ocenyEntity.setNazwa(nazwa);
        ocenyEntity.setIdu(idu);
        ocenyEntity.setIdp(idp);
        entityManager.persist(ocenyEntity);
        transaction.commit();
    }

    public void addNauczyciel(Long idus) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        NauczycieleEntity nauczycieleEntity = new NauczycieleEntity();
        nauczycieleEntity.setIdus(idus);
        entityManager.persist(nauczycieleEntity);
        transaction.commit();
    }

    public void addLekcja(Integer semestr, String dzien, Integer godzina, Long klasa, Long idnp) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        LekcjeEntity lekcjeEntity = new LekcjeEntity();
        lekcjeEntity.setSemestr(semestr);
        lekcjeEntity.setDzien(dzien);
        lekcjeEntity.setGodzina(godzina);
        lekcjeEntity.setKlasa(klasa);
        lekcjeEntity.setIdnp(idnp);
        entityManager.persist(lekcjeEntity);
        transaction.commit();
    }

    public void addKlasa(String nazwa, Date datarozpoczecia, Long wychowawca) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        KlasyEntity klasyEntity = new KlasyEntity();
        klasyEntity.setNazwa(nazwa);
        klasyEntity.setDatarozpoczecia(datarozpoczecia);
        klasyEntity.setWychowawca(wychowawca);
        entityManager.persist(klasyEntity);
        transaction.commit();
    }

    public void addFrekwencja(Long idp, Long idu, Date data, Integer godzina, String rodzaj) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        FrekwencjaEntity frekwencjaEntity = new FrekwencjaEntity();
        frekwencjaEntity.setIdp(idp);
        frekwencjaEntity.setIdu(idu);
        frekwencjaEntity.setData(data);
        frekwencjaEntity.setGodzina(godzina);
        frekwencjaEntity.setRodzaj(rodzaj);
        entityManager.persist(frekwencjaEntity);
        transaction.commit();
    }

    public List<FrekwencjaEntity> findFrekwencjaByNameOfSubject(String nameOfSubcject) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT f FROM FrekwencjaEntity f JOIN f.przedmiotyByIdp p WHERE p.nazwa = :name");
        query.setParameter("name", nameOfSubcject);
        return query.getResultList();
    }

    public List<FrekwencjaEntity> findFrekwencjaByNrWDzienniku(Integer nrWDzienniku, String nazwaKlasy) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT f FROM FrekwencjaEntity f JOIN f.uczniowieByIdu u JOIN u.klasyByIdk k WHERE u.nrwdzienniku = :nr AND k.nazwa = :nazwa");
        query.setParameter("nr", nrWDzienniku);
        query.setParameter("nazwa", nazwaKlasy);
        return query.getResultList();
    }

    public List<FrekwencjaEntity> findFrekwencjaByImieINazwisko(String Imie, String Nazwisko) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT f FROM FrekwencjaEntity f JOIN f.uczniowieByIdu u JOIN u.uzytkownicyByIdus us WHERE us.imie = :imie AND us.nazwisko = :nazwisko");
        query.setParameter("imie", Imie);
        query.setParameter("nazwisko", Nazwisko);
        return query.getResultList();
    }

    public List<UczniowieEntity> findUczniowieByImie(String imie) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT u FROM UczniowieEntity u JOIN u.uzytkownicyByIdus us WHERE us.imie = :imie");
        query.setParameter("imie", imie);
        return query.getResultList();
    }

    public List<UczniowieEntity> findUczniowieByNazwisko(String nazwisko) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT u FROM UczniowieEntity u JOIN u.uzytkownicyByIdus us WHERE us.nazwisko = :naz");
        query.setParameter("naz", nazwisko);
        return query.getResultList();
    }

    public List<UczniowieEntity> findUczniowieByKlasa(String nazwa) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT u FROM UczniowieEntity u JOIN u.klasyByIdk k WHERE k.nazwa = :naz");
        query.setParameter("naz", nazwa);
        return query.getResultList();
    }

    public List<OcenyEntity> findOcenyByOcena(Float ocena) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT o FROM OcenyEntity o WHERE o.ocena = :oc");
        query.setParameter("oc", ocena);
        return query.getResultList();
    }

    public List<OcenyEntity> findOcenyByUczen(String imie, String nazwisko) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT o FROM OcenyEntity o JOIN o.uczniowieByIdu u JOIN u.uzytkownicyByIdus us WHERE us.imie = :im AND us.nazwisko = :naz");
        query.setParameter("im", imie);
        query.setParameter("naz", nazwisko);
        return query.getResultList();
    }

    public List<OcenyEntity> findOcenyByPrzedmiot(String nazwa) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT o FROM OcenyEntity o JOIN o.przedmiotyByIdp p WHERE p.nazwa = :naz");
        query.setParameter("naz", nazwa);
        return query.getResultList();
    }

    public List<OcenyEntity> findOcenyByPrzedmiotforUczen(String nazwa, Long idu) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT o FROM OcenyEntity o JOIN o.przedmiotyByIdp p WHERE p.nazwa = :naz AND o.idu = :id");
        query.setParameter("naz", nazwa);
        query.setParameter("id", idu);
        return query.getResultList();
    }

    public Double findAvgOfOcenyforUczenFromPrzedmiot(String nazwa, Long idu) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT AVG(o.ocena) FROM OcenyEntity o JOIN o.przedmiotyByIdp p WHERE p.nazwa = :naz AND o.idu = :id");
        query.setParameter("naz", nazwa);
        query.setParameter("id", idu);
        return (Double) query.getResultList().get(0);
    }

    public String findHasloOfUzytkownikByLogin(String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT u.haslo FROM UzytkownicyEntity u WHERE u.login = :login");
        query.setParameter("login", login);
        return (String) query.getResultList().get(0);
    }

    public UzytkownicyEntity findUzytkownikByLogin(String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT us FROM UzytkownicyEntity us WHERE us.login = :login");
        query.setParameter("login", login);
        return (UzytkownicyEntity) query.getResultList().get(0);
    }





}
