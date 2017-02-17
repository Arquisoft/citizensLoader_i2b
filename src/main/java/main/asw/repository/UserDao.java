package main.asw.repository;

import main.asw.user.User;

/**
 * Created by MIGUEL on 16/02/2017.
 */
public interface UserDao {

    /**
     * Saves a given user in the database
     *
     * @param u User to be saved
     */
    void saveUser(User u);
}
