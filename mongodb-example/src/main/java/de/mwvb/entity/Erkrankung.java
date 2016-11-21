package de.mwvb.entity;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class Erkrankung {
	@Reference
	private Krankheit art;
	private String diagnose;
	private String behandlung;
	@Reference
	private Arzt arzt;
	private String aktualitaet;

	public Krankheit getArt() {
		return art;
	}

	public void setArt(Krankheit art) {
		this.art = art;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getBehandlung() {
		return behandlung;
	}

	public void setBehandlung(String behandlung) {
		this.behandlung = behandlung;
	}

	public Arzt getArzt() {
		return arzt;
	}

	public void setArzt(Arzt arzt) {
		this.arzt = arzt;
	}

	public String getAktualitaet() {
		return aktualitaet;
	}

	public void setAktualitaet(String aktualitaet) {
		this.aktualitaet = aktualitaet;
	}
}
