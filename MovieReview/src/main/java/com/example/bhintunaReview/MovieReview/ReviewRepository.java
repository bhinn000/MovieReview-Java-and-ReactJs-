package com.example.bhintunaReview.MovieReview;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//Interfaces cannot contain instance fields or constructors.
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}