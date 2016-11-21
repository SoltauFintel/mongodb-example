package de.mwvb.entity;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class Arzt extends Mensch {
	private String fachgebiet;

	public String getFachgebiet() {
		return fachgebiet;
	}

	public void setFachgebiet(String fachgebiet) {
		this.fachgebiet = fachgebiet;
	}
}
