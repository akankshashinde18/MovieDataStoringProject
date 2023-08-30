package com.firstbit.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstbit.dao.MovieDAO;
import com.firstbit.model.Movie;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<a href='index.html'> Add Movie </a>");
		out.print("<h1> Movie List </h1>");
		List<Movie> movies = new ArrayList<>();

		out.print("<table border='1' width='100%'>");
		out.print(
				"<tr><th>Movie ID</th>"
				+ "<th>Movie Name</th>"
				+ "<th>Actors</th>"
				+ "<th>Actresses</th>"
				+ "<th>Director</th>"
				+ "<th>Rating</th>"
				+ "<th>Update</th>"
				+ "<th>Delete</th></tr>");
		movies = MovieDAO.getAllMovies();
		for (Movie movie : movies) {
			out.print("<tr><td>" + movie.getMovieId() + "</td><td>" + movie.getMovieName() + "</td><td>"
					+ movie.getActors() + "</td><td>" + movie.getActresses() + "</td><td>" + movie.getDirector()
					+ "</td><td>" + movie.getRating() + "</td><td><a href='EditServlet?movieid=" + movie.getMovieId()
					+ "'>Update</a></td><td><a href='DeleteServlet?movieid=" + movie.getMovieId()
					+ "'>Delete</a></td></tr>");
		}
		out.print("</table>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
