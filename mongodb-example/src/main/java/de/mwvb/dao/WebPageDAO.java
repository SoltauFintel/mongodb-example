package de.mwvb.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import de.mwvb.database.AbstractDAO;
import de.mwvb.database.Database;
import de.mwvb.entity.WebPage;

public class WebPageDAO extends AbstractDAO<WebPage> {
	
	public WebPageDAO(Database db) {
		super(db);
	}
	
	public Set<String> findByCountry(String tld) {
		List<WebPage> list = ds().createQuery(theClass()).field("url").endsWith(tld).asList();
		Set<String> ret = new TreeSet<String>();
		for (WebPage p : list) {
			ret.add(p.getUrl());
		}
		return ret;
	}
	
	// see http://mongodb.github.io/morphia/1.1/guides/
	
	@Override
	protected Class<WebPage> theClass() {
		return WebPage.class;
	}
}
