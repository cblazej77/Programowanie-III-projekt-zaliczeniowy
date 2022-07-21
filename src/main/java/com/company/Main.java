package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Baza baza = new Baza();
            //baza.add_Uzytkownik(1, "login", "haslo", "Ewa","Nowak", "Nauczyciel");
            baza.wypiszAll();
            //baza.add(7, "Justyna Bialka", 54, "Torun", 8423);
            //baza.add(8, "Pawel Dobrzynski", 49, "Wroclaw", 4698);
            //baza.wypiszAll();
            //System.out.println("srednia: " + baza.getAvg());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
