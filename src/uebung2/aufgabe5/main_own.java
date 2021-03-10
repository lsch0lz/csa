package uebung2.aufgabe5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class main_own {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> domains = Arrays.asList("http://tagesschau.de/index.html", "http://www.google.de/index.html");

        //create new HttpClient Object
        HttpClient client = HttpClient.newHttpClient();

        for (int i = 0; i < domains.size(); i++) {
            String domain = domains.get(i);
            // define request to Website
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(domain))
                    .GET()
                    .build();

            //Send the defined request
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println("###### " + domain + " ######" + "\n");
            System.out.println(response.body());
        }
    }
}
