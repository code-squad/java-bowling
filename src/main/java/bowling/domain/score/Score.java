package bowling.domain.score;

public abstract class Score {

    public abstract boolean isPlayed();

    public abstract int updateScore(int pinsKnocked);

    public abstract String toString(boolean allPinsDown);
}
