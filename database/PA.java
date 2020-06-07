package database;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class PA {

    static String host = "http://51.83.45.52";
    static String path = "/api/user/";


    public static void GetUser(int id) throws Exception {

        URL url = new URL(host + path + "?id=" + URLEncoder.encode(String.valueOf(id), StandardCharsets.UTF_8)); // Construction de l'url de l'api

        HttpURLConnection connection = (HttpURLConnection)url.openConnection(); // Creation de la connection http

        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode(); // appel de l'api
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }


    }



}
