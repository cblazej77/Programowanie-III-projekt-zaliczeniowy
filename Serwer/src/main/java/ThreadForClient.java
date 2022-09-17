import Enitities.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.sql.Date;
import java.util.List;

public class ThreadForClient extends Thread{

    private Socket socket;
    private String uLogin;
    private String uhaslo;
    private boolean check;
    private boolean wait;
    private String access;

    private String date;

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
                            receiveCase(br);
                            if (chooseCase == 0){//za kazdym dodanym tutaj przedmiotem trzeba zwiekszyc w kliencie, forze zmienna z o jeden wiecej
                                countSubject(bw);
                                sendMark(bw, "informatyka");
                                sendMark(bw, "matematyka");
                                sendMark(bw, "JezykAngielski");
                                sendMark(bw, "JezykPolski");
                                //sendMark(bw, "Muzyka");
                            }
                            else if(chooseCase == 1){
                                for(int i=0; i<5; i++){
                                    klient = new JSONObject(br.readLine());
                                    Date data = Date.valueOf(klient.optString("data"));
                                    FrekwencjaDane(bw, data);
                                }
                            }
                            else if(chooseCase == 2) {
                                for(int i=0; i<5; i++){
                                    klient = new JSONObject(br.readLine());
                                    Date data = Date.valueOf(klient.optString("data"));
                                    planlekcjiDane(bw, data);
                                }
                            }
                            else if(chooseCase == 3) uczenDane(bw, uLogin);
                        }
                    }
                }else{
                    if (!check) {
                        while (wait) {
                            receiveCase(br);
                            if(chooseCase == 4) nauczycielDane(bw,uLogin);
                            if(chooseCase == 5) //OcenyNauczycielaDane(bw,uLogin);ta funckja jest pusta
                            if(chooseCase == 6) editDane(br);
                            if(chooseCase == 8) {subjectSend(bw); findKlasy(bw);};//wysyla liste przedmiotow,
                            if(chooseCase == 9) {checkTeacher(br, bw);}//sprawdza czy dany nauczyciel uczy wybranego przez siebie przedmiotu
                            if(chooseCase == 10) {sendAllClass(bw, br);}//wysyla liste osob w klasie
                            if(chooseCase == 11) {checkClasses(br, bw);}//sprawdza czy dany nauczyciel uczy wybranej klasy
                            if(chooseCase == 12) {addFrequency(br);}//wstawia frekfencje dla danego ucznia
                            else if(chooseCase == 13) teacherLogin(bw);
                        }
                    }
                }

            }

        } catch (IOException | JSONException e){throw new RuntimeException(e);
        }
    }

    private void teacherLogin(BufferedWriter bw) throws JSONException, IOException {
        JSONObject pd = new JSONObject();
        pd.put("loginTeacher", uLogin);
        bw.write(pd.toString());
        bw.newLine();
        bw.flush();
    }

    private void addFrequency(BufferedReader br){
        JSONObject rc = null;
        String przedmiotJ, loginSJ, rodzaj, klasa;
        int godzina;
        Date data;
        try {
            rc = new JSONObject(br.readLine());
            przedmiotJ = rc.optString("przedmiot");
            loginSJ = rc.optString("loginS");
            rodzaj = rc.optString("rodzaj");
            klasa = rc.optString("klasa");
            godzina = rc.optInt("godzina");
            data = Date.valueOf((rc.optString("LocalDate")));
            Querries querries = new Querries();
            querries.addFrekwencjaOnEverything(przedmiotJ, loginSJ, data ,godzina, rodzaj, klasa, uLogin);
        } catch (IOException e) {e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void sendAllClass(BufferedWriter bw, BufferedReader br){
        JSONObject rc = null;
        JSONObject pd = new JSONObject();
        String classView;
        try {
            rc = new JSONObject(br.readLine());
            classView = rc.optString("data");
            Querries querries = new Querries();
            List<String> loginU = querries.findLoginyUczniowZKlasy(classView);
            List<Integer> id = querries.findNumeryUczniowZKlasy(classView);
            List<String> name = querries.findImionaUczniowZKlasy(classView);
            List<String> surname = querries.findNazwiskaUczniowZKlasy(classView);
            pd.put("size", name.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for(int i=0; i<name.size(); i++){
                pd.put("id", id.get(i));
                pd.put("login", loginU.get(i));
                pd.put("name", name.get(i));
                pd.put("surname", surname.get(i));
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
    private void checkClasses(BufferedReader br, BufferedWriter bw) {
        JSONObject rc = null;
        JSONObject pd = new JSONObject();
        String classCheck;
        try{
            rc = new JSONObject(br.readLine());
            classCheck = rc.optString("data");
            Querries querries = new Querries();
            Boolean aBoolean = querries.czyNauczycielUczyKlase(uLogin, classCheck);
            if(aBoolean) pd.put("boolean", "Yes");
            else pd.put("boolean", "No");
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        }catch (IOException | JSONException e){
            e.printStackTrace();}
    }
    private void checkTeacher(BufferedReader br, BufferedWriter bw){
        JSONObject rc = null;
        JSONObject pd = new JSONObject();
        String subjectCheck;
        try{
            rc = new JSONObject(br.readLine());
            subjectCheck = rc.optString("data");
            Querries querries = new Querries();
            Boolean aBoolean = querries.czyNauczycielUczyPrzedmiotu(uLogin, subjectCheck);
            if(aBoolean) pd.put("boolean", "Yes");
            else pd.put("boolean", "No");
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        }catch (IOException | JSONException e){
            e.printStackTrace();}
    }
    private void countSubject(BufferedWriter bw){
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<Float> oc = querries.countPrzedmioty();
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
    private void findKlasy(BufferedWriter bw){
        try{
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<String> Class = querries.findKlasy();
            pd.put("size", Class.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for(int i = 0; i<Class.size(); i++){
                pd.put("Class", Class.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    private void subjectSend(BufferedWriter bw) {
        try{
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();
            List<String> subject = querries.findPrzedmmioty();
            pd.put("size", subject.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for(int i = 0; i<subject.size(); i++){
                pd.put("subject", subject.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException | JSONException e) {
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
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }


    private void receiveCase(BufferedReader br) {
        JSONObject rc = null;
        try{
            rc = new JSONObject(br.readLine());
            chooseCase = rc.optInt("cases");
        }catch (IOException | JSONException e){
            wait = false;
            e.printStackTrace();}
    }

    private void editDane(BufferedReader br) throws IOException, JSONException {
        Querries querries = new Querries();
        JSONObject rc = null;
        rc = new JSONObject(br.readLine());
        int which = rc.optInt("whichEdit");
        switch (which){
            case 0:
                querries.changeKlasaForUczen(rc.optString("data0"),rc.optString("data1"));
                break;
            case 1:
                querries.removeUzytkownikByLogin(rc.optString("data0"));
                break;
            case 2:
                querries.addUzytkownik(rc.optString("data0"), rc.optString("data1"), rc.optString("data2"),
                        rc.optString("data3"), rc.optString("data4"));
                break;
            case 3:
                querries.removeUczenByLogin(rc.optString("data0"));
                break;
            case 4:
                querries.addUczenByLogins(rc.optInt("data0"), rc.optString("data1"), rc.optString("data2"),
                        rc.optString("data3"));
                break;
            case 5:
                querries.removeNauczycielByLogin(rc.optString("data0"));
                break;
            case 6:
                querries.addNauczyciel(rc.optLong("data0"));
                break;
            case 7:
                querries.removePrzedmiotByNazwa(rc.optString("data0"));
                break;
            case 8:
                querries.addPrzedmiot(rc.optString("data0"));
                break;
            case 9:
                querries.removeOcena(rc.optString("data0"), (float) rc.optDouble("data1"),
                        rc.optString("data2"), rc.optString("data3"));
                break;
            case 10:
                querries.addOcena(rc.optString("data0"), (float) rc.optDouble("data1"), rc.optLong("data2"),
                        rc.optLong("data3"));
                break;
            case 11:
                querries.removeLekcja(rc.optInt("data0"), rc.optString("data1"), rc.optString("data2"),
                        rc.optString("data3"), Date.valueOf(rc.optString("data4")));
                break;
            case 12:
                querries.addLekcja(rc.optInt("data0"), rc.optLong("data1"), rc.optLong("data2"),
                        Date.valueOf(rc.optString("data3")), rc.optString("data4"));
                break;
            case 13:
                querries.removeKlasaByNazwa("data0");
                break;
            case 14:
                querries.addKlasa(rc.optString("data0"), Date.valueOf(rc.optString("data1")),
                        rc.optLong("data2"));
                break;
            case 15:
                querries.removeFrekwencja(rc.optString("data0"), rc.optString("data1"),
                        Date.valueOf(rc.optString("data2")), rc.optInt("data3"), rc.optString("data4"));
                break;
            case 16:
                querries.addFrekwencjaOnEverything(rc.optString("data0"), rc.optString("data1"),
                        Date.valueOf(rc.optString("data2")), rc.optInt("data3"), rc.optString("data4"),
                        rc.optString("data5"), rc.optString("data6"));
                break;
            case 17:
                querries.removeNauczycielPrzedmiotow(rc.optString("data0"), rc.optString("data1"));
                break;
            case 18:
                querries.addNauczycielePrzedmiotow(rc.optLong("data0"), rc.optLong("data1"));
                break;
            case 19:
                querries.removePrzedmiotKlasy(rc.optString("data0"), rc.optString("data1"));
                break;
            case 20:
                querries.addPrzedmiotKlasy(rc.optLong("data0"), rc.optLong("data1"));
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
            List<String> subjects = querries.findPrzedmiotyNauczanePrzezNauczyciela(uLogin);
            List<String> findClass = querries.findKlaseWychowawcy(uLogin);
            int countSubjects = subjects.size();
            int countClass= findClass.size();
            JSONObject pd = new JSONObject();
            pd.put("imie", us.getImie());
            pd.put("nazwisko", us.getNazwisko());
            pd.put("countSubjects", countSubjects);
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();

            for(int i=0; i<countSubjects; i++){
                pd.put("subjects", subjects.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
            pd.put("countClass", countClass);
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for(int i=0; i<countClass; i++){
                pd.put("Class", findClass.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    private void FrekwencjaDane(BufferedWriter bw, Date day){
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();

            List<String> frekwencja = querries.findFrekwencjaRodzajOrderByGodzinaLekcji(uLogin, day);
            pd.put("size", frekwencja.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
            for(int i=0;i<frekwencja.size();i++){
                pd.put("freqwency",frekwencja.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private void planlekcjiDane(BufferedWriter bw, Date day){
        try {
            JSONObject pd = new JSONObject();
            Querries querries = new Querries();

            List<String> przedmioty = querries.findLekcjePrzedmiotForPrzedmiotByUserLogin(uLogin, day);
            //List<Integer> godziny = querries.findLekcjeGodzinaForPrzedmiotByUserLogin(uLogin, day);

            pd.put("size",przedmioty.size());
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();

            for(int i=0;i<przedmioty.size();i++){
                //pd.put("hour",godziny.get(i));
                pd.put("lesson",przedmioty.get(i));
                bw.write(pd.toString());
                bw.newLine();
                bw.flush();
            }
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
