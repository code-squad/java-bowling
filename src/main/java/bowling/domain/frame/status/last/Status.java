package bowling.domain.frame.status.last;

public interface Status {

    Status bowl(int pins);

    boolean isStrike();

    boolean isSpare();

    String toString();
}