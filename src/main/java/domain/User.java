package domain;

public class User {

    private final String name;
    private Round round;

    private User(final String name) {
        this.name = name;
        this.round = Round.of();
    }

    public static User of(final String name) {
        return new User(name);
    }

    public Round getRound() {
        return round;
    }

    public void shot(final int score) {
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

    public boolean tossNextTurn() {
        return round.isFrameStatusNull();
    }
}
