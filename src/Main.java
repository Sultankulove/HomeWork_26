import models.Movie;
import utils.FileUtil;

public class Main {
    public static void main(String[] args) {
        Movie[] movies = FileUtil.readMovieFile();
        for (Movie movie : movies) {
            System.out.println("Name: " + movie.getName());
            System.out.println("Year: " + movie.getYear());
            System.out.println("Description: " + movie.getDescription());
            System.out.println("Director: " + movie.getDirector().getFullName());
            System.out.println("Cast:");
            movie.getCast().forEach(castMember ->
                    System.out.println("  - Actor: " + castMember.getFullName() + ", Role: " + castMember.getRole())
            );
            System.out.println();
        }
    }
}