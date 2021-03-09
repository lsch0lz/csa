package uebung2.aufgabe2;

import java.net.InetAddress;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        System.out.println("Mittels Hostnames IP-Adressen finden:");
        getIpByHostname();

        System.out.println();
        System.out.println();

        System.out.println("Mittels IP-Adressen Hostnames finden:");
        getHostnameByIp();
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
        InetAddress address = InetAddress.getByName(hostname);
        return address.getHostAddress();
    }

    // ==================================================================

    public static void getHostnameByIp() {
        ArrayList<String> ips = new ArrayList<String>();
        ips.add("127.0.0.1"); //localhost
        ips.add("0.0.0.0"); //none / error
        ips.add("142.250.185.99"); //google
        ips.add("142.250.185.206"); //youtube
        ips.add("69.171.250.35"); //facebook
        ips.add("82.165.230.17"); //web
        ips.add("104.215.148.63"); //onedrive
        ips.add("194.94.23.251"); //hwr-berlin
        ips.add("52.169.118.173"); //msn
        ips.add("17.253.144.10"); //apple
        ips.add("40.113.200.201"); //microsoft
        ips.add("91.198.174.194"); //wikipedia

        /**
         * Alle in der ArrayList enthaltenden IP-Adressen zu Hostnames umwandeln
         */
        // Buffer für IP-Adresse und dessen Host
        String currentHostsIP = "";
        String currentHost = "";
        // Alle IP-Adressen durchgehen
        for (int i = 0; i < ips.size(); i++) {
            currentHostsIP = ips.get(i);
            try {
                currentHost = getHostnameByIp2(ips.get(i));
                // Wenn IP-Adresse und Hostname identisch, dann Fehler ausgeben
                if(currentHostsIP.equals(currentHost)) {
                    throw new Exception("IP-Adresse und Hostname identisch.");
                }
                System.out.println("IP: " + currentHostsIP + " - Host: " + currentHost);
            } catch (Exception e) {
                System.out.println("IP: " + currentHostsIP +" - Fehler: " + e.toString());
                //e.printStackTrace();
            }
            // Buffer leeren
            currentHostsIP = "";
            currentHost = "";
        }
    }

    /**
     * Hilfs-Methode gibt den Hostname der ihr übergebenen IP zurück.
     *
     * @param ip
     * @return - Hostname der übergebenen IP-Adresse
     * @throws Exception - wenn Fehler bei der Übersetzung
     */
    public static String getHostnameByIp2(String ip) throws Exception {
        InetAddress name = InetAddress.getByName(ip);
        return name.getHostName();
    }

}
