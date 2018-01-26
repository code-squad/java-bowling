package domain.score;

public class Bonus implements State {

    private final int countOfPin;

    public Bonus(int countOfPin) {
        this.countOfPin = countOfPin;
    }

    @Override
    public State bowl(int countOfPin) {
        throw new IllegalStateException();
    }
}
