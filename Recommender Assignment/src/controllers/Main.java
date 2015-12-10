package controllers;

import java.io.File;
import java.util.Collection;

import com.google.common.base.Optional;

import models.Movie;
import models.Rating;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class Main {
	public LikeMoviesAPI likeMovie;

	public Main() throws Exception {
		File datastore = new File("datastore.xml");
		Serializer serializer = new XMLSerializer(datastore);

		likeMovie = new LikeMoviesAPI(serializer);
		if (datastore.isFile()) {
			likeMovie.load();
		}
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();

		Shell shell = ShellFactory.createConsoleShell("pm",
				"Welcome to LikeMovies-console - ?help for instructions", main);
		shell.commandLoop();

		main.likeMovie.store();
	}

	@Command(description = "Get all users details")
	public void getUsers() {
		Collection<User> users = likeMovie.getUsers();
		System.out.println(users);
	}

	@Command(description = "Create a new User")
	public void createUser(@Param(name = "first name") String firstName,
			@Param(name = "last name") String lastName,
			@Param(name = "email") String email,
			@Param(name = "gender") String gender,
			@Param(name = "age") String age,
			@Param(name = "occupation") String occupation) {
		likeMovie.addUser(firstName, lastName, email, gender, age, occupation);
	}

	@Command(description = "Get a Users detail")
	public void getUser(@Param(name = "email") String email) {
		User user = likeMovie.getUserByEmail(email);
		System.out.println(user);
	}

	@Command(description = "Delete a User")
	public void deleteUser(@Param(name = "email") String email) {
		Optional<User> user = Optional.fromNullable(likeMovie
				.getUserByEmail(email));
		if (user.isPresent()) {
			likeMovie.deleteUser(user.get().id);
		}
	}
	
	@Command(description = "Add Movie")
	public void addMovie(@Param(name = "title") String title,
			@Param(name = "year") String year,
			@Param(name = "url") String url)
		 {
		likeMovie.addMovie(title, year, url);
	}
	
	@Command(description = "Get movie by id")
	public void getMovie(@Param(name = "id") Long id) {
		Movie movie = likeMovie.getMovie(id);
		System.out.println(movie);
	}
	
	@Command(description = "Get movie by title")
	public void getMovieByTitle(@Param(name = "title") String  title) {
		Movie movie = likeMovie.getMovieByTitle(title);
		System.out.println(movie);
	}
	/*
	 * @Command(description="Add an activity") public void addActivity
	 * (@Param(name="user-id") Long id, @Param(name="type") String type,
	 * 
	 * @Param(name="location") String location, @Param(name="distance") double
	 * distance) { Optional<User> user =
	 * Optional.fromNullable(likeMovie.getUser(id)); if (user.isPresent()) {
	 * likeMovie.createActivity(id, type, location, distance); } }
	 * 
	 * @Command(description="Add Location to an activity") public void
	 * addLocation (@Param(name="activity-id") Long id,
	 * 
	 * @Param(name="latitude") float latitude, @Param(name="longitude") float
	 * longitude) { Optional<Activity> activity =
	 * Optional.fromNullable(paceApi.getActivity(id)); if (activity.isPresent())
	 * { paceApi.addLocation(activity.get().id, latitude, longitude); } }*
	 */
}