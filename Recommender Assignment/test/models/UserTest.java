package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static models.Fixtures.users;

public class UserTest
{
  User homer = new User ("homer", "simpson","homersimpson@mail.com", "male", "24", "bartender");

  @Test
  public void testCreate()
  {
    assertEquals ("homer",               homer.firstName);
    assertEquals ("simpson",             homer.lastName);
    assertEquals ("homersimpson@mail.com", homer.email);
    assertEquals ("male",                homer.gender);   
    assertEquals ("24",                  homer.age);   
    assertEquals ("bartender",           homer.occupation);
  }

  @Test
  public void testIds()
  {
    Set<Long> ids = new HashSet<>();
    for (User user : users)
    {
      ids.add(user.id);
    }
    assertEquals (users.length, ids.size());
  }

  @Test
  public void testToString()
  {
    assertEquals ("User{" + homer.id + ", homer, simpson, homersimpson@mail.com, male, 24, bartender}", homer.toString());
  }
  
  @Test
  public void testEquals()
  {
    User homer2 = new User ("homer", "simpson","homersimpson@mail.com","male", "24", "bartender"); 
    User bart   = new User ("bart", "simpson","bartsimpson@mail.com", "male",  "12","student"); 

    assertEquals(homer, homer);
    assertEquals(homer, homer2);
    assertNotEquals(homer, bart);
  } 
  
}