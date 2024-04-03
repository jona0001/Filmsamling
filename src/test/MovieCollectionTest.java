package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    @Test
    void addMovie() {
        //arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("javatest", "Jonathan", 2005, 200, true, "horror");
        //act
        int expectedResult = 1;
        int actualResult = movieCollection.filmListe.size();
        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getFilmListe() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("javaGame", "Jonathan", 2024, 20000, true, "action");
        movieCollection.addMovie("JavaHunt", "Jonathan", 2025, 20000, true, "horror");
        movieCollection.getFilmListe(); //?
        // Act
        movieCollection.getFilmListe();
        int expectedNumberOfMovies = 2;
        int actualNumberOfMovies = movieCollection.filmListe.size();
        //assert
        Assertions.assertEquals(expectedNumberOfMovies, actualNumberOfMovies);
    }

    @Test
    void testToString() {
    }
    @Test
    void movieSearch () {
    }
}