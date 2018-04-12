package bowling.domain.score;

import static bowling.domain.score.Scores.NONE;

public class SecondScore {
    private Integer secondScore;

    public int updateScore(int pinsKnocked) {
        if (secondScore == null) {
            secondScore = pinsKnocked;
        }
        return secondScore;
    }

    public boolean isPlayed() {
        return secondScore != null;
    }

    public boolean isSpare(FirstScore firstScore) {
        return firstScore.isSpare(secondScore);
    }

    public String toString(FirstScore firstScore) {
        if (!isPlayed()) {
            return "  ";
        }
        if (isSpare(firstScore)) {
            return "|/";
        }
        if (secondScore == NONE) {
            return "|-";
        }
        return "|" + secondScore;
    }
}