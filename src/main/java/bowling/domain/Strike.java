package bowling.domain;

public class Strike extends State {

    public State bowl(int pins) {
        return this;
    }

    public Score createScore() {
        return Score.ofStrike();

    }
}