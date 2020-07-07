package services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PointService {

    private String host = "http://localhost";
    private String path = "/api/card/";
    private final String USER__AGENT = "Mozilla/5.0";


    public void UpdatePoint(int id_userFrom, int id_userTo , int point) throws Exception {



        URL url = new URL(host + path); // Construction de l'url de l'api

        String urlParameters = "id_userFrom="+id_userFrom+"&id_userTo="+id_userTo+"&point=" + point;
        HttpURLConnection connection = (HttpURLConnection)url.openConnection(); // Creation de la connection http


        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", USER__AGENT);
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();


        int responseCode = connection.getResponseCode(); // appel de l'api
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());


    }


}




