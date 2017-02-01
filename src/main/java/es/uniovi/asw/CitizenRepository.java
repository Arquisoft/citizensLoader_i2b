package es.uniovi.asw;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jorge on 01/02/2017.
 */
public interface CitizenRepository extends MongoRepository<Citizen, String> {

}
