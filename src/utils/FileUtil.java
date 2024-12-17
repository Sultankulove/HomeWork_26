package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Movie;
import models.MovieContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileUtil {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static List<Movie> readMovieFileToList() {
        try {
            String str = Files.readString(Paths.get("src/data/movies.json"));
            MovieContainer container = GSON.fromJson(str, MovieContainer.class);

            return container.getMovies();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
