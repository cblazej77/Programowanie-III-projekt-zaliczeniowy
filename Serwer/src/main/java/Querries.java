import Enitities.UzytkownicyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


// Klasa w której napisane są metody do obsługi bazy
public class Querries {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("MyUnit");


    public void AddUzytkownik(String login, String haslo, String imie, String nazwisko, String rola) {
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

}
