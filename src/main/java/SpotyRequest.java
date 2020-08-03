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
        String auth_token = "BQB68ue2EE9uzyg2tKZqTZ4A8WdOBt99ZuZLsvtJAA3qKreZYaS3ehLBTdmNggmWXK4QGnbraar6ytCU5zkLWPVlY3Y2I6HEqq2WqHhe6SrG7yHc-agsKQ8kKXRyjNV77dAjws_T-2BhsAKwwaDyDPIatjoDDHpZ5ox1IcyOSoWIQH6evo-xK4rs8MUiHv0jwObfeX5RSjXAjGQCFQJG5iMAq5QCmJUmhE7tP3EqKe2Ms9HXxJmwsDlgg2jrakR5YO5TVQxkW3L5jrrN";
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