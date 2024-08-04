package com.example.bhintunaReview.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service //signifies that the class contains business logic and can be
// injected into other components.
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired// used to automatically inject dependencies into a Spring-managed bean.
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){ //Defines a method
        Review review=reviewRepository.insert(new Review(reviewBody)) ;
        // Creates a new Review object and inserts it into the Review collection in MongoDB.
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;

    }

}