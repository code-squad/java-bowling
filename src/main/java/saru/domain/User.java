package saru.domain;

public class User {
    private static final int MAX_NAME = 3;
    private String name;

    private User(String name) {
        this.name = name;
    }

    public static User of(String name) {
        if (name.length() > MAX_NAME) {
            throw new IllegalArgumentException("3글자 이상 입력");
        }

        return new User(name);
    }

    public String getName() {
        return name;
    }
}
