package de.mwvb.database;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.logging.MorphiaLoggerFactory;
import org.mongodb.morphia.logging.slf4j.SLF4JLoggerImplFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * Zugriff auf MongoDB
 * 
 * @author Marcus Warm
 */
public class Database {
	private MongoClient client;
	private Morphia morphia;
	private Datastore ds;
	
	static {
		MorphiaLoggerFactory.registerLogger(SLF4JLoggerImplFactory.class);
	}
	
	/**
	 * Öffnet Datenbank.
	 * 
	 * @param host Name des MongoDB Servers, z.B. "localhost"
	 * @param name Name der MongoDB Datenbank
	 * @param entityClasses Für jedes Package eine Klasse, damit das Package registriert wird.
	 *                      Es muss also NICHT jede Entity Klasse angegeben werden!
	 */
	public Database(String host, String name, Class<?> ... entityClasses) {
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		client = new MongoClient(new ServerAddress(host), credentialsList);
		morphia = new Morphia();
		ds = morphia.createDatastore(client, name);
		for (Class<?> entityClass : entityClasses) {
			morphia.mapPackageFromClass(entityClass);
		}
		ds.ensureIndexes();
	}
	
	public Datastore ds() {
		return ds;
	}
	
	/**
	 * Ist nicht tragisch wenn's nicht aufgerufen wird.
	 */
	public void close() {
		ds = null;
		morphia = null;
		client.close();
		client = null;
	}
}
