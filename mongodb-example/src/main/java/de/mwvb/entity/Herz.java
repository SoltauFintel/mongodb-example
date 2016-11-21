package de.mwvb.entity;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Herz {
	private int frequenz;
	private int systolischerBlutdruck; // [mmHg]
	private int schlagvolumen; // [cm³]
	private int herzminutenvolumen; // bei Ruhe [cm³]
	private String zustand;
	private String aktualitaet;

	public int getFrequenz() {
		return frequenz;
	}

	public void setFrequenz(int frequenz) {
		this.frequenz = frequenz;
	}

	public int getSystolischerBlutdruck() {
		return systolischerBlutdruck;
	}

	public void setSystolischerBlutdruck(int systolischerBlutdruck) {
		this.systolischerBlutdruck = systolischerBlutdruck;
	}

	public int getSchlagvolumen() {
		return schlagvolumen;
	}

	public void setSchlagvolumen(int schlagvolumen) {
		this.schlagvolumen = schlagvolumen;
	}

	public int getHerzminutenvolumen() {
		return herzminutenvolumen;
	}

	public void setHerzminutenvolumen(int herzminutenvolumen) {
		this.herzminutenvolumen = herzminutenvolumen;
	}

	public String getZustand() {
		return zustand;
	}

	public void setZustand(String zustand) {
		this.zustand = zustand;
	}

	public String getAktualitaet() {
		return aktualitaet;
	}

	public void setAktualitaet(String aktualitaet) {
		this.aktualitaet = aktualitaet;
	}
}
