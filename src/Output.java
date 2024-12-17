import models.Movie;
import models.OutputOfTheEntireJSON;
import utils.FileUtil;

import java.util.*;

public class Output {
    OutputOfTheEntireJSON OutJson = new OutputOfTheEntireJSON( );

    public void OutputJson() {
        OutJson.MoviesOutToList();
    }

    List<Movie> movies = FileUtil.readMovieFileToList();

    public void OutputMoviesName() {
        for (Movie movie : movies) {
            System.out.println("The name of the film: "+ movie.getName());
        }
    }


}
