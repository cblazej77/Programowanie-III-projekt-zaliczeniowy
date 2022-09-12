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

    public void addLekcja(Integer godzina, Long klasa, Long idnp, Date data, String temat) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        LekcjeEntity lekcjeEntity = new LekcjeEntity();
        lekcjeEntity.setData(data);
        lekcjeEntity.setTemat(temat);
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

    public void addFrekwencja(Long idp, Long idu, String rodzaj, Long idl, Long idn) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        FrekwencjaEntity frekwencjaEntity = new FrekwencjaEntity();
        frekwencjaEntity.setIdl(idl);
        frekwencjaEntity.setIdn(idn);
        frekwencjaEntity.setIdp(idp);
        frekwencjaEntity.setIdu(idu);
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

    public List<FrekwencjaEntity> findFrekwencjaByLogin(String login, String nazwaKlasy) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT f FROM FrekwencjaEntity f JOIN f.uczniowieByIdu u JOIN u.klasyByIdk k JOIN u.uzytkownicyByIdus us WHERE us.login = :nr AND k.nazwa = :nazwa");
        query.setParameter("nr", login);
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

    public List<Float> findOcenyByPrzedmiotforUczen(String nazwa, String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT o.ocena FROM OcenyEntity o JOIN o.przedmiotyByIdp p JOIN o.uczniowieByIdu u JOIN u.uzytkownicyByIdus us WHERE p.nazwa = :naz AND us.login = :login");
        query.setParameter("naz", nazwa);
        query.setParameter("login", login);
        return query.getResultList();
    }

    public Double findAvgOfOcenyforUczenFromPrzedmiot(String nazwa, String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT AVG(o.ocena) FROM OcenyEntity o JOIN o.przedmiotyByIdp p JOIN o.uczniowieByIdu u JOIN u.uzytkownicyByIdus us WHERE p.nazwa = :naz AND us.login = :login");
        query.setParameter("naz", nazwa);
        query.setParameter("login", login);
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


    public UzytkownicyEntity findRodzicByLogin(String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT us FROM UzytkownicyEntity us JOIN us.uczniowiesByIdus_0 u JOIN u.uzytkownicyByIdus usu WHERE usu.login = :login");
        query.setParameter("login", login);
        return (UzytkownicyEntity) query.getResultList().get(0);
    }

    public UczniowieEntity findUczenByLogin(String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT u FROM UczniowieEntity u JOIN u.uzytkownicyByIdus us WHERE us.login = :login");
        query.setParameter("login", login);
        return (UczniowieEntity) query.getResultList().get(0);
    }

    public KlasyEntity findKlasaOfUczenByLogin(String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT k FROM UczniowieEntity u JOIN u.klasyByIdk k JOIN u.uzytkownicyByIdus us WHERE us.login = :login");
        query.setParameter("login", login);
        return (KlasyEntity) query.getResultList().get(0);
    }

    public List<Integer> findLekcjeGodzinaForPrzedmiotByUserLogin(String login, Date data) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT l.godzina FROM LekcjeEntity l JOIN l.klasyByKlasa k JOIN k.uczniowiesByIdk u JOIN u.uzytkownicyByIdus us WHERE us.login = :login AND l.data = :data ORDER BY l.godzina");
        query.setParameter("login", login);
        query.setParameter("data", data);
        return query.getResultList();
    }
    public List<String> findLekcjePrzedmiotForPrzedmiotByUserLogin(String login, Date data) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT np.przedmiotyByIdp.nazwa FROM LekcjeEntity l JOIN l.nauczycieleprzedmiotowByIdnp np JOIN l.klasyByKlasa k JOIN k.uczniowiesByIdk u JOIN u.uzytkownicyByIdus us WHERE us.login = :login AND l.data = :dzien ORDER BY l.godzina");
        query.setParameter("login", login);
        query.setParameter("dzien", data);
        return query.getResultList();
    }


    public void addOcenaForUczen(String nazwa, Float ocena, Integer nrWDzienniku, String klasa,String przedmiot) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("Select u.idu FROM UczniowieEntity u WHERE u.nrwdzienniku = :nrWDzienniku AND u.klasyByIdk.nazwa = :klasa");
        Query query1 = (Query) entityManager.createQuery("SELECT p.idp FROM PrzedmiotyEntity p WHERE p.nazwa = :nazwa");
        query.setParameter("nrWDzienniku", nrWDzienniku);
        query.setParameter("klasa", klasa);
        query1.setParameter("nazwa", przedmiot);
        Long idu = (Long) query.getResultList().get(0);
        Long idp = (Long) query1.getResultList().get(0);

        addOcena(nazwa, ocena, idu, idp);
        entityManager.close();
    }

    public void addNauczycielByLogin(String login) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("Select n.idn FROM NauczycieleEntity n JOIN n.uzytkownicyByIdus us WHERE us.login = :login");
        query.setParameter("login", login);
        Long idn = (Long) query.getResultList().get(0);
        addNauczyciel(idn);
        entityManager.close();
    }

    public void addUczenByLogins(Integer nrWDzienniku, String nazwaKlasy, String loginU, String loginP) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("Select k.idk FROM KlasyEntity k where k.nazwa = :nazwaKlasy");
        Query query1 = (Query) entityManager.createQuery("Select us.idus FROM UzytkownicyEntity us WHERE us.login = :loginU");
        Query query2 = (Query) entityManager.createQuery("Select us.idus FROM UzytkownicyEntity us WHERE us.login = :loginP");
        query.setParameter("nazwa", nazwaKlasy);
        query1.setParameter("loginU", loginU);
        query2.setParameter("loginP", loginP);
        Long idk = (Long) query.getResultList().get(0);
        Long idus = (Long) query1.getResultList().get(0);
        Long idup = (Long) query2.getResultList().get(0);
        addUczen(nrWDzienniku, idk, idus, idup);
        entityManager.close();
    }

    public void addLekcjaByLoginAndNames(Integer godzina, String nazwaKlasy, String loginN, String nazwaPrzedmiotu, Date data, String temat) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("Select k.idk FROM KlasyEntity k where k.nazwa = :nazwaKlasy");
        Query query1 = (Query) entityManager.createQuery("Select np.idnp FROM NauczycieleprzedmiotowEntity np join np.przedmiotyByIdp p join np.nauczycieleByIdn n WHERE p.nazwa = :nazwaP AND n.uzytkownicyByIdus.login = :loginN");
        query.setParameter("nazwa", nazwaKlasy);
        query1.setParameter("nazwaP", nazwaPrzedmiotu);
        query1.setParameter("loginN", loginN);
        Long idk = (Long) query.getResultList().get(0);
        Long idnp = (Long) query1.getResultList().get(0);
        addLekcja(godzina, idk, idnp, data, temat);
        entityManager.close();
    }

    public void addKlasaOnLoginN(String nazwaKlasy, Date dataRozpoczecia, String loginN) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query1 = (Query) entityManager.createQuery("Select n.idn FROM NauczycieleEntity n WHERE n.uzytkownicyByIdus.login = :loginN");
        query1.setParameter("loginN", loginN);
        Long idn = (Long) query1.getResultList().get(0);
        addKlasa(nazwaKlasy, dataRozpoczecia, idn);
        entityManager.close();
    }

    public void addFrekwencjaOnEverything(String nazwaP, String loginU, Date data, Integer godzina, String rodzaj, String klasa, String loginN) {

        EntityManager entityManager = FACTORY.createEntityManager();
        Query query1 = (Query) entityManager.createQuery("SELECT p.idp FROM PrzedmiotyEntity p WHERE p.nazwa = :nazwa");
        Query query = (Query) entityManager.createQuery("Select u.idu FROM UczniowieEntity u JOIN u.uzytkownicyByIdus us WHERE us.login = :loginU");
        Query query2 = (Query) entityManager.createQuery("SELECT l.idl FROM LekcjeEntity l WHERE l.godzina = :godzina AND l.data = :data AND l.klasyByKlasa.nazwa = :klasa");
        Query query3 = (Query) entityManager.createQuery("SELECT n.idn FROM NauczycieleEntity n WHERE n.uzytkownicyByIdus.login = :loginN");
        query1.setParameter("nazwa", nazwaP);
        query.setParameter("loginU", loginU);
        query2.setParameter("godzina", godzina);
        query2.setParameter("klasa", klasa);
        query2.setParameter("data", data);
        query3.setParameter("loginN", loginN);
        Long idu = (Long) query.getResultList().get(0);
        Long idp = (Long) query1.getResultList().get(0);
        Long idl = (Long) query2.getResultList().get(0);
        Long idn = (Long) query3.getResultList().get(0);
        addFrekwencja(idp, idu,rodzaj, idl, idn);
        entityManager.close();
    }

    public void changeKlasaForUczen(String login, String nowaKlasa) {
        EntityManager entityManager = FACTORY.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Query query = (Query) entityManager.createQuery("SELECT u.idu FROM UczniowieEntity u JOIN u.uzytkownicyByIdus us WHERE us.login = :login");
        Query query1 = (Query) entityManager.createQuery("select k.idk FROM KlasyEntity k where k.nazwa = :nowaNazwa");
        query.setParameter("login", login);
        query1.setParameter("nowaNazwa", nowaKlasa);
        Long idk = (Long) query1.getResultList().get(0);
        Long idu = (Long) query.getResultList().get(0);
        UczniowieEntity uczniowieEntity = entityManager.find(UczniowieEntity.class, idu);
        transaction.begin();
        uczniowieEntity.setIdk(idk);
        transaction.commit();
        entityManager.close();
    }

    public void removeUzytkownikByLogin(String login) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        UzytkownicyEntity uzytkownicyEntity = findUzytkownikByLogin(login);
        transaction.begin();
        uzytkownicyEntity = entitymanager.merge(uzytkownicyEntity);
        entitymanager.remove(uzytkownicyEntity);
        transaction.commit();
        entitymanager.close();
    }

    public void removeUczenByLogin(String login) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        UczniowieEntity uczniowieEntity = findUczenByLogin(login);
        transaction.begin();
        entitymanager.remove(uczniowieEntity);
        transaction.commit();
        entitymanager.close();
    }

    public NauczycieleEntity findNauczycielByLogin(String login) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        Query query = (Query) entitymanager.createQuery("SELECT n FROM NauczycieleEntity n JOIN n.uzytkownicyByIdus us WHERE us.login = :loginN");
        query.setParameter("loginN", login);
        return (NauczycieleEntity) query.getResultList().get(0);
    }

    public void removeNauczycielByLogin(String login) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        NauczycieleEntity nauczycieleEntity = findNauczycielByLogin(login);
        transaction.begin();
        //entitymanager.merge jest potrzebne do usuwania elementow
        nauczycieleEntity = entitymanager.merge(nauczycieleEntity);
        entitymanager.remove(nauczycieleEntity);
        transaction.commit();
        entitymanager.close();
    }

    public void removePrzedmiotByNazwa(String nazwa) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        PrzedmiotyEntity przedmiotyEntity = findPrzedmiotByNazwa(nazwa);
        transaction.begin();
        entitymanager.remove(przedmiotyEntity);
        transaction.commit();
        entitymanager.close();
    }

    public PrzedmiotyEntity findPrzedmiotByNazwa(String nazwa) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        Query query = (Query) entitymanager.createQuery("SELECT p FROM PrzedmiotyEntity p WHERE p.nazwa = :nazwa");
        query.setParameter("nazwa", nazwa);
        return (PrzedmiotyEntity) query.getResultList().get(0);
    }

    public KlasyEntity findKlasaByNazwa(String nazwa) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        Query query = (Query) entitymanager.createQuery("SELECT k FROM KlasyEntity k WHERE k.nazwa = :nazwa");
        query.setParameter("nazwa", nazwa);
        return (KlasyEntity) query.getResultList().get(0);
    }

    public void removeKlasaByNazwa(String nazwa) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        KlasyEntity klasyEntity = findKlasaByNazwa(nazwa);
        transaction.begin();
        entitymanager.remove(klasyEntity);
        transaction.commit();
        entitymanager.close();
    }

    public FrekwencjaEntity findFrekwencjaByEverything(String nazwaPrzedmiotu, String loginU, Date data, Integer godzina, String klasa) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        Query query0 = (Query) entitymanager.createQuery("SELECT l.idl FROM LekcjeEntity l WHERE l.klasyByKlasa.nazwa = :nazwaK " +
                "AND l.data = :data AND l.godzina = :godzina");
        Query query = (Query) entitymanager.createQuery("SELECT f FROM FrekwencjaEntity f JOIN f.przedmiotyByIdp p " +
                "JOIN f.uczniowieByIdu u WHERE p.nazwa = :nazwa AND u.uzytkownicyByIdus.login = :login " +
                "AND f.idl = :idl");
        query0.setParameter("nazwaK", klasa);
        query0.setParameter("data", data);
        query0.setParameter("godzina", godzina);
        Long idl = (Long) query0.getResultList().get(0);
        query.setParameter("login", loginU);
        query.setParameter("nazwa", nazwaPrzedmiotu);
        query.setParameter("idl", idl);
        return (FrekwencjaEntity) query.getResultList().get(0);
    }

    public void removeFrekwencja(String nazwaPrzedmiotu, String loginU, Date data, Integer godzina, String klasa) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        FrekwencjaEntity frekwencjaEntity = findFrekwencjaByEverything(nazwaPrzedmiotu,loginU, data, godzina, klasa);
        transaction.begin();
        entitymanager.remove(frekwencjaEntity);
        transaction.commit();
        entitymanager.close();
    }

    public LekcjeEntity findLekcjaByEverything(Integer godzina, String klasa, String login, String nazwaP, Date data, String temat) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        Query query = (Query) entitymanager.createQuery("SELECT l FROM LekcjeEntity l JOIN l.klasyByKlasa k " +
                "JOIN l.nauczycieleprzedmiotowByIdnp np WHERE l.data = :data AND l.godzina = :god " +
                "AND k.nazwa = :nazwaK AND np.nauczycieleByIdn.uzytkownicyByIdus.login = :loginN " +
                "AND np.przedmiotyByIdp.nazwa = :nazwaP AND l.temat = :temat");

        query.setParameter("god", godzina);
        query.setParameter("data", data);
        query.setParameter("loginN", login);
        query.setParameter("temat", temat);
        query.setParameter("nazwaP", nazwaP);
        query.setParameter("nazwaK", klasa);
        return (LekcjeEntity) query.getResultList().get(0);
    }

    public void removeLekcja(Integer godzina, String klasa, String login, String nazwaP, Date data, String temat) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        LekcjeEntity lekcjeEntity = findLekcjaByEverything(godzina, klasa, login, nazwaP, data, temat);
        transaction.begin();
        entitymanager.remove(lekcjeEntity);
        transaction.commit();
        entitymanager.close();
    }

    public OcenyEntity findOcenaByEverything(String nazwao, Float ocena, String login, String nazwap) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        Query query = (Query) entitymanager.createQuery("SELECT o FROM OcenyEntity o join" +
                " o.przedmiotyByIdp p JOIN o.uczniowieByIdu u WHERE o.nazwa = :nazwao AND" +
                " o.ocena = :ocena AND p.nazwa = :nazwap AND u.uzytkownicyByIdus.login = :loginu");
        query.setParameter("loginu", login);
        query.setParameter("nazwap", nazwap);
        query.setParameter("ocena", ocena);
        query.setParameter("nazwao", nazwao);
        return (OcenyEntity) query.getResultList().get(0);
    }

    public void removeOcena(String nazwao, Float ocena, String login, String nazwap) {
        EntityManager entitymanager = FACTORY.createEntityManager();
        EntityTransaction transaction = entitymanager.getTransaction();
        OcenyEntity ocenyEntity = findOcenaByEverything(nazwao, ocena, login, nazwap);
        transaction.begin();
        entitymanager.remove(ocenyEntity);
        transaction.commit();
        entitymanager.close();
    }


    public List<Float> findOcenyByPrzedmiotforUczenbyLogin(String subject, String uLogin) {
        EntityManager entityManager = FACTORY.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT o.ocena FROM OcenyEntity o JOIN o.przedmiotyByIdp p JOIN o.uczniowieByIdu u JOIN u.uzytkownicyByIdus us WHERE p.nazwa = :naz AND us.login = :login");
        query.setParameter("naz", subject);
        query.setParameter("login", uLogin);
        return query.getResultList();
    }
}
