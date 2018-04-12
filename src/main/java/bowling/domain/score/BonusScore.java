package bowling.domain.score;

import static bowling.domain.score.Scores.ALL;
import static bowling.domain.score.Scores.NONE;

public class BonusScore {
    private Integer bonusScore;

    public int updateScore(int pinsKnocked) {
        if (bonusScore == null) {
            bonusScore = pinsKnocked;
        }
        return bonusScore;
    }

    public boolean isPlayed() {
        return bonusScore != null;
    }

    @Override
    public String toString() {
        if (!isPlayed()) {
            return "  ";
        }
        if (bonusScore == ALL) {
            return "|X";
        }
        if (bonusScore == NONE) {
            return "|-";
        }
        return "|" + bonusScore;
    }
}