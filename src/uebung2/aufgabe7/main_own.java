package uebung2.aufgabe7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class main_own {
    public static void main(String[] args) {
        connect();
    }
    public static void connect() {
        try (ServerSocket serverSocket = new ServerSocket(9991)){
            Socket connectionSocket = serverSocket.accept();

            InputStream in = connectionSocket.getInputStream();
            OutputStream out = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(in, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);

            serverPrintOut.println("Hello there! Enter Peace to exit.");

            boolean done = false;

            while(!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                serverPrintOut.println("Echo from Server: " + line);

                if(line.toLowerCase().trim().equals("peace")) {
                    done = true;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
