package bowling.domain.frame;

public class NormalFrame extends Frame {

    @Override
    public boolean updateScore(int pinsKnocked) {
        if (!scores.firstThrowIsPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
            return true;
        }
        if (!scores.secondThrowIsPlayed()) {
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