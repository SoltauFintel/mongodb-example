package de.mwvb.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Mensch {
	@Id
	private ObjectId id;
	private boolean weiblich;
	private String vorname;
	private String nachname;
	private String geburtsdatum; // JJJJMMTT
	private Integer gewicht; // [kg]
	private Herz herz;
	@Reference
	private Mensch vater;
	@Reference
	private Mensch mutter;
	private List<Erkrankung> erkrankungen;
	private String aktualitaet;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public boolean isWeiblich() {
		return weiblich;
	}

	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Integer getGewicht() {
		return gewicht;
	}

	public void setGewicht(Integer gewicht) {
		this.gewicht = gewicht;
	}

	public Herz getHerz() {
		return herz;
	}

	public void setHerz(Herz herz) {
		this.herz = herz;
	}

	public Mensch getVater() {
		return vater;
	}

	public void setVater(Mensch vater) {
		this.vater = vater;
	}

	public Mensch getMutter() {
		return mutter;
	}

	public void setMutter(Mensch mutter) {
		this.mutter = mutter;
	}

	public List<Erkrankung> getErkrankungen() {
		return erkrankungen;
	}

	public void setErkrankungen(List<Erkrankung> erkrankungen) {
		this.erkrankungen = erkrankungen;
	}

	public String getAktualitaet() {
		return aktualitaet;
	}

	public void setAktualitaet(String aktualitaet) {
		this.aktualitaet = aktualitaet;
	}
}
