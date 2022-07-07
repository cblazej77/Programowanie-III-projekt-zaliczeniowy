package com.example.ProgramowanieIIIprojektzaliczeniowy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
        try {
            bw = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));
            bw.write("Connection accepted");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
