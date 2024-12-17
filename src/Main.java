import models.Movie;
import models.OutputOfTheEntireJSON;
import models.SortMoviesTest;
import utils.FileUtil;
import utils.Search;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Movie> movies = FileUtil.readMovieFileToList();
    private static Search search = new Search();
    private static SortMoviesTest sortMovies = new SortMoviesTest();
    private static Output output = new Output();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "1":
                    displayAllMovies();
                    break;
                case "2":
                    searchMovies();
                    break;
                case "3":
                    sortMovies();
                    break;
                case "4":
                    displayAllActor();
                    break;
                case "5":
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nМеню коллекции фильмов:");
        System.out.println("1. Показать все фильмы");
        System.out.println("2. Поиск фильмов по названию, режиссеру или году");
        System.out.println("3. Сортировка фильмов");
        System.out.println("4. Показать всех актеров");
        System.out.println("5. Выход");
        System.out.print("Введите ваш выбор: ");
    }

    private static void displayAllMovies() {
        output.OutputJson();
    }

    private static void searchMovies() {
        System.out.println("Поиск по:");
        System.out.println("1. Название фильма");
        System.out.println("2. Режиссер");
        System.out.println("3. Год выпуска");
        System.out.print("Введите выбор: ");
        String searchChoice = scanner.nextLine().trim();

        switch (searchChoice) {
            case "1":
                System.out.print("Введите название фильма: ");
                String name = scanner.nextLine();
                search.searchByExactName(movies, name);
                break;
            case "2":
                System.out.print("Введите имя режиссера: ");
                String director = scanner.nextLine();
                search.searchMoviesByDirector(director);
                break;
            case "3":
                System.out.print("Введите год выпуска: ");
                int year = Integer.parseInt(scanner.nextLine());
                search.searchMoviesByYear(year);
                break;
            default:
                System.out.println("Неверный выбор, попробуйте снова.");
        }
    }

    private static void sortMovies() {
        sortMovies.getSortMovies();
    }

    private static void displayAllActor() {
//        search.displayAllActors();
        System.out.println();
        System.err.println("выбор 4 не доступен");
    }
}
