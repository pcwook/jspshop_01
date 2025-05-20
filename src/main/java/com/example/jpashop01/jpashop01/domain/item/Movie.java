package com.example.jpashop01.jpashop01.domain.item;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
	private String director;
	private String actor;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

}
