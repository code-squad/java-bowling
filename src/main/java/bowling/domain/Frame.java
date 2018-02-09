package bowling.domain;

public interface Frame {
    boolean notYet();

    void setTry(Try eachTry);

    String showMessage();

    String showScore();

    int getBothDownCount();

    int getFirstDownCount();

    void setNextFrame(Frame nextFrame);
}
