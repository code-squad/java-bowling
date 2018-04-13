package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private static final int ALL = 10;
    private final List<Integer> scores = initializeScores();

    private static List<Integer> initializeScores() {
        List<Integer> scores = new ArrayList<>();
        for (int frameCount = 0; frameCount < 2; frameCount++) {
            scores.add(null);
        }
        return scores;
    }

    private Integer ofFirstBall() {
        return scores.get(0);
    }

    private Integer ofSecondBall() {
        return scores.get(1);
    }

    public boolean firstBallPlayed() {
        return ofFirstBall() != null;
    }

    public boolean secondBallPlayed() {
        return ofSecondBall() != null;
    }

    public boolean isStrike() {
        return ofFirstBall().equals(ALL);
    }

    public boolean isSpare() {
        return ofSecondBall().equals(ALL - ofSecondBall());
    }

    public Integer throwBall(int pinsKnocked) {
        if (!firstBallPlayed()) {
            return scores.set(ofFirstBall(), pinsKnocked);
        }
        if (!secondBallPlayed()) {
            return scores.set(ofSecondBall(), pinsKnocked);
        }
        return null;
    }
}