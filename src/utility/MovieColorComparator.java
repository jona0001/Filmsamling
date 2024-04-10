package utility;

import domain.Movie;

import java.util.Comparator;

public class MovieColorComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Boolean.compare(o1.getIsInColor(),o2.getIsInColor());
    }
}
