package com.company;

import java.sql.*;

public class Baza {

    private Connection connection;

    public Baza() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://abul.db.elephantsql.com:5432/ikyxpswp",
                "ikyxpswp", "G-Quql5IbyfaoXEIg8OSmjolzoKo50kT");
    }

    public void add_Uzytkownik(int id, String name, int age, String adress, double salary) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (" + id + " , '" + name + "', " + age + ", '" +
                adress + "', " + salary + " );";
        stmt.executeUpdate(sql);
        stmt.close();
    }

    public void wypiszAll() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM COMPANY WHERE AGE > 40;");
        while(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getInt("age");
            String adres = result.getString("address");
            double salary = result.getDouble("salary");
            System.out.println("" + id + " " + name + " " + age + " " + adres + " " + salary);
        }
    }

    public double getAvg() throws SQLException {
        Statement stmt = connection.createStatement();
        double avg = 0;
        ResultSet result = stmt.executeQuery("SELECT AVG(salary) FROM COMPANY;");
        result.next();
        avg = result.getDouble("avg");
        return avg;
    }*/

}
