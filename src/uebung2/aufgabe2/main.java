package uebung2.aufgabe2;

import java.net.InetAddress;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        getIpByHostname();

    }

    /**
     * Methode gibt die IP-Adressen der in ihr definierten Hosts aus
     * unter Zuhilfenahme einer Hilfsmethode getIpByHostname2()
     */
    public static void getIpByHostname() {
        ArrayList<String> hosts = new ArrayList<String>();
        hosts.add("localhost");
        hosts.add("localhostll");
        hosts.add("www.google.de");
        hosts.add("www.youtube.de");
        hosts.add("www.facebook.de");
        hosts.add("www.web.de");
        hosts.add("www.onedrive.de");
        hosts.add("www.hwr-berlin.de");
        hosts.add("www.msn.de");
        hosts.add("www.apple.de");
        hosts.add("www.microsoft.de");
        hosts.add("www.wikipedia.com");

        /**
         * Alle in der ArrayList enthaltenden Hosts zu IP-Adressen umwandeln
         */
        // Buffer für Host und dessen IP-Adresse
        String currentHost = "";
        String currentHostsIP = "";
        // Alle Hossts durchgehen
        for (int i = 0; i < hosts.size(); i++) {
            currentHost = hosts.get(i);
            try {
                currentHostsIP = getIpByHostname2(hosts.get(i));
                System.out.println("Host: " + currentHost + " - IP: " + currentHostsIP);
            } catch (Exception e) {
                System.out.println("Host: " + currentHost +" - Fehler: " + e.toString());
                //e.printStackTrace();
            }
            // Buffer leeren
            currentHost = "";
            currentHostsIP = "";
        }
    }

    /**
     * Hilfs-Methode gibt die IP des übergebenen Hostnames zurück.
     *
     * @param hostname
     * @return - IP-Adresse des übergebenen Hostnames
     * @throws Exception - wenn Fehler bei der IP-Übersetzung
     */
    public static String getIpByHostname2(String hostname) throws Exception {
        InetAddress address1 = InetAddress.getByName(hostname);
        return address1.getHostAddress();
    }

}
