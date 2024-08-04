package com.example.bhintunaReview.MovieReview;

//This class handles HTTP requests related to movies. It uses the MovieService to get the list of movies.

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired //  This annotation allows Spring to automatically inject an instance of the MovieService class into this controller.
    private MovieService movieService;

    @GetMapping //This annotation maps HTTP GET requests to the getAllMovies method
    public ResponseEntity<List<Movie>> getAllMovies(){

        // ResponseEntity<List<Movie>> :Spring class used to represent the entire HTTP response
        // ResponseEntity<T> is a generic class, <T> specifies the type of data it will hold.
        // Here, ResponseEntity will hold a list of movies.
        //  handles the GET request ; returns a list of movies using MovieService ,
        //List<Movie> : it means list of object named Movie

        //  wraps it in a ResponseEntity with an HTTP status of OK.
        return new ResponseEntity<List<Movie>>(movieService.allMovies() , HttpStatus.OK);
    }

    //to get move details o the basis of objectId
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

    //to get move details o the basis of imdbId
    @GetMapping("/imdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId ){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
    }




}