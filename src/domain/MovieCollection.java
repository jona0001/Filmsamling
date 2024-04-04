package domain;

import java.util.ArrayList;

public class MovieCollection {
    // an attribute of an empty Arraylist that will store instances of the movie class
    // so a list with a lot of movies on it
    private ArrayList<Movie> filmListe;

    //this constructor initializes the filmListe attributes by creating an empty arraylist movie each time
    // that way we ensure each new domain.Movie.MovieCollection object begins empty,
    // that way we can fill each new object with new the input each time
    public MovieCollection() {
        filmListe = new ArrayList<>();
    }

    public boolean addMovie(String title, String director, int yearCreated, int lengthInMinutes, boolean isInColor, String genre) {
        Movie movie = new Movie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
        boolean isAdded = filmListe.add(movie);
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

    //getter that allows me to get the film list outside of this class
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


    public Movie getMovie(int movieNumber) {
        return filmListe.get(movieNumber);
    }

    public void printMovie(int i) {
        if (i < filmListe.size() && i >= 0) {
            System.out.println(filmListe.get(i));
        } else {
            System.out.println("Venligst indtast et nummer mellem 0 " + "og " + filmListe.size());
        }
    }

    public Movie findMovieByTitle(String title) {
        for (Movie movie : filmListe) {
            if (movie.getTitle().toUpperCase().contains(title.toUpperCase())) {
                return movie;
            }
        }
        return null;
    }

    public void deleteMovie(String title) {
        Movie movieToDelete = findMovieByTitle(title);
        if (movieToDelete != null) {
            filmListe.remove(movieToDelete);
        } else {
            System.out.println("Movie not found!");
        }
    }

}

