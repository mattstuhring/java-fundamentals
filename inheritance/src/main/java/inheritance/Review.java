package inheritance;

public class Review {
    public String body;
    public String author;
    public int stars;
    public Restaurant restaurant;

    public Review(String body, String author, int stars) {
        this.body = body;
        this.author = author;
        this.stars = stars;
    }

    public String toString() {
        return this.body + ", " + this.author + ", " + this.stars + " star rating";
    }
}


