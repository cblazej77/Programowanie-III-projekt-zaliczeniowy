package com.company;

import java.sql.*;

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
                + "VALUES (" + id + " , '" + login + "', " + haslo + ", '" +
                imie + "', " + nazwisko + "', " + rola + ");";
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
            System.out.println("" + id + " " + login + " " + haslo + " " + imie + " " + nazwisko + " " + rola);
        }
    }

    public double getAvg() throws SQLException {
        Statement stmt = connection.createStatement();
        double avg = 0;
        ResultSet result = stmt.executeQuery("SELECT AVG(salary) FROM COMPANY;");
        result.next();
        avg = result.getDouble("avg");
        return avg;
    }

}
