package utils;

import models.Cast;
import models.Movie;

import java.util.*;

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

    public Map<String, Set<String>> actorRolesMap = new HashMap<>();
    Map<Integer, List<Movie>> yearMoviesMap = new HashMap<>();
    Map<String, List<Movie>> directorMoviesMap = new HashMap<>();
    Map<String, List<Movie>> actorMoviesMap = new HashMap<>();




    public void searchMoviesByActor(String actorName) {
        List<Movie> movies = actorMoviesMap.getOrDefault(actorName, Collections.emptyList());
        if (movies.isEmpty()) {
            System.out.println("Фильмы с актёром " + actorName + " не найдены.");
        } else {
            movies.forEach(System.out::println);
        }
    }

    public void searchMoviesByDirector(String directorName) {
        List<Movie> movies = directorMoviesMap.getOrDefault(directorName, Collections.emptyList());
        if (movies.isEmpty()) {
            System.out.println("Фильмы режиссёра " + directorName + " не найдены.");
        } else {
            movies.forEach(System.out::println);
        }
    }

    public void searchMoviesByYear(int year) {
        List<Movie> movies = yearMoviesMap.getOrDefault(year, Collections.emptyList());
        if (movies.isEmpty()) {
            System.out.println("Фильмы, выпущенные в " + year + " году, не найдены.");
        } else {
            movies.forEach(System.out::println);
        }
    }

    public void searchRolesByActor(String actorName) {
        Set<String> roles = actorRolesMap.getOrDefault(actorName, Collections.emptySet());
        if (roles.isEmpty()) {
            System.out.println("Роли актёра " + actorName + " не найдены.");
        } else {
            System.out.println("Роли актёра " + actorName + ": " + roles);
        }
    }

//    public void displayAllActors() {
//        List<String> actors = new ArrayList<>(actorRolesMap.keySet());
//        Collections.sort(actors);
//
//        actors.forEach(System.out::println);
////        for (String actor : actors) {
////            System.out.println(actor);
////        }
//    }


    public void sortMovies(List<Movie> movies, Comparator<Movie> comparator) {
        movies.sort(comparator);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }


    Movie movie = new Movie();
    Cast cast = new Cast();

    public void initializeMaps(List<Movie> movies) {
        for (Movie movie : movies) {
            for (Cast cast : movie.getCast()) {
                String actorName = cast.getFullName();

                if (!actorMoviesMap.containsKey(actorName)) {
                    actorMoviesMap.put(actorName, new ArrayList<Movie>());
                }
                actorMoviesMap.get(actorName).add(movie);

                if (!actorRolesMap.containsKey(actorName)) {
                    actorRolesMap.put(actorName, new HashSet<String>());
                }
                actorRolesMap.get(actorName).add(cast.getRole());
            }

            String directorName = movie.getDirector().getFullName();
            if (!directorMoviesMap.containsKey(directorName)) {
                directorMoviesMap.put(directorName, new ArrayList<Movie>());
            }
            directorMoviesMap.get(directorName).add(movie);

            int year = movie.getYear();
            if (!yearMoviesMap.containsKey(year)) {
                yearMoviesMap.put(year, new ArrayList<Movie>());
            }
            yearMoviesMap.get(year).add(movie);
        }
    }


}