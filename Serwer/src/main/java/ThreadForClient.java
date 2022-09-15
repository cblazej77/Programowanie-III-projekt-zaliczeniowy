import Enitities.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.sql.Date;
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
            access="";
            while(check){//for(check = 0; check < 4; check++) {//ta petla chyba jest nie potrzebna i psuje program
                klient = new JSONObject(br.readLine());
                uLogin = klient.optString("login"); if (uLogin == klient.optString("login")){ System.out.println("Login taken from JSON"); }
                uhaslo = klient.optString("haslo"); if(uhaslo == klient.optString("haslo")) {System.out.println("Haslo taken from JASON"); }
                logowanieUzytkownika(bw);
                if(access.equals("UCZEN")){
                    if (!check) {
                        while (wait) {
                            reciveCase(br);
                            if (chooseCase == 0){//za kazdym dodanym tutaj przedmiotem trzeba zwiekszyc w kliencie, forze zmienna z o jeden wiecej
                                countSubject(bw);
                                sendMark(bw, "informatyka");
                                sendMark(bw, "matematyka");
                                sendMark(bw, "JezykAngielski");
                                sendMark(bw, "JezykPolski");
                                //sendMark(bw, "Muzyka");
                            }
                            else if(chooseCase == 2) {
                                System.out.println("Wyswietlamy planLekcji");
                                planlekcjiDane(bw,"Poniedzialek");
                                //planlekcjiDane(bw,"Wtorek");
                                //planlekcjiDane(bw,"Sroda");
                                //planlekcjiDane(bw,"Czwartek");
                                //planlekcjiDane(bw,"Piatek");
                            }
                            else if(chooseCase == 3) uczenDane(bw, uLogin);

                        }
                    }
                }else{
                    if (!check) {
                        while (wait) {
                            reciveCase(br);
                            if(chooseCase == 4) nauczycielDane(bw,uLogin);
                            if(chooseCase == 5) //OcenyNauczycielaDane(bw,uLogin);ta funckja jest pusta
                            if(chooseCase == 6) removeDane(br);
                            if(chooseCase == 7) addDane(br);
                            if(chooseCase == 8) {}//frekfencja
                        }
                    }
                }

            }

        } catch (IOException | JSONException e){throw new RuntimeException(e);
        }
    }
    private void countSubject(BufferedWriter bw){
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<Float> oc = querries.countPrzedmioty();
            System.out.println(oc.size());
            pd.put("count", oc.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
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


    private void reciveCase(BufferedReader br) {
        JSONObject rc = null;
        try{
            rc = new JSONObject(br.readLine());
            chooseCase = rc.optInt("cases");
        }catch (IOException | JSONException e){
            wait = false;
            e.printStackTrace();}
    }

    private void removeDane(BufferedReader br) throws IOException, JSONException {
        Querries querries = new Querries();
        JSONObject rc = null;
        rc = new JSONObject(br.readLine());
        //String data = rc.optString("data");
        int which = rc.optInt("whichDelete");
        switch (which){
            case 0:
                querries.removeUzytkownikByLogin(rc.optString("data0"));
                break;
            case 1:
                querries.removeUczenByLogin(rc.optString("data0"));
                break;
            case 2:
                querries.removeNauczycielByLogin(rc.optString("data0"));
                break;
            case 3:
                querries.removePrzedmiotByNazwa(rc.optString("data0"));
                break;
            case 4:
                querries.removeOcena(rc.optString("data0"), (float) rc.optDouble("data1"), rc.optString("data2"), rc.optString("data3"));
                break;
            case 5:
                Integer godzina = rc.optInt("data0");
                String klasa = rc.optString("data1");
                String login = rc.optString("data2");
                String nazwaP = rc.optString("data3");
                Date data = Date.valueOf(rc.optString("data4"));
                querries.removeLekcja(godzina,klasa,login,nazwaP,data);
                //querries.removeLekcja(rc.optInt("data0"),rc.optString("data1"),rc.optString("data2"),rc.optString("data3"), Date.valueOf(rc.optString("data4")));
                break;
            case 6:
                querries.removeKlasaByNazwa(rc.optString("data0"));
                break;
            case 7:
                querries.removeFrekwencja(rc.optString("data0"),rc.optString("data1"),Date.valueOf(rc.optString("data2")),rc.optInt("data3"), rc.optString("data4"));
                break;
            case 8:
                querries.removeNauczycielPrzedmiotow(rc.optString("data0"),rc.optString("data1"));
                break;
            case 9:
                querries.removePrzedmiotKlasy(rc.optString("data0"),rc.optString("data1"));
                break;
            default:
                break;
        }
    }

    private void addDane(BufferedReader br) throws IOException, JSONException {
        Querries querries = new Querries();
        JSONObject rc = null;
        rc = new JSONObject(br.readLine());
        int which = rc.optInt("whichAdd");
        switch (which){
            case 0:
                querries.addUzytkownik(rc.optString("data0"),rc.optString("data1"),rc.optString("data2"),rc.optString("data3"),rc.optString("data4"));
                break;
            case 1:
                querries.addUczen(rc.optInt("data0"),rc.optLong("data1"),rc.optLong("data2"),rc.optLong("data3"));
                break;
            case 2:
                querries.addNauczyciel(rc.optLong("data0"));
                break;
            case 3:
                querries.addPrzedmiot(rc.optString("data0"));
                break;
            case 4:
                break;
            case 5:
                //querries.removeLekcja(data);
                break;
            case 6:

                break;
            case 7:
                //querries.removeFrekwencja(data);
                break;
            case 8:
                //querries.removeNauczycielPrzedmiotu(data);
                break;
            case 9:
                //querries.removePrzedmiotKlasy(data);
                break;
            default:
                break;
        }
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
        if (bHaslo.equals(uhaslo) && (!bHaslo.equals(""))) {
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
            //NauczycieleEntity tch = querries.findNauczycielByLogin(uLogin);
            //KlasyEntity cls = querries.findKlasaByNauczyciel(String.valueOf(tch));
            JSONObject pd = new JSONObject();
            pd.put("imie", us.getImie());
            pd.put("nazwisko", us.getNazwisko());
            //pd.put("klasa", cls.getNazwa());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void planlekcjiDane(BufferedWriter bw, String day){
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<String> przedmioty = querries.findLekcjePrzedmiotForPrzedmiotByUserLogin(uLogin, Date.valueOf(day));
            List<Integer> godziny = querries.findLekcjeGodzinaForPrzedmiotByUserLogin(uLogin, Date.valueOf(day));
            pd.put("day",day);
            //bw.write(pd.toString());
            //bw.newLine();
            //bw.flush();

            System.out.println(przedmioty);
            pd.put("size",przedmioty.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            /*
            for(int i=0;i<oc.size();i++){
                pd.put("hour",oc1.get(i));
                pd.put("lesson",oc.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
             */
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    private void OcenyNauczycielaDane(BufferedWriter bw, String uLogin){



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
