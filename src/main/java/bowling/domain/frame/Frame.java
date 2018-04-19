package bowling.domain.frame;

public interface Frame {

    void bowl(int pins);

    int calculateAdditionalScore(Frame nextFrame);

    boolean isStrike();

    boolean isPlayedOnce();
}
