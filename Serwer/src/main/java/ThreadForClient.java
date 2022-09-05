import Enitities.UzytkownicyEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class ThreadForClient extends Thread{

    private Socket socket;
    private String uLogin;
    private String uhaslo;
    private int check;
    public ThreadForClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client: " + socket.getInetAddress().getHostName() + " connected.");
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //bw.write("Connection accepted");
            //bw.newLine();
            //bw.flush();

            //zczytanie z jasona hasla i loginu wpisanego przez uzytkownika

            JSONObject klient;
            for(check = 0; check < 4; check++) {
                klient = new JSONObject(br.readLine());
                uLogin = klient.optString("login");
                uhaslo = klient.optString("haslo");
                //logowanieUzytkownika(bw);

            }

        } catch (IOException e){throw new RuntimeException(e);
        } catch (JSONException e) {throw new RuntimeException(e);}
    }

    private void logowanieUzytkownika(BufferedWriter bw){
        //Tutaj wchodzimy w operacje z baza danych
        Querries querries = new Querries();
        String bHaslo = querries.findHasloOfUzytkownikByLogin(uLogin);

        if (bHaslo.equals(uhaslo)) {
            autoryzacjaKlienta("accept", bw);
            // podstawoweDane(baza, bw, uLogin);//nie zaimplementowalem jeszcze tego w kliencie
            System.out.println("Uzytkownik o loginie:" + uLogin + " poprawnie sie zalogowal");
            check = 4;
        }else autoryzacjaKlienta("declined", bw);

    }

    private void podstawoweDane(BufferedWriter bw, String uLogin){
        try {
            Querries querries = new Querries();
            UzytkownicyEntity us = querries.findUzytkownikByLogin(uLogin);
            JSONObject pd = new JSONObject();
            pd.put("imie", us.getImie());
            pd.put("nazwisko", us.getNazwisko());
            pd.put("rola", us.getRola());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void autoryzacjaKlienta(String status, BufferedWriter bw) {
        try {
            JSONObject odp = new JSONObject();
            odp.put("status", status);
            bw.write(odp.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
