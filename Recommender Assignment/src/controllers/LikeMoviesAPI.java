package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import utils.Serializer;
import models.Movie;
import models.User;

public class LikeMoviesAPI {

	private Map<Long, User> userIndex = new HashMap<>();
	private Map<String, User> emailIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private Map<String, Movie> movieTitleIndex = new HashMap<>();
	private Serializer serializer;

	LikeMoviesAPI() {
	}

	public LikeMoviesAPI(Serializer serializer) {
		this.serializer = serializer;
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
        movieIndex = (Map<Long, Movie>) serializer.pop();
        movieTitleIndex = (Map<String, Movie>) serializer.pop();
		emailIndex = (Map<String, User>) serializer.pop();
		userIndex = (Map<Long, User>) serializer.pop();
	}

	public void store() throws Exception {
		serializer.push(userIndex);
		serializer.push(emailIndex);
		serializer.push(movieIndex);
		serializer.push(movieTitleIndex);
		serializer.write();
	}

	public User addUser(String firstName, String lastName, String email,
			String gender, String age, String occupation) {
		User user = new User(firstName, lastName, email, gender, age,
				occupation);
		userIndex.put(user.id, user);
		emailIndex.put(email, user);
		return user;
	}

	public User getUser(Long id) {
		return userIndex.get(id);
	}

	public User getUserByEmail(String email) {
		return emailIndex.get(email);
	}

	public void deleteUser(Long id) {
		User user = userIndex.remove(id);
		emailIndex.remove(user.email);
	}

	public void deleteUsers() {
		userIndex.clear();
		emailIndex.clear();
	}

	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
		movieTitleIndex.put(title, movie);
		return movie;
	}

	public Movie getMovie(Long id) {
		return movieIndex.get(id);
	}

	public Movie getMovieByTitle(String title) {
		return movieTitleIndex.get(title);
	}

	public Collection<User> getUsers() {
		return userIndex.values();
	}

	public Collection<User> getEmail() {
		return emailIndex.values();
	}

	public Collection<Movie> getMovies() {
		return movieIndex.values();
	}
}
