package es.uniovi.asw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	private final static Logger log = LoggerFactory.getLogger(LoadUsers.class);

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	// TODO
	void run(String... args) {
		log.info("Running");
		log.warn("Not implemented yet");
	}
}
