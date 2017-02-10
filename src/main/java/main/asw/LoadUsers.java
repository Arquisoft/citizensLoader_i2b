package main.asw;

import main.asw.user.User;
import main.asw.parser.Parser;

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


	void run(String... args){
		if(args.length == 1){
			try {
				Parser parser = new Parser(args[0]);
				List<User> users  = parser.loadData();
				for(User user :users)
					System.out.println(user);
			} catch (IOException e) {e.printStackTrace();} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
