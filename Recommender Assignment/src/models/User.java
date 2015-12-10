package models;

import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import com.google.common.base.Objects;
import utils.ToJsonString;

public class User {
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public String gender;
	public String age;
	public String occupation;
	static Long counter =  0l;
	
	public List<Rating> ratings = new ArrayList<>();

	public User(String firstName, String lastName, String email, String gender, String age,
			String occupation) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
		this.id = counter++;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public String getAge()
	{
		return age;
	}
	
	public String getOccupation()
	{
		return occupation;
	}
	public String toString() {
		return new ToJsonString(getClass(), this).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id, this.lastName, this.firstName, this.email, this.gender,
				this.age, this.occupation);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof User) {
			final User other = (User) obj;
			return Objects.equal(firstName, other.firstName)
					&& Objects.equal(lastName, other.lastName)
					&& Objects.equal(email, other.email)
					&& Objects.equal(gender, other.gender)
					&& Objects.equal(age, other.age)
					&& Objects.equal(occupation, other.occupation);
		}
		else
		{
			return false;
		}
	}
}