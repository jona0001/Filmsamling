package domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

    void saveListOfMovies() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(("movies.csv"), true));
        for (Movie movie : filmListe) {
            out.println(movie.toCSV());
        }
    }

    public ArrayList<Movie> loadMovieFromFile() {
        File moviesDB = new File("movies.csv");
        ArrayList<Movie> moviesFromCSVArr = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(moviesDB);
            sc.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Movie addMovieToDB = null;
        while (sc.hasNext()) {
            String[] attributes = sc.nextLine().split(",");
            addMovieToDB = new Movie(
                (attributes[0]), // title
                (attributes[1]), // director
                (Integer.parseInt(attributes[2])), // year created
                (Integer.parseInt(attributes[3])), // isInColor
                (Boolean.parseBoolean(attributes[4])), // length
                (attributes[5])); // genre

                filmListe.add(addMovieToDB);
        }
        sc.close();
        return moviesFromCSVArr;
    }
}

