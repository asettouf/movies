package org.test.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACTOR")
public class Actor implements Model{
	
	public Actor() {
		super();
	}
	public Actor(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	@Id
	@GeneratedValue
	@Column(name="ACTOR_ID")
	private int actorId;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors")
	private Set<Movie> movies = new HashSet<Movie>();
	
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int id) {
		this.actorId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	
}
