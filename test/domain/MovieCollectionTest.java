package domain;

import domain.MovieCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieCollectionTest {

    @Test
    void addMovie() throws FileNotFoundException {
        //arrange
        MovieCollection movieCollection = new MovieCollection(new ArrayList<>());
        boolean isAdded = movieCollection.addMovie("javatest", "Jonathan", 2005, 200, true, "horror");
        //act
        int expectedResult = 1;
        int actualResult = movieCollection.getFilmListe().size();

        //assert
        assertEquals(expectedResult, actualResult);
        assertTrue(isAdded);
    }

    @Test
    void getFilmListe() throws FileNotFoundException {
        //Arrange
        MovieCollection movieCollection = new MovieCollection(new ArrayList<>());
        movieCollection.addMovie("javaGame", "Jonathan", 2024, 20000, true, "action");
        movieCollection.addMovie("JavaHunt", "Jonathan", 2025, 20000, true, "horror");
        // Act
        ArrayList<Movie> filmListe = movieCollection.getFilmListe();
        int expectedNumberOfMovies = 2;
        int actualNumberOfMovies = filmListe.size();
        //assert
        Assertions.assertEquals(expectedNumberOfMovies, actualNumberOfMovies);
    }

    @Test
    void findAllMovies() throws FileNotFoundException {
        //Arrange
        String title = "Title";
        String director = "Director";
        int yearCreated = 1998;
        boolean isInColor = true;
        int lengthInMinutes = 88;
        String genre = "Genre";

        String title2 = "Title2";
        String director2 = "Director2";
        int yearCreated2 = 2005;
        boolean isInColor2 = false;
        int lengthInMinutes2 = 120;
        String genre2 = "Genre2";

        String title3 = "Title3";
        String director3 = "Director3";
        int yearCreated3 = 2015;
        boolean isInColor3 = true;
        int lengthInMinutes3 = 130;
        String genre3 = "Genre3";

        MovieCollection movieCollection = new MovieCollection(new ArrayList<>());

        movieCollection.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
        movieCollection.addMovie(title2, director2, yearCreated2, lengthInMinutes2, isInColor2, genre2);
        movieCollection.addMovie(title3, director3, yearCreated3, lengthInMinutes3, isInColor3, genre3);

        //Act
        ArrayList<Movie> movies = movieCollection.getFilmListe();
        int actualSize = movies.size();
        int expectedSize = 3;

        //Assert
        assertEquals(expectedSize, actualSize);
        for(Movie movie : movies){
            System.out.println(movie);
        }

    }

    @Test
    void searchMoviesByTitle() throws FileNotFoundException {
        //Arrange
        String title = "Title";
        String director = "Director";
        int yearCreated = 1998;
        boolean isInColor = true;
        int lengthInMinutes = 88;
        String genre = "Genre";

        String title2 = "Title2";
        String director2 = "Director2";
        int yearCreated2 = 2005;
        boolean isInColor2 = false;
        int lengthInMinutes2 = 120;
        String genre2 = "Genre2";

        String title3 = "Title3";
        String director3 = "Director3";
        int yearCreated3 = 2015;
        boolean isInColor3 = true;
        int lengthInMinutes3 = 130;
        String genre3 = "Genre3";

        MovieCollection movieCollection = new MovieCollection(new ArrayList<>());

        movieCollection.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
        movieCollection.addMovie(title2, director2, yearCreated2, lengthInMinutes2, isInColor2, genre2);
        movieCollection.addMovie(title3, director3, yearCreated3, lengthInMinutes3, isInColor3, genre3);

        //Act
        ArrayList<Movie> foundMovie = movieCollection.movieSearch("title");
        int actualSize = foundMovie.size();
        int expectedSize = 3;

        //Assert
        assertEquals(expectedSize, actualSize);
    }
}