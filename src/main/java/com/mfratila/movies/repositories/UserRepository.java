package com.mfratila.movies.repositories;

import com.mfratila.movies.models.ApplicationUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<ApplicationUser, ObjectId> {
    Optional<ApplicationUser> findUserByUsername(String username);
}
