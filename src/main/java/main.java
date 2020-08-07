public class main {
    public static void main(String args[]){
        SpotifyTopRequest test = new SpotifyTopRequest(
                "medium_term",
                "10",
                "5",
                "<Insert your api auth token here>");
        test.getTopArtists();
    }
}
