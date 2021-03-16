package uebung2.aufgabe7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class main {
    public static void main(String[] args) throws IOException {

        ServerSocket s = null;
        Socket conn = new Socket();
        PrintStream out = null;
        BufferedReader in = null;
        String message = null;

        try {

            s = new ServerSocket(13, 10);

            echo("Server Socket created! Waiting for connection..");

            conn = s.accept();

            echo("Connection from" + conn.getOutputStream());

            out = new PrintStream(conn.getOutputStream());
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            out.println("Welcome.");
            out.flush();

        }catch (IOException e){
            System.err.println("IOException");
        }

        in.close();
        out.close();
        s.close();


    }
    public static void echo(String msg){
        System.out.println(msg);
    }
}
