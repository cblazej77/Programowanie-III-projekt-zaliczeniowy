package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(8081);
            while(true) {
                Socket socket = server.accept();
                ThreadForClient thc = new ThreadForClient(socket);
                thc.start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
