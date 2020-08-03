import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpotyRequest {
    // This class will contain all data from the user
    public static void main(String a[]) throws IOException {

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("time_range", "medium_term");
        parameters.put("limit", "10");
        parameters.put("offset", "5");
        // add your token here
        String auth_token = "";
        String url_link = "https://api.spotify.com/v1/me/top/artists?" + ParameterStringBuilder.getParamsString(parameters);

        URL url = new URL(url_link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Request headers configuration
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + auth_token);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}