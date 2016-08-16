package de.mwvb.database;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

/**
 * Allgemeingültige DAO Methoden
 * 
 * @author Marcus Warm
 */
public abstract class AbstractDAO<T> {
	private final Datastore _ds;
	
	public AbstractDAO(Database db) {
		this._ds = db.ds();
	}
	
	public void save(T e) {
		ds().save(e);
	}
	
	public T get(ObjectId id) {
		return ds().get(theClass(), id);
	}
	
	public void delete(T e) {
		ds().delete(e);
	}

	protected abstract Class<T> theClass();
	
	protected final Datastore ds() {
		return _ds;
	}
}
