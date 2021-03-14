package uebung2.aufgabe3;

/**
 * Siehe:
 * http://www.tutego.de/java/articles/Java-Zeitdienste.html
 */

public class main {

    /**
     * Sowohl Client als auch Server in jew. eigenständige Threads starten.
     */
    public static void main(String[] args) {
        Thread clientThread = new Thread(new Client());
        Thread serverThread = new Thread(new Server());

        serverThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clientThread.start();
    }



}
