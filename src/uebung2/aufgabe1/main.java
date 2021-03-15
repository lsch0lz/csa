package uebung2.aufgabe1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Scanner scanner = new Scanner(System.in);

        List<String> domains = Arrays.asList("localhost", "www.google.de", "www.hwr-berlin.de", "www.facebook.com", "www.t3n.de", "www.heise.de", "www.web.de", "www.gmx.de", "www.hotmail.de", "www.bild.de", "www.apple.com");


        for (int i = 0; i < domains.size(); i++) {
            try {
                String domain = domains.get(i);
                String final_domain = "ping " + domain;
                System.out.println(final_domain);

                processBuilder.command("bash", "-c", final_domain);
                Process process = processBuilder.start();

                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    break;
                }
                process.destroy();


            } catch(IOException e){
                e.printStackTrace();
            }
        }

        List<String> ip = Arrays.asList("8.8.8.8", "104.121.135.247S");

        for (int i = 0; i < ip.size(); i++) {
            try {
                String domain = ip.get(i);
                System.out.println(domain);

                String final_domain = "ping " + domain;

                processBuilder.command("bash", "-a", final_domain);
                Process process = processBuilder.start();

                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    break;
                }

                process.destroy();


            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }

}

