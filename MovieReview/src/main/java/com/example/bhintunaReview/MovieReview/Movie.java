package com.example.bhintunaReview.MovieReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


//whatever begins with '@' , it is annotation
@Document(collection="movies")
@Data
//this takes care of getter and setters
@AllArgsConstructor
//this takes care of constructor
@NoArgsConstructor
public class Movie {

    //@Id will help to inform the Java that it has to be unique
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds; //embedded
}