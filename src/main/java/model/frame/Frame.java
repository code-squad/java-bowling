package model.frame;

public interface Frame {

    void bowl(int number);

    Frame getNextFrame();

    boolean isFinished();

    static Frame of(int round) {
        if (round == 10) return new FinalFrame();
        return new NormalFrame(round);
    }

    int getScore();

    int getNextBallSum(int count);

    boolean isStrike();

}
