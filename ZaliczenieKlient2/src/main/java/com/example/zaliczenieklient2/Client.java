package com.example.zaliczenieklient2;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    private JSONObject json;

    public Client(Socket socket) {//Constructor
        try {
            this.socket = socket;
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(("Error creating client"));
            e.printStackTrace();
            closeEvrything(socket, bw, br);
        }
    }

    public void sendLogPassToSerwer(String login, String password){//Wysyla login i haslo w JONSONie do serwera, po wcisnieciu przycisku zaloguj
        try{
            json = new JSONObject();
            json.put("login", login);
            json.put("haslo", password);
            bw.write(json.toString());
            bw.newLine();
            bw.flush();
        }catch(IOException | JSONException e){
            e.printStackTrace();
            System.out.println("Error to send login&pass(json) to the serwer");
            closeEvrything(socket, bw, br);
        }
    }

    public boolean authorizationLogin(){
        try {
            JSONObject serwer = new JSONObject(br.readLine());
            if (serwer.optString("status").equals("accept")) return true;
            else return false;
        }catch(IOException | JSONException e){e.printStackTrace();}
        return false;
    }

    public void closeEvrything(Socket socket, BufferedWriter bw, BufferedReader br){
        try{
            if(br != null) br.close();
            if(bw != null) bw.close();
            if(socket != null) socket.close();
        }catch(IOException e){e.printStackTrace();}
    }


}