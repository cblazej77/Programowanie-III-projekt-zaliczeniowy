import org.json.JSONException;
import org.json.JSONObject;

import javax.print.attribute.standard.JobName;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static boolean accept = true;

    public static void main(String[] args){
        try {
            //laczenie z serwerem
            Socket socket = new Socket(InetAddress.getByName("localhost"), 8081);
            //Czy serwer sie polaczyl
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String AnswerS = br.readLine();
            System.out.println(AnswerS);

            JSONObject json;
            for(int i = 0; i < 4; i++){
                //wyslanie loginu i hasla
                //Scanner scan = new Scanner(System.in);
                //String login = scan.nextLine();//"KD001";
                //String haslo = scan.nextLine();//"haslo";

                String login = "KD006";
                String haslo = "1234";

                json = new JSONObject();
                json.put("login", login);
                json.put("haslo", haslo);//hashowac haslo jeszcze trzeba

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write(json.toString());
                bw.newLine();
                bw.flush();

                //odczytanie czy uzytkownik jest zalogowany poprawnie
                JSONObject serwer = new JSONObject(br.readLine());
                if (serwer.optString("status").equals("accept")) {
                    wyswietlDane(br);
                    i = 4;
                }else if(i == 3){
                    socket.close();
                    System.exit(0);
                }else System.out.println("Zle dane, zostalo prob: " + (3-i));
            }
        }
        catch(IOException | JSONException e){
            e.printStackTrace();
        }
    }
    private static void wyswietlDane(BufferedReader br) throws JSONException, IOException {
        JSONObject dane = new JSONObject(br.readLine());
        String imie = dane.getString("imie");
        String nazwisko = dane.getString("nazwisko");
        String rola = dane.getString("rola");
        System.out.println("Dzien dobry: " + imie + " " + nazwisko);
        System.out.println("Zalogowano na konto " + rola);
    }
}
