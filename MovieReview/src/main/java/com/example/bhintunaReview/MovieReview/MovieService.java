
package com.example.bhintunaReview.MovieReview;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Services contain business logic and interact with repositories.
public class MovieService {

    @Autowired  //Services contain business logic and interact with repositories.
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
//        System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }
//    returns a list of all movies by calling the findAll method on the MovieRepository

    //return a movie, on basis of ObjectId
    public Optional<Movie> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> singleMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
