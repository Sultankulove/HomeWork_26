import models.Movie;
import models.OutputOfTheEntireJSON;
import models.SortMovies;
import utils.FileUtil;
import utils.Search;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Movie> movies = FileUtil.readMovieFileToList();

//        Output output = new Output();
//        output.OutputMoviesName();
//        System.out.println("Искать фильмы: ");
//        System.out.println("a - по полному совпадению");
//        System.out.println("b - по частичному совпадению");
//
//        Scanner sc = new Scanner(System.in);
//        String searchMovie = sc.nextLine();
//        Search search = new Search();
//        String searchNameInput;
//        switch (searchMovie.toLowerCase()) {
//            case "a": {
//                System.out.println("Введите полное название фильмы: ");
//                searchNameInput = sc.nextLine().toLowerCase();
//                search.searchByExactName(movies,searchNameInput);
//                break;
//            }
//            case "b": {
//                System.out.println("Введите частичное название фильмы: ");
//                searchNameInput = sc.nextLine().toLowerCase();
//                search.searchByPartialName(movies, searchNameInput);
//                break;
//            }
//            default: {
//                System.out.println("Ведите заново");
//
//            }
//        }

        SortMovies sm = new SortMovies();
        sm.getSortMovies();
    }
}