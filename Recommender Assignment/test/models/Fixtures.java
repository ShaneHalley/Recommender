package models;

public class Fixtures
{
  public static User[] users =
  {
    new User ("marge", "simpson","margesimpson@mail.com", "female",  "30", "housewife"),
    new User ("lisa",  "simpson","lisasimpson@mail.com", "female",   "10", "student"),
    new User ("bart",  "simpson","bartsimpson@mail.com", "male",   "12", "student"),
    new User ("maggie","simpson","maggiesimpson@mail.com", "male", "2", "none")
  };
  
  public static Movie[] movies =
	  {
	  new Movie ("Good Will Hunting", "1997", "www.netflix.com"),
	  new Movie ("Gladiator", "2000", "www.netflix.com"),
	  new Movie ("Forrest Gump", "1994", "www.netflix.com"),
	  new Movie ("Braveheart", "1995", "www.netflix.com"),
	  };
}