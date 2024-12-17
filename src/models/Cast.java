package models;

public class Cast {
    String fullName;
    String role;

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        String str = "Actor: %s as %s";
        return String.format(str, fullName, role);
    }
}
