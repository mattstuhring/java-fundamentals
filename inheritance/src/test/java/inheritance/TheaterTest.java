package inheritance;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TheaterTest {

    @Test
    public void testConstructor() {
        Theater theater = new Theater("Majestic");
        assertEquals("Welcome to Majestic theater!", theater.toString());
    }

    @Test
    public void testToString() {
        Theater theater = new Theater("Premier");
        assertEquals("Welcome to Premier theater!", theater.toString());
    }

    @Test
    public void testAddMovie() {
        Theater theater = new Theater("Big Time");
        theater.addMovie("Jumanji");
        assertEquals("Jumanji", theater.movies.get(0));
    }

    @Test
    public void testAddMovie_multipleMovies() {
        Theater theater = new Theater("Big Time");
        theater.addMovie("Jumanji");
        theater.addMovie("Die Hard");
        theater.addMovie("Hackers");
        assertEquals("Hackers", theater.movies.get(2));
    }

    @Test
    public void testRemoveMovie() {
        Theater theater = new Theater("Big Time");
        theater.addMovie("Jumanji");
        theater.addMovie("Die Hard");
        theater.addMovie("Hackers");
        theater.removeMovie("Die Hard");

        assertEquals("[Jumanji, Hackers]", theater.movies.toString());
    }

    @Test
    public void testAddReview() {
        Theater theater = new Theater("Majestic");
        Review review = new Review("Average food and service", "Mr. Bill", 3, theater);
        theater.addReview(review);

        assertEquals("Average food and service, Mr. Bill, 3 star rating", theater.reviews.get(0).toString());
    }

    @Test
    public void testAddReview_addMultipleReviews() {
        Theater theater = new Theater("Majestic");
        Review review1 = new Review("Wow the food and service was garbage", "Mr. Jones", 1, theater);
        Review review2 = new Review("Average food and service", "Mr. Bill", 3, theater);
        Review review3 = new Review("Mind blown!  Excellent food and service", "Mr. Smith", 5, theater);
        theater.addReview(review1);
        theater.addReview(review2);
        theater.addReview(review3);

        assertEquals("Mind blown!  Excellent food and service, Mr. Smith, 5 star rating", theater.reviews.get(2).toString());
    }

    @Test
    public void testTheaterReviewConstructor_withMovieName() {
        Theater theater = new Theater("Amaze");
        Review review = new Review("Wow the food and service was garbage", "Mr. Jones", 1, theater, "Jumanji");
        assertEquals("Jumanji", review.movie);
    }

    @Test
    public void testTheaterReviewConstructor_withNoMovieName() {
        Theater theater = new Theater("Amaze");
        Review review = new Review("Wow the food and service was garbage", "Mr. Jones", 1, theater);
        assertNull("Movie name in Theater review should NOT exist", review.movie);
    }
}