package models;

import utils.FileUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortMoviesTest {

    public void getSortMovies() {
        List<Movie> movies = FileUtil.readMovieFileToList();
        System.out.println("Сортировка фильмов: \n" + "1 - По году выпуска\n"
                + "2 - По названию\n" + "3 - По режиссеру\n");

        String str = fromConsole();
        System.out.println("Выберите сортировку\n" + "1 - по возрастанию/алфавиту\n" + "2 - по убыванию/обратному алфавиту\n");
        String choice = fromConsole();
        switch (Integer.parseInt(str.toLowerCase())) {
            case 1:
                choice(movies, choice, "году");
                break;
            case 2:
                choice(movies, choice, "названию");
                break;
            case 3:
                choice(movies, choice, "режиссёру");
                break;
            default:
                System.out.println("Некорректный ввод! Попробуйте еще раз.");
                return;
        }
    }

    private void choice(List<Movie> movies, String string, String why) {
        switch (Integer.parseInt(string.toLowerCase())) {
            case 1:
                System.out.println("Сортировка по " + why + " (возрастание):");
                if (why.equals("году")) {
                movies.sort(Comparator.comparingInt(Movie::getYear));
                } else if (why.equals("названию")) {
                    movies.sort(Comparator.comparing(Movie::getName));
                } else if (why.equals("режиссёру")) {
                    movies.sort(Comparator.comparing(Movie::getDirectorName));
                }
                movies.forEach(System.out::println);
                break;
            case 2:
                System.out.println("\nСортировка по " + why + " (убывание):");
                if (why.equals("году")) {
                    movies.sort(Comparator.comparingInt(Movie::getYear).reversed());
                } else if (why.equals("названию")) {
                    movies.sort(Comparator.comparing(Movie::getName).reversed());
                } else if (why.equals("режиссёру")) {
                    movies.sort(Comparator.comparing(Movie::getDirectorName, Comparator.reverseOrder()));
                }
                movies.forEach(System.out::println);
                break;
            default:
                System.out.println("Некорректный ввод! Попробуйте еще раз.");
                return;

        }
    }
    private String fromConsole() {
        return new Scanner(System.in).nextLine();
    }
}