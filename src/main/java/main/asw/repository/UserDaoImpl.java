package main.asw.repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import main.asw.user.User;
import org.bson.Document;

/**
 * Created by MIGUEL on 16/02/2017.
 */
public class UserDaoImpl implements UserDao {

    //TODO: Maybe take this configuration out of here and receive connection from outside
    //so I can test this with the testing DB running this code for more coverage.
    private static MongoClient mongoClient = new MongoClient("localhost", 27017);
    private static MongoDatabase db = mongoClient.getDatabase("aswdb");
    private static MongoCollection<Document> coll = db.getCollection("user");

    /**
     * Saves a given user in the database
     *
     * @param u User to be saved
     */
    @Override
    public void saveUser(User u) {
        Document doc = new Document("name", u.getFirstName())
                .append("surname", u.getLastName())
                .append("email", u.getEmail())
                .append("address", u.getAddress())
                .append("nationality", u.getNationality())
                .append("dni", u.getNif())
                .append("date", u.getDateOfBirth())
                .append("password", u.getPassword());
        coll.insertOne(doc);
    }
}
