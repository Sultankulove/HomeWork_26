package models;

import utils.FileUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortMovies {

            public void getSortMovies() {

            List<Movie> movies = FileUtil.readMovieFileToList();
                System.out.println("Сортировка фильмов: ");
                System.out.println("a - По году выпуска");
                System.out.println("b - По названию");
                System.out.println("c - По режиссеру");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                String sort = sortingByDirection();
                switch (input.toUpperCase()) {
                    case "a" : {
                            switch (sort.toLowerCase()) {
                                case "a": {
                                    System.out.println("Сортировка по году (возрастание):");
                                    movies.sort(Comparator.comparingInt(Movie::getYear));
                                    movies.forEach(System.out::println);
                                    break;
                                }
                                case "b": {
                                    System.out.println("\nСортировка по году (убывание):");
                                    movies.sort(Comparator.comparingInt(Movie::getYear).reversed());
                                    movies.forEach(System.out::println);
                                    break;
                                }
                            }
                        break;
                    }

                    case "b" : {
                        switch (sort.toLowerCase()) {
                            case "a": {
                                movies.sort(Comparator.comparing(Movie::getName));
                                movies.forEach(System.out::println);
                                break;
                            }
                            case "b": {
                                System.out.println("\nСортировка по названию (обратный алфавит):");
                                movies.sort(Comparator.comparing(Movie::getName).reversed());
                                movies.forEach(System.out::println);
                                break;
                            }
                        }
                        break;
                    }

                    case "c" : {
                        switch (sort.toLowerCase()) {
                            case "a": {
                                System.out.println("\nСортировка по режиссёру:");
                                movies.sort(new Comparator<Movie>() {
                                    @Override
                                    public int compare(Movie o1, Movie o2) {
                                        if (o1.getDirector() == null && o2.getDirector() == null) {
                                            return 0;
                                        } else if (o1.getDirector() == null) {
                                            return 1;
                                        } else if (o2.getDirector() == null) {
                                            return -1;
                                        }

                                        return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
                                    }
                                });
                                movies.forEach(System.out::println);
                                break;
                            }
                            case "b": {
                                System.out.println("\nСортировка по режиссёру(обратный):");
                                movies.sort(new Comparator<Movie>() {
                                    @Override
                                    public int compare(Movie movie1, Movie movie2) {
                                        if (movie1.getDirector() == null && movie2.getDirector() == null) {
                                            return 0;
                                        } else if (movie1.getDirector() == null) {
                                            return 1;
                                        } else if (movie2.getDirector() == null) {
                                            return -1;
                                        }

                                        return movie2.getDirector().getFullName().compareTo(movie1.getDirector().getFullName());
                                    }
                                });
                                movies.forEach(System.out::println);
                                break;
                            }
                            }
                        break;
                    }
                }

            }

            public String sortingByDirection() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Выберите сортировку");
                System.out.println("a - по возрастанию/алфавиту");
                System.out.println("b - по убыванию/обратному алфавиту");
                String str = sc.nextLine();
                return str;
            }

}
