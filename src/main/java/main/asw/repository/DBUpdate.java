package main.asw.repository;

import main.asw.user.User;

import java.util.List;

public interface DBUpdate {    //TODO decide what to do with DBUpdate and Insert and InsertP

    void insert(List<User> users);

    void writeReport();

}
