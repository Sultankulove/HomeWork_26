package models;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    Director director;
    List<Cast> cast;

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
}
