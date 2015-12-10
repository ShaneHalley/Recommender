package models;

import java.lang.Object;
import java.util.ArrayList;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import com.google.common.base.Objects;

import utils.ToJsonString;

public class Movie {

	static Long counter = 0l;
	public Long id;

	public String title;
	public String year;
	public String url;
	private ArrayList<Rating> ratings = new ArrayList<>();

	public Movie(String title, String year, String url) {
		this.id = counter++;
		this.title = title;
		this.year = year;
		this.url = url;
	}

	@Override
	public String toString() {
		return new ToJsonString(getClass(), this).toString();
	}

	public int hashcode() {
		return Objects.hashCode(this.id, this.title, this.year, this.url);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Movie) {
			final Movie other = (Movie) obj;
			return Objects.equal(title, other.title)
					&& Objects.equal(year, other.year)
					&& Objects.equal(url, other.url);
		} else {
			return false;
		}
	}

}
