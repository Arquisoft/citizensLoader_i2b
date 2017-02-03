package es.uniovi.asw;

import es.uniovi.asw.user.User;
import es.uniovi.asw.parser.Parser;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	// TODO
	void run(String... args){
		if(args.length == 1){
			Parser parser = new Parser();
			try {
				List<User> users  = parser.loadData(args[0]);
				for(User user :users)
					System.out.println(user);
			} catch (IOException e) {e.printStackTrace();} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
