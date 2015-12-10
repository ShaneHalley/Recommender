package models;

import utils.ToJsonString;

public class Rating {
	private Long userId;
	private Long movieId;
	private int ratingValue;

	public Rating(Long userId, Long movieId, int ratingValue) {
		this.userId = userId;
		this.movieId = movieId;
		this.ratingValue = ratingValue;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	@Override
	public String toString() {
		return new ToJsonString(getClass(), this).toString();
	}

}
