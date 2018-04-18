package bowling.domain;

public abstract class State {

    public abstract State bowl(int pins);

    public abstract Score createScore();
}
