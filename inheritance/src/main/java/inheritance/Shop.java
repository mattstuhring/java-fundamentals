package inheritance;

import java.util.ArrayList;

public class Shop {
    public String name;
    public String description;
    public String price;
    public ArrayList<Review> reviews = new ArrayList<>();

    public Shop(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public String toString() {
        return this.name + ", " + this.description + ", and a price category of " + this.price;
    }
}
