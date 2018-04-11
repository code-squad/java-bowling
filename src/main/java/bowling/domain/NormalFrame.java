package bowling.domain;

public class NormalFrame extends Frame {

    public void updateScore(int pinsKnocked) {
        if (scores.firstThrowPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
        }
        if (scores.secondThrowPlayed()) {
            scores.updateSecondThrow(pinsKnocked);
        }
    }

    @Override
    public String toString() {
        return " " + scores.toString();
    }
}