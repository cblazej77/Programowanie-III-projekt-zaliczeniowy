package com.example.ProgramowanieIIIprojektzaliczeniowy;

import java.io.*;
import java.net.Socket;


public class ThreadForClient extends Thread{

    private Socket socket;

    public ThreadForClient(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        System.out.println("Client: " + socket.getInetAddress().getHostName() + " connected.");
        BufferedWriter bw = null;
        BufferedReader br = null;
        String login;
        try {
            bw = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));
            bw.write("Connection accepted");
            bw.newLine();
            bw.flush();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            login = br.readLine();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
