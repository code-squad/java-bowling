package bowling.domain;

public class FirstBowl extends State {
    private final int first;

    public FirstBowl(int pins) {
        this.first = pins;
    }

    @Override
    public State bowl(int pins) {
        if (first + pins == 10) {
            return new Spare(first, pins);
        }
        return new SecondBowl(first, pins);
    }

    public Score createScore() {
        return Score.ofNormal(first);
    }
}