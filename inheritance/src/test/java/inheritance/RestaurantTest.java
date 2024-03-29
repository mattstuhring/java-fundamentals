package inheritance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void testRestaurantConstructor() {
        Restaurant restaurant = new Restaurant("Restaurant", 1, "$");
        assertEquals("Restaurant is a 1 out of 5 star restaurant, and a price category of $", restaurant.toString());
    }

    @Test
    public void testRestaurantConstructor_outOfBoundsLowStarValue() {
        Restaurant restaurant = new Restaurant("Restaurant", -1, "$$");
        assertEquals("Restaurant is a 0 out of 5 star restaurant, and a price category of $$", restaurant.toString());
    }

    @Test
    public void testRestaurantConstructor_outOfBoundsHighStarValue() {
        Restaurant restaurant = new Restaurant("Restaurant", 6, "$$$");
        assertEquals("Restaurant is a 5 out of 5 star restaurant, and a price category of $$$", restaurant.toString());
    }

    @Test
    public void testRestaurantConstructor_initializeEmptyList() {
        Restaurant restaurant = new Restaurant("Restaurant", 4, "$$");
        assertEquals(new ArrayList<>(), restaurant.reviews);
    }

    @Test
    public void testAddReview() {
        Restaurant restaurant = new Restaurant("Restaurant", 3, "$$");
        Review review = new Review("Average food and service", "Mr. Bill", 3, restaurant);
        restaurant.addReview(review);

        assertEquals("Average food and service, Mr. Bill, 3 star rating", restaurant.reviews.get(0).toString());
    }

    @Test
    public void testAddReview_addMultipleReviews() {
        Restaurant restaurant = new Restaurant("Restaurant", 5, "$$$");
        Review review1 = new Review("Wow the food and service was garbage", "Mr. Jones", 1, restaurant);
        Review review2 = new Review("Average food and service", "Mr. Bill", 3, restaurant);
        Review review3 = new Review("Mind blown!  Excellent food and service", "Mr. Smith", 5, restaurant);
        restaurant.addReview(review1);
        restaurant.addReview(review2);
        restaurant.addReview(review3);

        assertEquals("Mind blown!  Excellent food and service, Mr. Smith, 5 star rating", restaurant.reviews.get(2).toString());
    }

    @Test
    public void testUpdateRestaurantStars_withOneReview() {
        Restaurant restaurant = new Restaurant("Restaurant", 2, "$$");
        Review review = new Review("Wow the food and service was garbage", "Mr. Jones", 1, restaurant);
        restaurant.addReview(review);

        assertEquals(1, restaurant.stars);
    }

    @Test
    public void testUpdateRestaurantStars_withMultipleReviews() {
        Restaurant restaurant = new Restaurant("Restaurant", 2, "$$");
        Review review1 = new Review("Wow the food and service was garbage", "Mr. Jones", 1, restaurant);
        Review review2 = new Review("Average food and service", "Mr. Bill", 3, restaurant);
        Review review3 = new Review("Mind blown!  Excellent food and service", "Mr. Smith", 5, restaurant);
        restaurant.addReview(review1);
        restaurant.addReview(review2);
        restaurant.addReview(review3);

        assertEquals(3, restaurant.stars);
    }
}