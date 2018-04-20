package bowling.domain.frame.status.last;

public interface Status {

    Status bowl(int pins);

    boolean isStrike();

    boolean isSpare(); //TODO: remove duplicate code through inheritance/interface?

    boolean isNotPlayed(); //TODO: remove duplicate code through inheritance/interface?

    int getScore();

    @Override
    String toString();
}