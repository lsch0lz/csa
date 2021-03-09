package uebung1.aufgabe2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class main {

    public static void main(String[] args) throws UnknownHostException {
        getIpByHostname("www.google.de");
    }

    public static String getIpByHostname(String hostname) {
        String out = "";
        try {
            InetAddress address1 = InetAddress.getByName(hostname);
            out = address1.getHostAddress();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return out;
    }

}
