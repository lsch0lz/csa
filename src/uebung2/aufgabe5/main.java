package uebung2.aufgabe5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws UnknownHostException {
        List<String> domains = Arrays.asList("www.tagesschau.de", "www.google.de" );

        try {
            for(int i = 0; i < domains.size(); i++){

                String domain = domains.get(i);
                InetAddress adress = InetAddress.getByName(domain);
                System.out.println(adress);

                Socket socket = new Socket(adress, 80);
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();

                String s = "GET " + "/index.html" + " HTTP/1.1" + "\r\n\r\n";
                out.write(s.getBytes());

                int len;
                byte[] b = new byte[100];
                System.out.println("###### " + domain + " ######" + "\n");

                while ((len = in.read(b)) != -1) {
                    System.out.write(b, 0, len);
                }
                socket.close();
            }

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
