import Enitities.FrekwencjaEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("MyUnit");

    public static void main(String[] args) {

        //Querries querries = new Querries();

        //for(FrekwencjaEntity f: querries.findFrekwencjaByNrWDzienniku(7, "A2021")) {System.out.println(f);}
        //for(FrekwencjaEntity f: querries.findFrekwencjaByImieINazwisko("Karolina", "Sumosia")) { System.out.println(f);}
        //System.out.println(querries.findAvgOfOcenyforUczenFromPrzedmiot("matematyka",0L));
        System.out.println("Start serwer!");
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
