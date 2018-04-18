package bowling.domain;

public class Ready extends State {

    public State bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new FirstBowl(pins);
    }

    public boolean isReady() {
        return true;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isFirstBowl() {
        return false;
    }

    public boolean isSecondBowl() {
        return false;
    }
}