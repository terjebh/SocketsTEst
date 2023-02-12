package com.noderia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9898);
        System.out.println("Server running on port 9898");

        Socket client = serverSocket.accept();
        System.out.println("Client connected");

        PrintWriter out = new PrintWriter(client.getOutputStream(),true);

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg;
                while((msg = in.readLine()) != null){
                    System.out.println("[Client]: " + msg);
                    out.println("Kult at du sier "+msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
