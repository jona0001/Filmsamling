public class Movie {
    // mine attributes
private String title;
private String director;
private int yearCreated;
private double lengthInMinutes;
private boolean isInColor;
private String genre;


//Constructor
public Movie(String title, String director, int yearCreated,
             double lengthInMinutes, boolean isInColor, String genre){
    this.title = title;
    this.director = director;
    this.yearCreated = yearCreated;
    this.lengthInMinutes = lengthInMinutes;
    this.isInColor = isInColor;
    this.genre = genre;

}
// mine getters, mine attributes er private
    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }
    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public boolean isInColor() {
        return isInColor;
    }


    public String getGenre() {
        return genre;
    }




}
