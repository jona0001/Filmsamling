package datasource;
import domain.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    public void saveListOfMovies(ArrayList<Movie> movies) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(("movies.csv"), true));
        for (Movie movie : movies) {
            out.println(movie.toCSV());
        }
    }

    public void saveOneMovie(Movie movie) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(("movies.csv"), true));
        out.println(movie.toCSV());
    }
    public ArrayList<Movie> loadMoviesFromFile() {
        File moviesDB = new File("movies.csv");
        ArrayList<Movie> moviesFromCSVArr = new ArrayList();
        Scanner sc;
        try {
            sc = new Scanner(moviesDB);
            sc.nextLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(",");
            Movie movie = new Movie(
                    (attributes[0]), // title
                    (attributes[1]), // director
                    (Integer.parseInt(attributes[2])), // year created
                    (Integer.parseInt(attributes[3])), // isInColor
                    (Boolean.parseBoolean(attributes[4])), // length
                    (attributes[5])); // genre
            moviesFromCSVArr.add(movie);
        }
        sc.close();
        return moviesFromCSVArr;
    }
}