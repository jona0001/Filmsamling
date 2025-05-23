package domain;

import datasource.FileHandler;
import utility.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class MovieCollection {

    // an attribute of an empty Arraylist that will store instances of the movie class
    // so a list with a lot of movies on it
    private ArrayList<Movie> filmListe;
    private FileHandler fileHandler = new FileHandler();

    //this constructor initializes the filmListe attributes by creating an empty arraylist movie each time
    // that way we ensure each new domain.Movie.MovieCollection object begins empty,
    // that way we can fill each new object with new the input each time
    public MovieCollection(ArrayList<Movie> movies) {
        filmListe = movies;
    }

    public MovieCollection() {
    }

    public boolean addMovie(String title, String director, int yearCreated, int lengthInMinutes, boolean isInColor, String genre) throws FileNotFoundException {
        Movie movie = new Movie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
        boolean isAdded = filmListe.add(movie);
        fileHandler.saveOneMovie(movie);
        return isAdded;
    }


    @Override
    public String toString() {
        String result = "";
        for (Movie m : filmListe) {
            result += m.toString();
        }
        return result;
    }

    //getter that allows to get the film list outside of this class
    public ArrayList<Movie> getFilmListe() {
        return filmListe;
    }

    //movie search
    public ArrayList<Movie> movieSearch(String searchMovieInput) {
        ArrayList<Movie> filmSearchMatches = new ArrayList<>();

        for (Movie sm : filmListe) {
            if (sm.getTitle().toLowerCase().contains(searchMovieInput.toLowerCase())) {
                filmSearchMatches.add(sm);
            }
        }
        if (filmSearchMatches.isEmpty()) {
            System.out.println("no match");
        }
        return filmSearchMatches;
    }

    public void editMovie(int i, String title, String director, int year, boolean Color, int lengthInMinutes, String genre) {

        Movie m = filmListe.get(i);
        m.setTitle(title);
        m.setDirector(director);
        m.setYear(year);
        m.setColor(Color);
        m.setLengthInMinutes(lengthInMinutes);
        m.setGenre(genre);
    }


    public Movie findMovieByTitle(String title) {
        for (Movie movie : filmListe) {
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())) {
                return movie;
            }
        }
        return null;
    }

    public Movie findOneMovieByIndex(int index) {
        return filmListe.get(index);
    }

    public boolean deleteMovie(String title) {
        Movie movieToDelete = findMovieByTitle(title);
        boolean isDeleted = false;
        if (movieToDelete != null) {
            isDeleted = filmListe.remove(movieToDelete);
        }
        return isDeleted;
    }


    public void sort(int attribute1, int attribute2){
        Comparator<Movie> comparator; //create the variable
        switch(attribute1){ //initialize the variable by different comparator instances depending on the attribute1
            case 1 -> comparator = new MovieTitleComparator();
            case 2 -> comparator = new MovieDirectorComparator();
            case 3 -> comparator = new MovieYearComparator();
            case 4 -> comparator = new MovieLengthComparator();
            case 5 -> comparator = new MovieColorComparator();
            case 6 -> comparator = new MovieGenreComparator();
            default -> comparator = new MovieTitleComparator(); //must be there so comparator variable always gets initialized
        }

        switch(attribute2){ // chain the second comparator. is not executed if attribute2 is 0
            case 1 -> comparator = comparator.thenComparing(Movie::getTitle);
            case 2 -> comparator = comparator.thenComparing(Movie::getDirector);
            case 3 -> comparator = comparator.thenComparingInt(Movie::getYearCreated);
            case 4 -> comparator = comparator.thenComparingInt(Movie::getLengthInMinutes);
            case 5 -> comparator = comparator.thenComparing(Movie::getIsInColor);
            case 6 -> comparator = comparator.thenComparing(Movie::getGenre);
        }
        filmListe.sort(comparator); // sort by attribute1 (and attribute2 if present)
    }
}

