package bowling.domain;

public interface Frame {

    void bowl(int pins);

    int getScore(Frame nextFrame);

    int calculateAdditionalScore(Status prevFrameStatus);
}
