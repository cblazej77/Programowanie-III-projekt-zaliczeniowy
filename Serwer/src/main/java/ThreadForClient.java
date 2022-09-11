import Enitities.KlasyEntity;
import Enitities.OcenyEntity;
import Enitities.UczniowieEntity;
import Enitities.UzytkownicyEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ThreadForClient extends Thread {

    private Socket socket;
    private String uLogin;
    private String uhaslo;
    private String access;
    private boolean check;
    private boolean waitt;

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

            //zczytanie z jasona hasla i loginu wpisanego przez uzytkownika

            JSONObject klient;
            access = "none";
            check = true;
            waitt = true;
            while (check) {
                klient = new JSONObject(br.readLine());
                uLogin = klient.optString("login");
                if (uLogin == klient.optString("login")) {
                    System.out.println("Login taken from JSON");
                }
                uhaslo = klient.optString("haslo");
                if (uhaslo == klient.optString("haslo")) {
                    System.out.println("Haslo taken from JASON");
                }
                logowanieUzytkownika(bw);
                if (access.equals("UCZEN")) {
                    if (!check) {
                        while (waitt) {
                            reciveCase(br);
                            if (chooseCase == 0) {
                                sendMark(bw, "matematyka");
                                sendMark(bw, "JezykPolski");
                                sendMark(bw, "JezykAngielski");
                            }
                            else if (chooseCase == 2) planlekcjiDane(bw);
                            else if (chooseCase == 3) uczenDane(bw, uLogin);
                        }
                    }
                } else {
                    if (!check) {
                        while (waitt) {
                            reciveCase(br);
                            if(chooseCase == 2) deleteSomething(br);
                            if(chooseCase == 3) nauczycielDane(bw,uLogin);
                        }
                    }
                }
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteSomething(BufferedReader br) {
        JSONObject rc = null;
        try {
            rc = new JSONObject(br.readLine());
            int chooseDelete = rc.optInt("whitchDelete");
            String data = rc.getString("data");
            switch(chooseDelete){
                case 0:

                    break;
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6://usuniecie klasy


                    break;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void reciveCase(BufferedReader br) {
        JSONObject rc = null;
        try {
            rc = new JSONObject(br.readLine());
            chooseCase = rc.optInt("cases");
        } catch (IOException | JSONException e) {
            waitt = false;
            e.printStackTrace();
        }
    }

    private void logowanieUzytkownika(BufferedWriter bw) {
        //Tutaj wchodzimy w operacje z baza danych
        Querries querries = new Querries();
        String bHaslo;
        try {
            bHaslo = querries.findHasloOfUzytkownikByLogin(uLogin);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            bHaslo = "";
        }
        if (bHaslo.equals(uhaslo) && bHaslo != "") {
            autoryzacjaKlienta("accept", bw);
            podstawoweDane(bw, uLogin);
            podstawoweDane(bw, uLogin);
            System.out.println("Uzytkownik o loginie:" + uLogin + " poprawnie sie zalogowal");
            check = false;
        } else autoryzacjaKlienta("declined", bw);
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

    private void podstawoweDane(BufferedWriter bw, String uLogin) {
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

    private void sendMark(BufferedWriter bw, String subject) {
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<Float> oc = querries.findOcenyByPrzedmiotforUczen(subject, uLogin);
            pd.put("size", oc.size());
            pd.put("subject", subject);
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for (int i = 0; i < oc.size(); i++) {
                pd.put("id", oc.get(i));
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
}
