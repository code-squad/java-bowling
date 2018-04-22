package bowling.domain.frame.status.last;

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