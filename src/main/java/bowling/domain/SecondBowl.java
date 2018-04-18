package bowling.domain;

public class SecondBowl extends State {
    private final int first;
    private final int second;

    public SecondBowl(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    public State bowl(int pins) {
        return this;
    }

    public Score createScore() {
        return Score.ofSecond(first + second);

    }
}