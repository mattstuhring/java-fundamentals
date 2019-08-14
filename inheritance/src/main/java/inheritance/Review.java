package inheritance;

public class Review<T> {
    public String body;
    public String author;
    public int stars;
    public T businessType;
    public String movie;

    public Review(String body, String author, int stars) {
        this.body = body;
        this.author = author;
        this.stars = stars;
    }

    public Review(String body, String author, int stars, T businessType) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.businessType = businessType;
    }

    public Review(String body, String author, int stars, Theater theater, String movie) {
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.businessType = (T) theater;
        this.movie = movie;
    }

    public String toString() {
        return this.body + ", " + this.author + ", " + this.stars + " star rating";
    }
}


