package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.text.DecimalFormat;

public class Baza {

    private Connection connection;

    public Baza() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://abul.db.elephantsql.com:5432/ikyxpswp",
                "ikyxpswp", "G-Quql5IbyfaoXEIg8OSmjolzoKo50kT");
    }

    public void add_Uzytkownik(int id, String login, String haslo, String imie, String nazwisko, String rola) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO Uzytkownicy (idU,Login,Haslo,Imie,Nazwisko,Rola) "
                + "VALUES (" + id + " , '" + login + "', '" + haslo + "', '" +
                imie + "', '" + nazwisko + "', '" + rola + "');";
        stmt.executeUpdate(sql);
        stmt.close();
    }

    public void wypiszAll() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM Uzytkownicy;");
        while(result.next()) {
            int id = result.getInt("IdU");
            String login = result.getString("Login");
            String haslo = result.getString("Haslo");
            String imie = result.getString("Imie");
            String nazwisko = result.getString("Nazwisko");
            String rola = result.getString("Rola");
            System.out.println("" + id + " '" + login + "' '" + haslo + "' '" + imie + "' '" + nazwisko + "' '" + rola + "'");
        }
    }

    public void wypiszWszystkieSrednie() throws SQLException{ //to tak prosto liczy srednia dla wszystkich uczniow

        final DecimalFormat dfSharp = new DecimalFormat("#.##");

        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT u.login, AVG(o.ocena), o.idp FROM uzytkownicy u INNER JOIN oceny o ON u.idu = o.idu GROUP BY u.login, o.idp;");
        while(result.next()) {
            String login = result.getString("Login");
            double avg = result.getDouble("avg");
            int p = result.getInt("idp");
            String przedmiot = "brak"; //potrzebny aby prosto zamienic inta na odpowiedniego stringa, da sie lepiej ale nie pamietam jak
            if (p == 0) przedmiot = "matematyka";
            else if (p == 1) przedmiot = "polski";
            System.out.println("Uczen o loginie: " + login + " z przedmiotu " + przedmiot + " ma srednia: " + dfSharp.format(avg));
        }
    }

    //to wyzej byl zapis blazeja ja sobie skarcam np result na rs;
    public String zalogujUzytkownikaLogin(String ulogin)throws SQLException{

        PreparedStatement pstmt = connection.prepareStatement("SELECT haslo FROM uzytkownicy WHERE login = ?");//dajemy zapytanie bo bazy danych, ? - pozniej sie podmienia za zmienna
        pstmt.setString(1, ulogin); // zamieniamy '?' na zmienna ulogin - czyli login urzytkownika
        ResultSet rs = pstmt.executeQuery(); //czary mary jbda
        String haslo = "";
        if(rs.next()){
            haslo = rs.getString("haslo"); //odczytujemy haslo
            //System.out.println("Haslo dla: " + ulogin + " to '" + haslo+"'"); //wyswietlamy je
        }
        rs.close();//zamykamy chyba dla bezpieczenstwa
        pstmt.close();
        return haslo;
    }

    public JSONObject wyswietlUzytkownikaLogin(String ulogin) throws SQLException, JSONException {
        PreparedStatement pstmt = connection.prepareStatement("SELECT imie, nazwisko, rola FROM uzytkownicy u WHERE u.login = ?");
        pstmt.setString(1, ulogin);
        ResultSet rs = pstmt.executeQuery();
        JSONObject uczen = new JSONObject();
        while(rs.next()){
            uczen.put("imie", rs.getString("imie"));
            uczen.put("nazwisko", rs.getString("nazwisko"));
            uczen.put("rola", rs.getString("rola"));
        }
        rs.close();
        pstmt.close();
        return uczen;
    }



}
