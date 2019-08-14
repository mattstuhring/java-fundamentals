package inheritance;

import java.util.ArrayList;

public class Theater {
    public String name;
    public ArrayList<Review> reviews = new ArrayList<>();
    public ArrayList<String> movies = new ArrayList<>();

    public Theater(String name) {
        this.name = name;
    }

    public void addReview(Review review) { reviews.add(review); }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public void removeMovie(String movie) {
        for (String m : movies) {
            if (m.equals(movie)) {
                movies.remove(movie);
            }
        }
    }

    public String toString() {
        return "Welcome to " + this.name + " theater!";
    }
}
