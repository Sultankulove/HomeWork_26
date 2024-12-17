package utils;

import models.Movie;

import java.util.List;

public class Search {
    public void searchByExactName(List<Movie> movies, String query) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(query)) {
                System.out.println(movie);
            }
        }
    }

    public void searchByPartialName(List<Movie> movies, String query) {
        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(movie);
            }
        }
    }
}
