package com.firstbit.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstbit.dao.MovieDAO;
import com.firstbit.model.Movie;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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

		out.print("<h1> UPDATE MOVIE RECORD </h1>");

		String movieId = request.getParameter("movieid");
		Movie movie = MovieDAO.getMovieById(Integer.parseInt(movieId));

		out.print("<!DOCTYPE html> " + "<html> " + "<head> " + "<meta charset='ISO-8859-1'> "
				+ "<title>Movie Data Entry</title> " + "</head> " + "<body> " + "	<h1>Add New Movie Details</h1> "
				+ "	<form action='EditServlet2' method='post'> " + "		<table> " + "			<tr> "
				+ "				<td>MOVIE ID</td> " + "				<td><input type='hidden' name='movieid' value='"
				+ movie.getMovieId() + "'></td> " + "			</tr> " + "			<tr> "
				+ "				<td>MOVIE NAME</td> " + "				<td><input type='text' name='moviename'value=' "
				+ movie.getMovieName() + "'></td> " + "			</tr> " + "			<tr> "
				+ "				<td>ACTORS LIST</td> " + "				<td><input type='text' name='actors'value=' "
				+ movie.getActors() + "'></td> " + "			</tr> " + "			<tr> "
				+ "				<td>ACTRESSES LIST</td> "
				+ "				<td><input type='text' name='actresses'value=' " + movie.getActresses() + "'></td> "
				+ "			</tr> " + "			<tr> " + "				<td>DIRECTOR</td> "
				+ "				<td><input type='text' name='director' value=' " + movie.getDirector() + "'></td> "
				+ "			</tr> " + "			<tr> " + "				<td>RATING OUT OF 5</td> "
				+ "				<td><select name='rating' value=' " + movie.getRating() + "'> "
				+ "						<option>1</option> " + "						<option>1.5</option> "
				+ "						<option>2</option> " + "						<option>2.5</option> "
				+ "						<option>3</option> " + "						<option>3.5</option> "
				+ "						<option>4</option> " + "						<option>4.5</option> "
				+ "						<option>5</option> " + "				</select></td> " + "			</tr> "
				+ "			<tr> " + "				<td colspan='2'><input type='submit' value='UPDATE MOVIE'></td> "
				+ "			</tr> " + "		</table> " + "	</form> " + " "
				+ "	<a href='/MovieServletCRUDApp/ViewServlet'>View Movie List</a> " + "</body> " + "</html>");

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
