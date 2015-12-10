package controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.LikeMoviesAPI;
import models.Rating;
import models.Movie;
import models.User;
import static models.Fixtures.users;
import static models.Fixtures.movies;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class LikeMoviesAPITest {

	 private LikeMoviesAPI likemovie;

	  @Before
	  public void setup()
	  {
	    likemovie = new LikeMoviesAPI();
	    for (User user : users)
	    {
	      likemovie.addUser(user.firstName, user.lastName, user.email, user.gender, user.age,user.occupation);
	    }
	  }

	  @After
	  public void tearDown()
	  {
		  likemovie = null;
	  }

	  @Test
	  public void testUser()
	  {
	    assertEquals (users.length, likemovie.getUsers().size());
	    likemovie.addUser("homer", "simpson", "homersimpson@mail.com", "male","24", "bartender");
	    assertEquals (users.length+1,likemovie.getUsers().size());
	    assertEquals (users[0], likemovie.getUserByEmail(users[0].email));
	  }  

	  @Test
	  public void testUsers()
	  {
	    assertEquals (users.length, likemovie.getUsers().size());
	    for (User user: users)
	    {
	      User eachUser = likemovie.getUserByEmail(user.email);
	      assertEquals (user, eachUser);
	      assertNotSame(user, eachUser);
	    }
	  }

	  @Test
	  public void testDeleteUsers()
	  {
	    assertEquals (users.length, likemovie.getUsers().size());
	    User marge = likemovie.getUserByEmail("margesimpson@mail.com");
	    likemovie.deleteUser(marge.id);
	    assertEquals (users.length-1, likemovie.getUsers().size());    
	  }  
	  
	  @Test
	  public void testMovies()
	  {
		 assertEquals (movies.length, likemovie.getMovies().size());
		 for (Movie movie: movies)
		 {
			 Movie eachMovie = likemovie.getMovie(movie.id);
			 assertEquals (movie, eachMovie);
			 assertNotSame (movie, eachMovie);
		 }
	  }
	  
	  @Test
	  public void testMovie()
	  {
	    assertEquals (movies.length, likemovie.getMovies().size());
	    likemovie.addMovie("Forrest Gump", "1994", "www.netflix.com");
	    assertEquals (movies.length+1,likemovie.getMovies().size());
	    assertEquals (movies[0], likemovie.getMovieByTitle(movies[0].title));
	  }
}
