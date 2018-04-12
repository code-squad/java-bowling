package bowling.domain;

public class NormalFrame extends Frame {

    @Override
    public boolean updateScore(int pinsKnocked) {
        if (!scores.firstThrowPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
            return true;
        }
        if (!scores.secondThrowPlayed()) {
            scores.updateSecondThrow(pinsKnocked);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " " + scores.toString();
    }
}