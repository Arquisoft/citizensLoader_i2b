package main.asw.repository;

import main.asw.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by MIGUEL on 10/02/2017.
 */
public interface UserRepository extends MongoRepository<User, String> {

}
