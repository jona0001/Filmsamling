package utility;

import domain.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieNameComparatorTest {

    @Test
    void compare() {
        //arrange
        MovieTitleComparator movieNameComparator = new MovieTitleComparator();
        Movie movie1 = new Movie("a", "director", 1998, 88, true, "something");
        Movie movie2 = new Movie("c", "director", 1998, 88, true, "something");
        //act
        int result = movieNameComparator.compare(movie1, movie2);
        int expectedSize = 1;
        //Assert
        assertEquals(expectedSize,result);
    }

}