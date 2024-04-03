package domain;


public class Movie {
    // mine attributes (fields)
    private String title;
    private String director;
    private int yearCreated;
    private int lengthInMinutes;
    private boolean isInColor;
    private String genre;


    //Constructor,gets called when we make an object, the constructor is called with the provided arguments (values).
    //The constructor assigns these values to the corresponding attributes (fields) of the object.
    public Movie(String title, String director, int yearCreated,
                 int lengthInMinutes, boolean isInColor, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.lengthInMinutes = lengthInMinutes;
        this.isInColor = isInColor;
        this.genre = genre;

    }

    // mine getters, fordi mine attributes er private
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
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(int year) {
        this.yearCreated = year;
    }

    public void setColor(boolean color) {
        isInColor = color;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //a way to override within a class, providing a string representation of an object, in this case a movie
    @java.lang.Override
    public String toString(){
        String result = "";
        result += "\nthe title is " + title + " " + " \nthe director is " + director + " " + "\nthe year the movie is created in is " + yearCreated;

        if (isInColor) {
            result += " " + "\nfilmen er i farve";
        } else {
            result += " " + "\nfilmen er ikke i farve";
        }

        result +=  "\nmovie length is " +lengthInMinutes + "\nthe genre is " + genre;
        return result;
    }

}






