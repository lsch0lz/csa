package uebung2.aufgabe8;

import uebung2.aufgabe8.Server;

public class main {
    public static void main(String[] args) {

        Thread serverThread = new Thread(new Server());

        serverThread.start();

    }
}
