package bowling.domain;

public interface Frame {
    int ALL = 10;

    boolean firstBallPlayed();

    boolean secondBallPlayed();

    boolean isStrike();

    boolean isSpare();

    Integer throwBall(int pinsKnocked);

    Integer calculateSum();
}