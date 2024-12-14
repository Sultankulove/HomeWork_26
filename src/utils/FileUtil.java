package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Movie;
import models.MovieContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static Movie[] readMovieFile() {

        try {
            String str = Files.readString(Paths.get("src/data/movies.json"));

            MovieContainer container = GSON.fromJson(str, MovieContainer.class);

            return container.getMovies().toArray(new Movie[0]);
        } catch (IOException e) {

            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();

        }

        return new Movie[0];
    }
}
