package bowling.domain.frame.last.status;

public interface Status {
    int ALL = 10;
    int NONE = 0;

    Status bowl(int pins);

    boolean isStrike();

    boolean isSpare();

    boolean isPlayed();

    int getScore();

    @Override
    String toString();
}