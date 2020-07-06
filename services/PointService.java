package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PointService {

    static String host = "localhost/post";
    static String path = "/api/card/";


    public void UpdatePoint(int id_userFrom, int id_userTo , int point) throws Exception {



        URL url = new URL(host + path + "?id_userFrom=" + id_userFrom + "&id_userTo=" + id_userTo + "&point=" + point); // Construction de l'url de l'api

        HttpURLConnection connection = (HttpURLConnection)url.openConnection(); // Creation de la connection http

        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");

        int responseCode = connection.getResponseCode(); // appel de l'api
        System.out.println("POST Response Code :: " + responseCode);


    }



}
