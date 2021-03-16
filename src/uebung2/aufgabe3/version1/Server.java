package uebung2.aufgabe3.version1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server extends Thread {
    private String prefix = "Server >>> ";

    /**
     * "Der Server liest aus dem Paket die IP-Adresse und Port-Nummer des Senders heraus
     * und schickt ein Paket mit einer Zeiteinheit zurück. Das nachfolgende Programm wartet
     * auf dem Port auf eine Anfrage und gibt die aktuelle Zeit einfach aus."
     *
     * Siehe http://www.tutego.de/java/articles/Java-Zeitdienste.html
     */
    public void run() {
        System.out.println(prefix + "Gestartet.");
        try {
            byte data[] = new byte[1024];
            DatagramPacket packet;
            DatagramSocket socket = new DatagramSocket(13);
            while (true) {
                System.out.println(prefix + "Warte auf eingehende Anfrage.");
                // Auf Anfrage warten
                packet = new DatagramPacket(data, data.length);
                socket.receive(packet);
                System.out.println(prefix + "Anfrage erhalten:");
                // Empfänger auslesen, aber Paketinhalt ignorieren
                InetAddress adress = packet.getAddress();
                int port   = packet.getPort();
                System.out.println(prefix + "'-> Client " + packet.getAddress() +
                        ":" + packet.getPort());
                // Paket für Empfänger zusammenbauen
                System.out.println(prefix + "'-> Erstelle Antwort-Paket.");
                String s = new Date().toString() + "\n";
                s.getBytes(0, s.length(), data, 0);
                packet = new DatagramPacket(data,data.length,adress,port);
                System.out.println(prefix + "'-> Sende Antwort-Paket.");
                socket.send(packet);
                System.out.println(prefix + "Anfrage erfolgreich bearbeitet.");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(prefix + "Fehler: " + e.toString());
        }
    }

}
