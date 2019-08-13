package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    public int stars; // 0 - 5
    public String price; // $-$$$
    public List<Review> reviews = new ArrayList<>();

    public Restaurant(String name, int stars, String price) {
        this.name = name;

        if (stars > 5) {
            this.stars = 5;
        } else if (stars < 0) {
            this.stars = 0;
        } else {
            this.stars = stars;
        }

        this.price = price;
    }

    public String toString() {
        return this.name + " is a " + this.stars + " out of 5 star restaurant, and a price category of " + this.price;
    }

    public void addReview(Review review) {
        // add new review to reviews list
        reviews.add(review);

        // update restaurant stars
        int sum = 0;
        for (Review rev : reviews) {
            sum += rev.stars;
        }

        // calculate the average stars and set the value
        this.stars = sum / reviews.size();
    }


}
