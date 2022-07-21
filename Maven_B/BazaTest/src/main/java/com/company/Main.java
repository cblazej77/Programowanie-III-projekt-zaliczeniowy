package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Baza baza = new Baza();
            //baza.wypiszAll();
            //baza.add(6, "Katarzyna Szulc", 32, "Piotrkow", 1239);
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
