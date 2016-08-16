package de.mwvb;

import java.util.Set;

import de.mwvb.dao.WebPageDAO;
import de.mwvb.database.Database;
import de.mwvb.entity.WebPage;

/**
 * MongoDB example application
 * 
 * @author Marcus Warm
 */
public class MongoDBExampleApplication {

	public static void main(String[] args) {
		System.out.println("MongoDB example");
		
		WebPage page = new WebPage();
		page.setUrl("http://www.google.de");
		page.setContent(new WebPageLoader().loadContent(page.getUrl()));
		
		Database db = new Database("localhost", "mex" /* DB Name */, WebPage.class);
		try {
			WebPageDAO dao = new WebPageDAO(db);
			
			// Webseite speichern
			dao.save(page);
			System.out.println("saved --> ID is: " + page.getId());
			
			// WebPage mittels ID laden
			WebPage loaded = dao.get(page.getId());
			if (loaded == null) {
				System.out.println("Fehler beim Laden!");
				return;
			}
			
			// Nach deutschen Websites suchen
			System.out.println("Deutsche Websites:");
			Set<String> urls = dao.findByCountry(".de");
			for (String url : urls) {
				System.out.println(" - " + url);
			}
		} finally {
			db.close();
		}
	}
}
