package uebung2.aufgabe3.version1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client extends Thread {
    private String prefix = "Client >>> ";

    /**
     * "Die folgende Implementierung zeigt, wie ein Zeit-Server angesprochen wird.
     * Dazu wird zunächst ein leeres Paket als Anfrage an den Server gesendet.
     * Anschließend wird mit receive() auf das hereinkommende Paket gewartet.
     * Wenn dieses kommt, dann liefert getData() eine Zeichenkette mit der Zeit."
     *
     * Siehe http://www.tutego.de/java/articles/Java-Zeitdienste.html
     */
    public void run() {
        String server = "localhost";
        System.out.println(prefix + "Anfrage senden an: " + server);
        try {
            DatagramPacket packet;
            while (true) {
                // Anfrage an Server senden
                byte data[] = new byte[1024];
                InetAddress ia = InetAddress.getByName(server);
                packet = new DatagramPacket(data, data.length, ia, 13);
                DatagramSocket toSocket = new DatagramSocket();
                toSocket.send(packet);
                System.out.println(prefix + "'-> Anfrage gesendet.");
                // Antwort des Servers abwarten
                DatagramSocket fromSocket = toSocket;
                //new DatagramSocket();
                packet = new DatagramPacket(data, data.length);
                System.out.println(prefix + "'-> Auf Antwort warten.");
                fromSocket.receive(packet);
                System.out.println(prefix + "Antwort empfangen:");
                String s = prefix + "'-> Server " + packet.getAddress() +
                        ":" + packet.getPort() +
                        " => " + new String(packet.getData());
                System.out.println(s);
                fromSocket.close();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(prefix + "Fehler: " + e.toString());
        }
    }

}
