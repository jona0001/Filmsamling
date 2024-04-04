package domain;

import java.util.ArrayList;

public class Controller {
    // attribute that holds the movie collection
    private MovieCollection filmListe;
    //Constructor initializes the movie collection
    public Controller() {
        filmListe = new MovieCollection();
    }
    // Step 3: Add movie use case controller
    public boolean addMovie (String title, String director, int yearCreated,
                          int lengthInMinutes, boolean isInColor, String genre){
        return filmListe.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
    }

    // user case 4 getter
    public ArrayList<Movie> showMovieCollection (){
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
    public void editMovie (int i, String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {
        filmListe.editMovie(i, title, director, year, Color, lengthInMinutes, genre);
    }
    public Movie getMovie(int movieNumber) {
        return filmListe.getMovie(movieNumber);
    }
    public void printMovie (int i) {
        filmListe.printMovie(i);
    }

    public void deleteMovie(String title) {
        filmListe.deleteMovie(title);
    }
}

