package datasource;
import domain.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    Controller controller = new Controller();
    public void saveListOfMovies() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(("movies.csv"), true));
        for (Movie movie : controller.addMovie()) {
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

            controller.add(addMovieToDB);
        }
        sc.close();
        return moviesFromCSVArr;
    }
}
