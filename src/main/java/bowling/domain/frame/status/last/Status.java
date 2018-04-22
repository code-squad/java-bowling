package bowling.domain.frame.status.last;

public interface Status {
    int ALL = 10;

    Status bowl(int pins);

    boolean isStrike();

    boolean isSpare(); //TODO: remove duplicate code through inheritance/interface?

    boolean isPlayed(); //TODO: remove duplicate code through inheritance/interface?

    int getScore();

    @Override
    String toString();
}