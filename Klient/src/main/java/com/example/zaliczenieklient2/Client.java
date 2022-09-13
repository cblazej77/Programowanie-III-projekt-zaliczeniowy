package com.example.zaliczenieklient2;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.List;

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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    public JSONObject getData(){
        JSONObject serwer = null;
        try {
            serwer = new JSONObject(br.readLine());
        }catch (IOException | JSONException e){e.printStackTrace();}
        return serwer;
    }
    public void SendRemoveSygnal(String data, int i){
        try{
            json = new JSONObject();
            json.put("data", data);
            json.put("whichDelete", i);
            bw.write(json.toString());
            bw.newLine();
            bw.flush();
        }catch(IOException | JSONException e){e.printStackTrace();}
    }
    public void SendRemoveMark(Float mark, String mark, String Lession){
        try{
            json = new JSONObject();
            json.put("rMark", mark);
            json.put("rLogin", mark);
            json.put("rLession", Lession);
            bw.write(json.toString());
            bw.newLine();
            bw.flush();
        }catch(IOException | JSONException e){e.printStackTrace();}
    }

    public void SendAddSignal(List<String> Data, int i, int n) throws JSONException, IOException {
        json = new JSONObject();
        for(int j=0;j<n;j++){
            json.put("data" + j, Data.get(j));
        }
        json.put("whichAdd",i);
        bw.write(json.toString());
        bw.newLine();
        bw.flush();
    }

    public boolean sendLogPassToSerwer(String login, String password){//Wysyla login i haslo w JONSONie do serwera, po wcisnieciu przycisku zaloguj
        try{
            json = new JSONObject();
            json.put("login", login);
            json.put("haslo", password);
            bw.write(json.toString());
            bw.newLine();
            bw.flush();
            return false;
        }catch(IOException | JSONException e){
            e.printStackTrace();
            closeEvrything(socket, bw, br);
            System.out.println("Error to send login&pass(json) to the serwer");
            return true;
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

    public void sendCase(int i) throws JSONException, IOException {
        json = new JSONObject();
        json.put("cases", i);
        bw.write(json.toString());
        bw.newLine();
        bw.flush();
    }
}