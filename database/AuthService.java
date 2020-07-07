package database;
import model.Account;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AuthService {

    static String host = "http://localhost";
    static String path = "/api/user/";


    public static Account GetUser(String mail, String pass) throws Exception {


        URL url = new URL(host + path + "?email=" + mail + "&password=" + pass); // Construction de l'url de l'api

        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Creation de la connection http

        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode(); // appel de l'api
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            JSONObject data = Buffer(connection);
            JSONObject userJson = new JSONObject(data.get("User").toString());

            Account user = new Account();

            user.setId(Integer.parseInt(userJson.get("id").toString()));
            user.setFirstname(userJson.get("firstname").toString());
            user.setCity(userJson.get("city").toString());
            user.setLastname(userJson.get("lastname").toString());
            user.setPoints(Integer.parseInt(userJson.get("points").toString()));

            return user;


        } else {
            System.out.println("GET request not worked");
            return null;
        }


    }

    public static List<Account> GetAllUser() throws Exception {

        URL url = new URL(host + path + "?allUser"); // Construction de l'url de l'api

        System.out.println(url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Creation de la connection http

        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode(); // appel de l'api
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success

            JSONObject data = Buffer(connection);
            JSONArray userJson = new JSONArray(data.get("Users").toString());

            List<Account> users = new ArrayList<Account>();

            for(int i = 0 ; i< userJson.length()-1; i++){
                Account user = new Account();
                user.setId(Integer.parseInt(userJson.getJSONObject(i).get("id").toString()));
                user.setFirstname(userJson.getJSONObject(i).get("firstname").toString());
                user.setCity(userJson.getJSONObject(i).get("city").toString());
                user.setLastname(userJson.getJSONObject(i).get("lastname").toString());
                user.setPoints(Integer.parseInt(userJson.getJSONObject(i).get("points").toString()));
                users.add(user);

            }

            return users;





        }
        return null;

    }

    private static JSONObject Buffer(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return new JSONObject(response.toString());
    }
}
