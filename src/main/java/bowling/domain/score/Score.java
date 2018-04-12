package bowling.domain.score;

public abstract class Score {

    public abstract boolean isNotPlayed();

    public abstract int updateScore(int pinsKnocked);

    public abstract String toString(boolean allPinsDown);
}
