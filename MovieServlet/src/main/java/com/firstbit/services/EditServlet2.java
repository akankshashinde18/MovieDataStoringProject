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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String movieId = request.getParameter("movieid");
		String movieName = request.getParameter("moviename");
		String actors = request.getParameter("actors");
		String actresses = request.getParameter("actresses");
		String director = request.getParameter("director");
		String rating = request.getParameter("rating");

		Movie movie = new Movie();

		movie.setMovieId(Integer.parseInt(movieId));
		movie.setMovieName(movieName);
		movie.setActors(actors);
		movie.setActresses(actresses);
		movie.setDirector(director);
		movie.setRating(Float.parseFloat(rating));

		int status = MovieDAO.update(movie);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.print("Record Update Process Failed...");
		}
		out.close();
	}

}
