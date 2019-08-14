package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {

    @Test
    public void testToString() {
        Review review = new Review("Best meal of my life", "Mr. Jones", 5);
        assertEquals("Best meal of my life, Mr. Jones, 5 star rating", review.toString());
    }

    @Test
    public void testReviewConstructor_restaurant() {
        Restaurant restaurant = new Restaurant("Restaurant", 6, "$$$");
        Review review = new Review("Best meal of my life", "Mr. Jones", 5);

        System.out.println(review.toString());
    }

    @Test
    public void testReviewConstructor_shop() {

    }

    @Test
    public void testReviewConstructor_theater() {

    }
}