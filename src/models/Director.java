package models;

public class Director {
    String fullName;

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Director: " + fullName;
    }
}
