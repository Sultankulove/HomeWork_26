package models;

import utils.FileUtil;
import utils.ReturnMovieList;

import java.util.List;

public class OutputOfTheEntireJSON {

//    ReturnMovieList returnMovieList = new ReturnMovieList();

        List<Movie> movies = FileUtil.readMovieFileToList();

    public void MoviesOutToList() {
    if(movies.isEmpty()) {
        System.out.println("No movies found!");
    } else {
        System.out.println("Movies in the collection:");
        System.out.println("==========================");
    }

    movies.forEach(System.out::println);
    System.out.println("==========================");


    }

}
