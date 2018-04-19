package bowling.domain;

public interface Frame {

    void updateFrameStatus(int pin);

    FrameStatus makeFrame(Ball ball);

    boolean checkComplete();

    boolean isSpare(Ball second);

    void createScore(NormalFrame frame);

    void updateScore(Score updateScore);

    Score getScore();

    int totalScore();

//    FrameStatus getFrameStatus();

    String toString();
}
