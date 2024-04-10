package domain;
import datasource.FileHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    // attribute that holds the movie collection
    private MovieCollection filmListe;
    private FileHandler fileHandler;

    //Constructor initializes the movie collection
    public Controller() {
        fileHandler = new FileHandler();
        filmListe = new MovieCollection(fileHandler.loadMoviesFromFile());

    }

    // Step 3: Add movie use case controller
    public boolean addMovie(String title, String director, int yearCreated,
                            int lengthInMinutes, boolean isInColor, String genre) throws FileNotFoundException {
        return filmListe.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
    }

    // user case 4 getter
    public ArrayList<Movie> showMovieCollection() {
        return filmListe.getFilmListe();
    }

    // getter for movie collection
    public ArrayList<Movie> getMovieCollection() {
        return filmListe.getFilmListe();
    }

    //user case 5 getter
    public ArrayList<Movie> showSearch(String word) {
        return filmListe.movieSearch(word);
    }

    public void editMovie(int i, String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        filmListe.editMovie(i, title, director, year, Color, lengthInMinutes, genre);
    }

    public Movie findOneMovieByIndex(int i) {
        return filmListe.findOneMovieByIndex(i);
    }

    public boolean deleteMovie(String title) {
        return filmListe.deleteMovie(title);
    }

    public void loadMovieFromFile() throws FileNotFoundException {
        fileHandler.loadMoviesFromFile();
    }

    public void saveListOfMovie() throws FileNotFoundException {
        fileHandler.saveListOfMovies(filmListe.getFilmListe());
    }
    public ArrayList<Movie> sortCollectionsByColor() {
        return filmListe.sortCollectionsByColor();
    }
    public ArrayList<Movie> sortCollectionsByDirector() {
        return filmListe.sortCollectionsByDirector();
    }
    public ArrayList<Movie> sortCollectionsByGenre() {
        return filmListe.sortCollectionsByGenre();
    }
    public ArrayList<Movie> sortCollectionsByLength() {
        return filmListe.sortCollectionsByLength();
    }
    public ArrayList<Movie> sortCollectionsByTitel() {
        return filmListe.sortCollectionsByTitel();
    }
    public ArrayList<Movie> sortCollectionsByYear() {
        return filmListe.sortCollectionsByYear();
    }
}


