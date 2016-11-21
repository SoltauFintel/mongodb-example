package de.mwvb.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Krankheit {
	@Id
	private ObjectId id;
	private String bezeichnung;
	@Reference
	private Arzt erforschtDurch;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Arzt getErforschtDurch() {
		return erforschtDurch;
	}

	public void setErforschtDurch(Arzt erforschtDurch) {
		this.erforschtDurch = erforschtDurch;
	}
}
