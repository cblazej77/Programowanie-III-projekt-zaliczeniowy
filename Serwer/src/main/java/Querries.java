import Enitities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;


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

    public void addLekcja(Integer semestr, String dzien, Integer godzina, Long klasa, Long przedmiot, Long nauczyciel) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        LekcjeEntity lekcjeEntity = new LekcjeEntity();
        lekcjeEntity.setSemestr(semestr);
        lekcjeEntity.setDzien(dzien);
        lekcjeEntity.setGodzina(godzina);
        lekcjeEntity.setKlasa(klasa);
        lekcjeEntity.setPrzedmiot(przedmiot);
        lekcjeEntity.setNauczyciel(nauczyciel);
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

}
