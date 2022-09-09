import Enitities.KlasyEntity;
import Enitities.OcenyEntity;
import Enitities.UczniowieEntity;
import Enitities.UzytkownicyEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

public class ThreadForClient extends Thread{

    private Socket socket;
    private String uLogin;
    private String uhaslo;
    private boolean check;
    private boolean wait;
    private String access;

    private int chooseCase;
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
            check = true;
            wait = true;
            while(check){//for(check = 0; check < 4; check++) {//ta petla chyba jest nie potrzebna i psuje program
                klient = new JSONObject(br.readLine());
                uLogin = klient.optString("login"); if (uLogin == klient.optString("login")){ System.out.println("Login taken from JSON"); }
                uhaslo = klient.optString("haslo"); if(uhaslo == klient.optString("haslo")) {System.out.println("Haslo taken from JASON"); }
                logowanieUzytkownika(bw);
                /*if(!check){
                    //podstawoweDane(bw, uLogin);
                    while(wait){
                        reciveCase(br);
                        if(chooseCase == 3) uczenDane(bw, uLogin);
                        if(chooseCase == 2) planlekcjiDane(bw);
                        //if(user sie wyloguje/zamknie) wait = false;
                    }
                }*/
                if(access.equals("UCZEN")) {
                    if (!check) {
                        while (wait) {
                            reciveCase(br);
                            //if (chooseCase == 0) sendMark(bw);
                            if(chooseCase == 3) uczenDane(bw, uLogin);
                            if(chooseCase == 2) planlekcjiDane(bw);
                            if(chooseCase == 4) nauczycielDane(bw,uLogin);
                        }
                    }
                }else{
                    if (!check) {
                        while (wait) {
                            reciveCase(br);

                        }
                    }
                }

            }

        } catch (IOException e){throw new RuntimeException(e);
        } catch (JSONException e) {throw new RuntimeException(e);}
    }

    private void reciveCase(BufferedReader br) {
        JSONObject rc = null;
        try{
            rc = new JSONObject(br.readLine());
            chooseCase = rc.optInt("cases");
        }catch (IOException | JSONException e){
            wait = false;
            e.printStackTrace();}
    }

    private void logowanieUzytkownika(BufferedWriter bw){
        //Tutaj wchodzimy w operacje z baza danych
        Querries querries = new Querries();

        String bHaslo;
        try {
            bHaslo = querries.findHasloOfUzytkownikByLogin(uLogin);
        }catch(IndexOutOfBoundsException  e){
            System.out.println(e);
            bHaslo = "";
        }
        if (bHaslo.equals(uhaslo) && bHaslo != "") {
            autoryzacjaKlienta("accept", bw);
            podstawoweDane(bw, uLogin);
            podstawoweDane(bw, uLogin);
            System.out.println("Uzytkownik o loginie:" + uLogin + " poprawnie sie zalogowal");
            check = false;
        }else autoryzacjaKlienta("declined", bw);

    }

    private void podstawoweDane(BufferedWriter bw, String uLogin){
        try {
            Querries querries = new Querries();
            UzytkownicyEntity us = querries.findUzytkownikByLogin(uLogin);
            access = us.getRola();
            JSONObject pd = new JSONObject();
            pd.put("imie", us.getImie());
            //pd.put("nazwisko", us.getNazwisko());
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

    private void uczenDane(BufferedWriter bw, String uLogin){
        try {
            Querries querries = new Querries();
            UzytkownicyEntity us = querries.findUzytkownikByLogin(uLogin);
            UzytkownicyEntity ro = querries.findRodzicByLogin(uLogin);
            UczniowieEntity ucz = querries.findUczenByLogin(uLogin);
            KlasyEntity kl = querries.findKlasaOfUczenByLogin(uLogin);
            JSONObject pd = new JSONObject();
            pd.put("imie", us.getImie());
            pd.put("nazwisko", us.getNazwisko());
            pd.put("imie1", ro.getImie());
            pd.put("nazwisko1", ro.getNazwisko());
            pd.put("numer", ucz.getNrwdzienniku());
            pd.put("klasa", kl.getNazwa());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void nauczycielDane(BufferedWriter bw, String uLogin){
        try {
            Querries querries = new Querries();
            UzytkownicyEntity us = querries.findUzytkownikByLogin(uLogin);
            JSONObject pd = new JSONObject();
            pd.put("imie", us.getImie());
            pd.put("nazwisko", us.getNazwisko());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void planlekcjiDane(BufferedWriter bw){
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<OcenyEntity> oc = querries.findOcenyByPrzedmiot(uLogin);
            pd.put("size",oc.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for(int i=0;i<oc.size();i++){
                pd.put("id",oc.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
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
