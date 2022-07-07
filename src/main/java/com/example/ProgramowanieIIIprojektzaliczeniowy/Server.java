package com.example.ProgramowanieIIIprojektzaliczeniowy;

import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8081);
        while(true){
            Socket socket = server.accept();
            ThreadForClient thc = new ThreadForClient(socket);
            thc.start();
        }
    }

}
