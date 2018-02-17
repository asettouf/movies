package org.test.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SCORE")
public class Score implements Model{

	public Score() {
		super();
	}

	@Id
	@GeneratedValue
	private int id;
	@Column
	private int score;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="score")
	private Movie movie;

	public Score(int value) {
		super();
		this.score = value;
	}

	public Score(int id, int value) {
		super();
		this.id = id;
		this.score = value;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", value=" + score + "]";
	}

	public int getScore() {
		return score;
	}

	public void setScore(int value) {
		this.score = value;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
