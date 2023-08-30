package com.firstbit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.firstbit.model.Movie;

public class MovieDAO {

	public static Connection getConnection() {
		Connection connection = null;
		String dbURL = "jdbc:mysql://localhost:3309/";
		String dbName = "imdb";
		String dbUserName = "root";
		String dbPassword = "12345678";
		String dbDriverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(dbDriverClassName);
			connection = DriverManager.getConnection(dbURL + dbName, dbUserName, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// save
	public static int save(Movie movie) {
		int status = 0;
		try {
			Connection connection = MovieDAO.getConnection();
			String insertQuery = "insert into movie(movieid,moviename,actors,actresses,director,rating) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, movie.getMovieId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setString(3, movie.getActors());
			preparedStatement.setString(4, movie.getActresses());
			preparedStatement.setString(5, movie.getDirector());
			preparedStatement.setFloat(6, movie.getRating());
			status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Record Save Successfully");
			} else {
				System.out.println("Record Save Process Failed");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	// get
	public static Movie getMovieById(int movieid) {
		Movie movie = new Movie();
		try {
			Connection connection = MovieDAO.getConnection();
			String insertQuery = "select * from movie where movieid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, movieid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setActors(resultSet.getString(3));
				movie.setActresses(resultSet.getString(4));
				movie.setDirector(resultSet.getString(5));
				movie.setRating(resultSet.getFloat(6));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Movie :"+ movie);
		return movie;
	}

	public static List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		try {
			Connection connection = MovieDAO.getConnection();
			String insertQuery = "select * from movie";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setActors(resultSet.getString(3));
				movie.setActresses(resultSet.getString(4));
				movie.setDirector(resultSet.getString(5));
				movie.setRating(resultSet.getFloat(6));
				movies.add(movie);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public static int update(Movie movie) {
		int status = 0;
		try {
			Connection connection = MovieDAO.getConnection();
			String insertQuery = "update movie set moviename=?,actors=?,actresses=?,director=?,rating=? where movieid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, movie.getMovieName());
			preparedStatement.setString(2, movie.getActors());
			preparedStatement.setString(3, movie.getActresses());
			preparedStatement.setString(4, movie.getDirector());
			preparedStatement.setFloat(5, movie.getRating());
			preparedStatement.setInt(6, movie.getMovieId());
			status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Record Update Successfully");
			} else {
				System.out.println("Record Updation Failed");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// delete

	public static int delete(int movieid) {
		int status = 0;
		try {
			Connection connection = MovieDAO.getConnection();
			String insertQuery = "delete from movie where movieid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, movieid);
			status = preparedStatement.executeUpdate();
			if (status > 0) {
				System.out.println("Record Delete Successfully");
			} else {
				System.out.println("Record Deletion Failed");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
