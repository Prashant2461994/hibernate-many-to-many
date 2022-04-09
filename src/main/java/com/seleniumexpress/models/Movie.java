package com.seleniumexpress.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "movie_name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "movies_actors", 
	         joinColumns =  
	        		 @JoinColumn(name = "movie_id") , 
	         inverseJoinColumns = 
			      @JoinColumn(name = "actor_id") )
	private List<Actor> actors;

	public List<Actor> getActors() {
		return actors;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addActor(Actor actor) {
		
		if(actors==null) {
			actors= new ArrayList<Actor>();
			actors.add(actor);
		}
	}

}
