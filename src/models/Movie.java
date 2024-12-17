package models;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    Director director;
    List<Cast> cast;

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public String getDirectorName() {
        return director != null ? director.getFullName() : "Unknown Director";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n")
          .append("Year: ").append(year).append("\n")
          .append("Description: ").append(description).append("\n")
          .append("Director: ").append(director).append("\n")
          .append("Cast: \n");

        for (Cast actor : cast) {
            sb.append("  - ").append(actor).append("\n");
        }

        return sb.toString();
    }
}
