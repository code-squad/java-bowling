package model.frame;

public interface Frame {
    static Frame of(int round) {
        if (round == 10) return new FinalFrame();
        return new NormalFrame(round);
    }

    Frame getNextFrame();

    int getScoreSum();

    int getNextBallSum(int count);

    void bowl(int number);

    boolean isStrike();

    boolean isFinished();

    int getRound();
}
