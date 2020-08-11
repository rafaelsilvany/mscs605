import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstTestServlet
 */
@WebServlet("/spotifyAPIServlet")
public class SpotifyAPIServlet extends HttpServlet {
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String timeRange = request.getParameter("timeRange");
		String limit = request.getParameter("limit");
		String offset = request.getParameter("offset");
		String token = request.getParameter("token");
		
		
		SpotifyTopRequest test = new SpotifyTopRequest(timeRange, limit, offset, token);
		String topArtistsOutput = test.getTopArtists();

		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println(topArtistsOutput);

		
	}

	public void destroy() {
		// do nothing.
	}

}
