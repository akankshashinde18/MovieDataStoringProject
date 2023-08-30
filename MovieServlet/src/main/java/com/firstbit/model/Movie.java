package com.firstbit.model;

public class Movie {

	private int movieId;
	private String movieName;
	private String actors;
	private String actresses;
	private String director;
	private float rating;

	public Movie() {
	}

	public Movie(int movieId, String movieName, String actors, String actresses, String director, float rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.actors = actors;
		this.actresses = actresses;
		this.director = director;
		this.rating = rating;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getActresses() {
		return actresses;
	}

	public void setActresses(String actresses) {
		this.actresses = actresses;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", actors=" + actors + ", actresses="
				+ actresses + ", director=" + director + ", rating=" + rating + "]";
	}

}
