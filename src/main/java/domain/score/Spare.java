package domain.score;

public class Spare implements State {

    private final int first;

    private final int second;

    public Spare(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public State bowl(int countOfPin) {
        throw new IllegalStateException();
    }
}
