package bowling.domain;

public interface Frame {
    int ALL = 10;
    int NONE = 0;

    boolean firstBallPlayed();

    boolean secondBallPlayed();

    boolean isStrike();

    boolean isSpare();

    boolean isNotValidInput(int pinsKnocked);

    Integer throwBall(int pinsKnocked);

    Integer calculateSum();
}