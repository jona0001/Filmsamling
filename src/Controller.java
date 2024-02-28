import java.util.ArrayList;

public class Controller {
    // attribute that holds the movie collection
    private MovieCollection filmListe;
    //Constructor initializes the movie collection
    public Controller() {
        filmListe = new MovieCollection();
    }

    // Step 3: Add movie use case controller
    public void addMovie (String title, String director, int yearCreated,
                          double lengthInMinutes, boolean isInColor, String genre){
        filmListe.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
    }

    // user case 4 getter
    public String showMovieCollection (){
        return filmListe.toString();
    }


    // getter for movie collection
    public ArrayList<Movie> getMovieCollection() {
        return filmListe.getFilmListe();
    }

    //user case 5 getter
    public String showSearch(String word) {
        return filmListe.movieSearch(word);
    }










}

