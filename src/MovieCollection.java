import javax.print.DocFlavor;
import java.util.ArrayList;

public class MovieCollection {

    // an attribute of an empty Arraylist that will store instances of the movie class
    // so a list with a lot of movies on it
    private ArrayList<Movie> filmListe;


    //this constructor initializes the filmListe attributes by creating an empty arraylist movie each time
    // that way we ensure each new MovieCollection object begins empty, that way we can fill each new object with new the input each time
    public MovieCollection() {
        filmListe = new ArrayList<Movie>();

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


    //trying to make a method for user case 5, to search in my movie list.
    //this method is declared with a return type of Movie collection
    //it takes a parameter searchTitle of type String
    public MovieCollection searchMovie(String searchTitle) {
        // a new instance of movieCollection is created named mc, this will be used to store the results
        MovieCollection mc = new MovieCollection();
        // The method iterates through each Movie object in the current MovieCollection (filmListe in my case)
        for (Movie movie : this.filmListe) {
            // For each movie, it checks if the lowercase version of the movie title
            // contains the lowercase version of the search title.
            if (movie.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                //if match is found we add a movie to my new mc movie collections
                mc.filmListe.add(movie);

            }

        }
        if (mc.filmListe.isEmpty()){
            return null;
        }
        else{
            return mc;
        }

    }






}
