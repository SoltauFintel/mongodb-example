package de.mwvb;

import java.util.ArrayList;

import org.mongodb.morphia.Datastore;

import de.mwvb.database.Database;
import de.mwvb.entity.Arzt;
import de.mwvb.entity.Erkrankung;
import de.mwvb.entity.Herz;
import de.mwvb.entity.Krankheit;
import de.mwvb.entity.Mensch;

public class Menschen {
	Datastore ds;
	Arzt heberden;
	Arzt schrey;
	Krankheit windpocken;
	
	public static void main(String[] args) {
		System.out.println("Menschen");
		new Menschen().start();
	}
	
	public void start() {
		Database db = new Database("localhost", "mex" /* DB Name */, Mensch.class);
		try {
			ds = db.ds();
			ds.delete(ds.createQuery(Krankheit.class));
			ds.delete(ds.createQuery(Mensch.class));
			
			initDaten();
			
			changePartOfMarcus();
		} finally {
			db.close();
			System.out.println("Ende");
		}
	}

	private void changePartOfMarcus() {
		Mensch marcus = ds.createQuery(Mensch.class).field("vorname").equal("Marcus").get();
		Herz herz = marcus.getHerz();
		herz.setAktualitaet("20161201");
		herz.setFrequenz(60);

		Mensch marcus2 = ds.createQuery(Mensch.class).field("vorname").equal("Marcus").get();

		// TODO save only Herz
		marcus.setErkrankungen(null);
		marcus.setVater(null);
		marcus.setMutter(null);
		ds.merge(marcus);

		marcus2.setGewicht(70);
		marcus2.getHerz().setFrequenz(15);

		marcus2.setHerz(null);
		marcus2.setErkrankungen(null);
		marcus2.setVater(null);
		marcus2.setMutter(null);
		ds.merge(marcus2);

		// Test:
		Mensch t = ds.createQuery(Mensch.class).field("vorname").equal("Marcus").get();
		if (!t.getAktualitaet().equals("20161121")) {
			System.out.println("marcus.aktualitaet falsch => " + t.getAktualitaet());
		}
		if (!t.getNachname().equals("Müller")) {
			System.out.println("marcus.nachname falsch => " + t.getNachname());
		}
		if (t.getErkrankungen() == null) {
			System.out.println("Fehler: keine Erkrankungen!");
			return;
		}
		if (!t.getErkrankungen().get(0).getArt().getBezeichnung().equals("Windpocken")) {
			System.out.println("marcus.erkrankungen[0].art.bezeichnung falsch => " + t.getErkrankungen().get(0).getArt().getBezeichnung());
		}
		if (!t.getGewicht().equals(Integer.valueOf(70))) {
			System.out.println("Gewicht falsch => " + t.getGewicht());
		}
		if (t.getHerz().getFrequenz() != 60) {
			System.out.println("Herz.freq falsch => " + t.getHerz().getFrequenz());
		}
		System.out.println("OK");
	}

	private void initDaten() {
		stammdaten();

		Mensch marcus = new Mensch();
		marcus.setVorname("Marcus");
		marcus.setNachname("Müller");
		marcus.setGeburtsdatum("19800131");
		marcus.setAktualitaet("20161121");
		marcus.setErkrankungen(new ArrayList<Erkrankung>());
		marcus.setWeiblich(false);
		
		Herz herz = new Herz();
		herz.setAktualitaet("20161121");
		herz.setFrequenz(65);
		marcus.setHerz(herz);
		
		Erkrankung wp = new Erkrankung();
		wp.setAktualitaet("20161121");
		wp.setArt(windpocken);
		wp.setDiagnose("Windpocken, 2. Woche, Kinderkrankheit");
		wp.setArzt(schrey);
		marcus.getErkrankungen().add(wp);
		
		ds.save(marcus);
	}

	private void stammdaten() {
		heberden = new Arzt();
		heberden.setVorname("William");
		heberden.setNachname("Heberden");
		heberden.setGeburtsdatum("1710");
		heberden.setFachgebiet("Mediziner");
		heberden.setWeiblich(false);
		ds.save(heberden);
		
		schrey = new Arzt();
		schrey.setNachname("Schrey");
		schrey.setFachgebiet("Kinderarzt");
		schrey.setWeiblich(false);
		ds.save(schrey);

		windpocken = new Krankheit();
		windpocken.setBezeichnung("Windpocken");
		windpocken.setErforschtDurch(heberden);
		ds.save(windpocken);
	}
}
