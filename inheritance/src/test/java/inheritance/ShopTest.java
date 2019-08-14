package inheritance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopTest {

    Review review1, review2, review3;

    @Before
    public void setUp() throws Exception {
        review1 = new Review("Wow the food and service was garbage", "Mr. Jones", 1);
        review2 = new Review("Average food and service", "Mr. Bill", 3);
        review3 = new Review("Mind blown!  Excellent food and service", "Mr. Smith", 5);
    }

    @Test
    public void testShopConstructor() {
        Shop shop = new Shop("Big Mart", "Sells cheap stuff", "$");
        assertEquals("Big Mart, Sells cheap stuff, and a price category of $", shop.toString());
    }

    @Test
    public void testShopConstructor_initializeEmptyList() {
        Shop shop = new Shop("Big Mart", "Sells cheap stuff", "$");
        assertEquals(new ArrayList<>(), shop.reviews);
    }

    @Test
    public void testToString() {
        Shop shop = new Shop("Shop", "Sells everything you need", "$$");
        assertEquals("Shop, Sells everything you need, and a price category of $$", shop.toString());
    }

    @Test
    public void testAddReview() {
        Shop shop = new Shop("Shop", "Shop till you drop", "$$");
        Review review = new Review("Average food and service", "Mr. Bill", 3, shop);
        shop.addReview(review);

        assertEquals("Average food and service, Mr. Bill, 3 star rating", shop.reviews.get(0).toString());
    }

    @Test
    public void testAddReview_addMultipleReviews() {
        Shop shop = new Shop("Shop", "Shop till you drop", "$$");
        Review review1 = new Review("Wow the food and service was garbage", "Mr. Jones", 1, shop);
        Review review2 = new Review("Average food and service", "Mr. Bill", 3, shop);
        Review review3 = new Review("Mind blown!  Excellent food and service", "Mr. Smith", 5, shop);
        shop.addReview(review1);
        shop.addReview(review2);
        shop.addReview(review3);

        assertEquals("Mind blown!  Excellent food and service, Mr. Smith, 5 star rating", shop.reviews.get(2).toString());
    }

}