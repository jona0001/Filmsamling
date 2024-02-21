public class MovieCollection {

    private Movie[] filmListe;
    int count = 0;

    public MovieCollection() {
        this.filmListe = new Movie[4];
    }

    //metode der tilføjer en ny film.
    public void tilFøjMovie(String title, String director, int yearCreated,
    double lengthInMinutes, boolean isInColor, String genre) {
        filmListe[count ++] = new Movie(title,director,yearCreated,
                lengthInMinutes, isInColor , genre);
    }
    public Movie [] getFilmListe(){
        return filmListe;
    }



}
