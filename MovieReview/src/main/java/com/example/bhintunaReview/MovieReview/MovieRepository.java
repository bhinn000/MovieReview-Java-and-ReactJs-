package com.example.bhintunaReview.MovieReview;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository// interacts with the database
//This interface extends MongoRepository, which provides methods for basic CRUD operations on the Movie entity.
// The Movie entity is identified by an ObjectId and allow to search single only on basis of ObjectId
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    //to search single movies details on basis of imdbId,
    Optional<Movie> findMovieByImdbId(String imdbId);
}