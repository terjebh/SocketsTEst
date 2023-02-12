package com.noderia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket conn = new Socket("localhost",9898);
        PrintWriter out = new PrintWriter(conn.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        String msg;
        while(sc.hasNext()) {
            System.out.print("> ");
            out.println(sc.nextLine());
            if((msg = in.readLine())!= null) {
                System.out.println("[SERVER]: "+msg);
                System.out.print("> ");
            }
        }

    }

}
