package main.asw.repository;

import main.asw.user.User;

public interface DBUpdate {

	void insert(User user);
	
	void writeReport();
	
}
