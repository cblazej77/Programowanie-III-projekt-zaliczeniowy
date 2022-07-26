package com.company;


import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;


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
            bw.write("Connection accepted");
            bw.newLine();
            bw.flush();

            //zczytanie z jasona hasla i loginu wpisanego przez uzytkownika

                JSONObject klient;
                for(check = 0; check < 4; check++) {
                    klient = new JSONObject(br.readLine());
                    uLogin = klient.optString("login");
                    uhaslo = klient.optString("haslo");
                    logowanieUzytkownika(bw);

                }

        } catch (IOException e){throw new RuntimeException(e);
        } catch (JSONException e) {throw new RuntimeException(e);}
    }

    private void logowanieUzytkownika(BufferedWriter bw){
        //Tutaj wchodzimy w operacje z baza danych
        try {
            Baza baza = new Baza();
            String bHaslo = baza.zalogujUzytkownikaLogin(uLogin);

            if (bHaslo.equals(uhaslo)) {
                autoryzacjaKlienta("accept", bw);
                podstawoweDane(baza, bw, uLogin);
                System.out.println("Uzytkownik o loginie:" + uLogin + " poprawnie sie zalogowal");
                check = 4;
            }else autoryzacjaKlienta("declined", bw);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void podstawoweDane(Baza baza, BufferedWriter bw, String uLogin){
        try {
            JSONObject pd = new JSONObject();
            pd = baza.wyswietlUzytkownikaLogin(uLogin);
            bw.write(pd.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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