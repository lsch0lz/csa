package uebung2.aufgabe3.version2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class main {
    private static String prefix = ">>> ";

    public static void main(String[] args) {
        ArrayList<String> serverList = new ArrayList<>();
        serverList.add("time.fu-berlin.de");
        serverList.add("zeit.fu-berlin.de");
        // serverList.add("time.nist.gov");
        // serverList.add("ptbtime1.ptb.de");

        try {
            for (int i = 0; i < serverList.size(); i++) {
                getTime(serverList.get(i));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e.toString());
        }

    }

    /**
     * "Die folgende Implementierung zeigt, wie ein Zeit-Server angesprochen wird.
     * Dazu wird zunächst ein leeres Paket als Anfrage an den Server gesendet.
     * Anschließend wird mit receive() auf das hereinkommende Paket gewartet.
     * Wenn dieses kommt, dann liefert getData() eine Zeichenkette mit der Zeit."
     *
     * Siehe http://www.tutego.de/java/articles/Java-Zeitdienste.html
     */
    public static void getTime(String server) {
        System.out.println(prefix + "Anfrage senden an: " + server);
        try {
            DatagramPacket packet;
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
            String s = prefix + "'-> Server: " + packet.getAddress() +
                    ":" + packet.getPort() +
                    " => " + new String(packet.getData());
            System.out.println(s);
            fromSocket.close();
        } catch (Exception e) {
            System.out.println(prefix + "Fehler: " + e.toString());
        }
    }
}
