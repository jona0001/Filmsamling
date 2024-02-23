public class Controller {
    //filmListe: An instance of the MovieCollection class. Essentially, it represents the movie collection.
    private MovieCollection filmListe;



    //The constructor is a special method that gets called when you create an object of the Controller class.
    //In your case, the constructor initializes the filmListe attribute by creating a new MovieCollection object.
    //This ensures that each new Controller object has its own movie collection to work with.
    public Controller() {
        filmListe = new MovieCollection();
    }

    // Inside the method, it call the addMovie() method of the filmListe (which is an instance of MovieCollection).
    //The addMovie() method in MovieCollection creates a new Movie object and adds it to the collection.
    public void addMovie (String title, String director, int yearCreated,
                          double lengthInMinutes, boolean isInColor, String genre){
        filmListe.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);



    }

    public String showMovieCollection (){
        return filmListe.toString();
    }

}

