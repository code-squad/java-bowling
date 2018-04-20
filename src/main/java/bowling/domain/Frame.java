package bowling.domain;

public interface Frame {

    void updateFrameStatus(int pin);

    Status makeFrame(Ball ball);

    boolean checkComplete();

    void createScore(Frame frame);

    void updateScore(Score updateScore);

    Score getScore();

    Status getStatus();

    int totalScore();

    String toString();
}
