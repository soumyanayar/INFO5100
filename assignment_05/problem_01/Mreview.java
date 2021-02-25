package problem_01;

import java.util.*;
import java.util.stream.Collectors;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private List<Integer> ratings;

    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl, int firstRating) {
        this.title = ttl;
        this.ratings = new ArrayList<Integer>(firstRating);
    }

    public void addRating(int r) {
        this.ratings.add(r);
    }

    public double aveRating() {
        return this.ratings.stream().mapToInt(val -> val).average().orElse(0.0);
    }

    public int compareTo(Mreview obj) {
        if (this == obj) {
            return 0;
        } else if (this.equals(obj)) {
            return 0;
        }
        return this.title.compareTo(obj.title);
    }

    public boolean equals(java.lang.Object obj) {
        return this.title.equals(((Mreview) obj).title);
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public int numRatings() {
        return this.ratings.size();
    }

    public java.lang.String toString() {
        return "Movie Title: " + this.getTitle() + ", average rating" + this.aveRating() + " out of "
                + this.numRatings() + "\nDetailed ratings are: "
                + this.ratings.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}