package main.asw.repository;

import main.asw.user.User;

public interface DBUpdate {	//TODO decide what to do with DBUpdate and Insert and InsertP

	void insert(User user);
	
	void writeReport();
	
}
