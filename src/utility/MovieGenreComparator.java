package utility;

import domain.Movie;

import java.util.Comparator;

public class MovieGenreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getGenre().compareTo(o2.getGenre());
    }
}
