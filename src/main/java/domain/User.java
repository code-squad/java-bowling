package domain;

public class User {

    private String name;
    private Round round;

    private User(String name) {
        this.name = name;
        this.round = Round.of();
    }

    public static User of(String name) {
        return new User(name);
    }

    public Round getRound() {
        return round;
    }

    public void shot(int score) {
        round.trying(score);
    }

    public boolean roundEnd() {
        return round.isRoundEnd();
    }

    public String getName() {
        return name;
    }

    public int getFrameNumber() {
        return round.getFrameNumber();
    }
}
