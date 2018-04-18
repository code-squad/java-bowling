package bowling.domain;

public interface Frame {

    Integer bowl(int pins);

    public boolean firstIsPlayed();

    public boolean secondIsPlayed();

    public boolean firstIsStrike();

    public boolean secondIsSpare();

    @Override
    String toString();
}
