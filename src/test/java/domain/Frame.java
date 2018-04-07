package domain;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    int updatedScore = 0;
    int tryCount = 0;
    List<Integer> scores = new ArrayList<>();

    public int getScore() {
        return sumScores();
    }

    public int getUpdatedScore() {
        return updatedScore;
    }

    public void trying(int score) {
        scores.add(score);
        tryCount++;
    }

    public int sumScores() {
        return scores.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isFrameEnd() {
        return sumScores() == 10 || tryCount == 2;
    }

    public boolean isStrike() {
        return sumScores() == 10 && tryCount == 1;
    }

    public boolean isSpare() {
        return sumScores() == 10 && tryCount == 2;
    }

    public void updateScore(Frame firstFrame) {
        if (firstFrame.isSpare()) {
            updatedScore += firstFrame.sumScores() + sumScores() + scores.get(0);
        }
        if (firstFrame.isStrike()) {
            updatedScore += firstFrame.sumScores() + sumScores() + sumScores();
        }
        if (!firstFrame.isStrike() && !firstFrame.isSpare()) {
            updatedScore += firstFrame.sumScores() + sumScores();
        }
    }
}
