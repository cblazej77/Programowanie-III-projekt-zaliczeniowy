import Enitities.PrzedmiotyEntity;
import Enitities.UzytkownicyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("MyUnit");

    public static void main(String[] args) {

        Querries querries = new Querries();

        querries.AddUzytkownik("KD020","haslo","Kamil","Wujcik","NAUCZYCIEL");

    }
}
