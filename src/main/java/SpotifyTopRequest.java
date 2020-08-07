import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SpotifyTopRequest{

    private String time_range;
    private String limit;
    private String offset;
    private String auth_token;

    // request constructor
    public SpotifyTopRequest(String inittime_range, String initlimit, String initoffset, String initauth_token){

       time_range = inittime_range;
       limit = initlimit;
       offset = initoffset;
       auth_token = initauth_token;
    }

    // method for making a request for getting top artists, albums, or artist plus metadata
    public String getTopArtists() {

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("time_range", time_range);
        parameters.put("limit", limit);
        parameters.put("offset", offset);

        try {
            // object initialization
            URL url = new URL(
                    "https://api.spotify.com/v1/me/top/artists/" + "?" + ParameterStringBuilder.getParamsString(parameters));

            // connection object initialization plus adding headers as attributes of the object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + auth_token);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                System.out.println(inputLine);
            }
            in.close();
            return response.toString();
        }
        catch(Exception e){}
        return "The request was not executed";
    }

}