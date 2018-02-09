package bowling.domain;

public interface Frame {
    boolean notYet();

    void setTry(Try eachTry);

    String showMessage();

    String showScore();

    void setNextFrame(Frame nextFrame);

    int getBonusScore(boolean spare);
}
