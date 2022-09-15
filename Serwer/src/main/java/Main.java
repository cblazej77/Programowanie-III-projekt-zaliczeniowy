import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("MyUnit");

    public static void main(String[] args) {

        Querries querries = new Querries();

        /* dodanie lekcji 1 rok */ /*
        LocalDate date = LocalDate.parse("2022-09-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        for(int i = 0; i < 1; i++) {
        querries.addLekcjaByLoginAndNames(1,"2A2021", "KD017", "JezykPolski", Date.valueOf(date), "");
        querries.addLekcjaByLoginAndNames(2,"2A2021", "KD018", "Informatyka", Date.valueOf(date), "");
        querries.addLekcjaByLoginAndNames(3,"2A2021", "KD016", "Matematyka", Date.valueOf(date), "");
        querries.addLekcjaByLoginAndNames(1,"1B2022", "KD018", "Informatyka", Date.valueOf(date), "");
        querries.addLekcjaByLoginAndNames(2,"1B2022", "KD016", "JezykAngielski", Date.valueOf(date), "");
        querries.addLekcjaByLoginAndNames(3,"1B2022", "KD017", "JezykPolski", Date.valueOf(date), "");
        querries.addLekcjaByLoginAndNames(1,"2A2021", "KD016", "JezykAngielski", Date.valueOf(date.plusDays(1)), "");
        querries.addLekcjaByLoginAndNames(2,"2A2021", "KD017", "JezykPolski", Date.valueOf(date.plusDays(1)), "");
        querries.addLekcjaByLoginAndNames(3,"2A2021", "KD016", "Matematyka", Date.valueOf(date.plusDays(1)), "");
        querries.addLekcjaByLoginAndNames(1,"1B2022", "KD017", "JezykPolski", Date.valueOf(date.plusDays(1)), "");
        querries.addLekcjaByLoginAndNames(2,"1B2022", "KD016", "Matematyka", Date.valueOf(date.plusDays(1)), "");
        querries.addLekcjaByLoginAndNames(3,"1B2022", "KD016", "JezykAngielski", Date.valueOf(date.plusDays(1)), "");
        querries.addLekcjaByLoginAndNames(1,"2A2021", "KD016", "Matematyka", Date.valueOf(date.plusDays(2)), "");
        querries.addLekcjaByLoginAndNames(2,"2A2021", "KD018", "Informatyka", Date.valueOf(date.plusDays(2)), "");
        querries.addLekcjaByLoginAndNames(3,"2A2021", "KD017", "JezykPolski" , Date.valueOf(date.plusDays(2)), "");
        querries.addLekcjaByLoginAndNames(1,"1B2022", "KD017", "JezykPolski", Date.valueOf(date.plusDays(2)), "");
        querries.addLekcjaByLoginAndNames(2,"1B2022", "KD016", "JezykAngielski", Date.valueOf(date.plusDays(2)), "");
        querries.addLekcjaByLoginAndNames(3,"1B2022", "KD016", "Matematyka", Date.valueOf(date.plusDays(2)), "");
        querries.addLekcjaByLoginAndNames(1,"2A2021", "KD016", "JezykAngielski", Date.valueOf(date.plusDays(3)), "");
        querries.addLekcjaByLoginAndNames(2,"2A2021", "KD017", "JezykPolski", Date.valueOf(date.plusDays(3)), "");
        querries.addLekcjaByLoginAndNames(3,"2A2021", "KD016", "Matematyka", Date.valueOf(date.plusDays(3)), "");
        querries.addLekcjaByLoginAndNames(1,"1B2022", "KD017", "JezykPolski", Date.valueOf(date.plusDays(3)), "");
        querries.addLekcjaByLoginAndNames(2,"1B2022", "KD016", "Matematyka", Date.valueOf(date.plusDays(3)), "");
        querries.addLekcjaByLoginAndNames(3,"1B2022", "KD016", "JezykAngielski", Date.valueOf(date.plusDays(3)), "");
        querries.addLekcjaByLoginAndNames(1,"2A2021", "KD017", "JezykPolski", Date.valueOf(date.plusDays(4)), "");
        querries.addLekcjaByLoginAndNames(2,"2A2021", "KD018", "Informatyka", Date.valueOf(date.plusDays(4)), "");
        querries.addLekcjaByLoginAndNames(3,"2A2021", "KD016", "Matematyka", Date.valueOf(date.plusDays(4)), "");
        querries.addLekcjaByLoginAndNames(1,"1B2022", "KD018", "Informatyka", Date.valueOf(date.plusDays(4)), "");
        querries.addLekcjaByLoginAndNames(2,"1B2022", "KD016", "JezykAngielski", Date.valueOf(date.plusDays(4)), "");
        querries.addLekcjaByLoginAndNames(3,"1B2022", "KD017", "JezykPolski", Date.valueOf(date.plusDays(4)), "");
        date = date.plusDays(7);
        } */
        /*for(String e: querries.findLekcjePrzedmiotForPrzedmiotByUserLogin("KD001", Date.valueOf("2022-09-12"))) {
        System.out.println(e);
        } */


        //System.out.println(querries.czyNauczycielUczyKlase("KD016", "1B2022"));
        //System.out.println(querries.czyNauczycielUczyKlasePrzedmiotu("KD016", "Matematyka","1B2022"));

        for(String s: querries.findImionaUczniowZKlasy("1B2022")) {
            System.out.println(s);
        }

        System.out.println(querries.findKlaseWychowawcy("KD016"));

        System.out.println("Czekam...");
        try{
            ServerSocket server = new ServerSocket(8081);
            while(true) {
                Socket socket = server.accept();
                ThreadForClient thc = new ThreadForClient(socket);
                thc.start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
