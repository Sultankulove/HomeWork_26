package models;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    Director director;
    List<CastMember> cast;

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

    public List<CastMember> getCast() {
        return cast;
    }
}
