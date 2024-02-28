import java.util.ArrayList;

public class MovieCollection {



    // an attribute of an empty Arraylist that will store instances of the movie class
    // so a list with a lot of movies on it
    public ArrayList<Movie> filmListe;


    //this constructor initializes the filmListe attributes by creating an empty arraylist movie each time
    // that way we ensure each new MovieCollection object begins empty, that way we can fill each new object with new the input each time
    public MovieCollection() {
        filmListe = new ArrayList<>();
        filmListe.add(new Movie("java_games", "Jonathan", 2024, 20000, true, "action"));
        filmListe.add(new Movie("Java", "Jonathan", 2025, 20000, true, "horror"));


    }


    //Method inside this method we create a new object to add to our filmListe
    // here we tell what parameter add movie should consist of and inside the method there is created a new movie object.
    public void addMovie(String title, String director, int yearCreated, double lengthInMinutes, boolean isInColor, String genre) {
        Movie movie = new Movie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
        filmListe.add(movie);
    }


    // this toString() method generates a string representation of all the movies in the filmList. When you call toString()
    // on an instance of the containing class, it will display information about each movie in the list.
    // in the for loop we go through each movie (filmList) stored in the class Movie.
    // user story 4
    @java.lang.Override
    public String toString() {
        String result = "";
        for (Movie m : filmListe) {
            result += m.toString();

        }
        return result;
    }

    //getter that allows me to get the movies outside of this class
    public ArrayList<Movie> getFilmListe() {
        return filmListe;
    }


    //
    public String movieSearch(String searchMovieInput) {
        String filmSearchMatches = "";

        for (Movie sm : filmListe) {
            if (sm.getTitle().toLowerCase().contains(searchMovieInput)) {
                filmSearchMatches += "\n" + sm.toString();
            }
        }
        if (filmSearchMatches.isEmpty()) {
            return "\nintet match";
        }

        return filmSearchMatches;

    }




}

