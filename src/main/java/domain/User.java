package domain;

import java.util.Objects;

public class User {

    String name;
    RoundFrames roundFrames;

    private User(String name) {
        this.name = name;
        this.roundFrames = new RoundFrames();
    }

    public static User of(String name) {
        return new User(name);
    }

    public RoundFrames getRoundFrames() {
        return roundFrames;
    }

    public void shot(int i) {
        roundFrames.lastFrameTry(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(roundFrames, user.roundFrames);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, roundFrames);
    }
}
