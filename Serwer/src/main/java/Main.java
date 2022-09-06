import Enitities.FrekwencjaEntity;
import Enitities.OcenyEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class Main {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("MyUnit");

    public static void main(String[] args) {

        Querries querries = new Querries();

        for(FrekwencjaEntity f: querries.findFrekwencjaByNrWDzienniku(7, "A2021")) {
            System.out.println(f);
        }

        System.out.println();

        for(FrekwencjaEntity f: querries.findFrekwencjaByImieINazwisko("Karolina", "Sumosia")) {
            System.out.println(f);
        }

        System.out.println();

        System.out.println(querries.findAvgOfOcenyforUczenFromPrzedmiot("matematyka",0L));


    }
}
