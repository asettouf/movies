package org.test.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie implements Model {

	@Id
	@GeneratedValue
	@Column(name = "MOVIE_ID")
	private int movieId;
	@Column
	private String name;
	@Column
	private Date launchDate;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Score score;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "MOVIE_ACTORS", joinColumns = {
			@JoinColumn(name = "movieId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ACTOR_ID", nullable = false) })
	private Set<Actor> actors = new HashSet<Actor>(0);

	public Movie(String name, Date launchDate, Score score) {
		super();
		this.name = name;
		this.launchDate = launchDate;
		this.score = score;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

}
