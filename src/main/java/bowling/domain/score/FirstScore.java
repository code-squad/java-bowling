package bowling.domain.score;

import static bowling.domain.score.Scores.ALL;
import static bowling.domain.score.Scores.NONE;

public class FirstScore {
    private Integer firstScore;

    public int updateScore(int pinsKnocked) {
        if (firstScore == null) {
            firstScore = pinsKnocked;
        }
        return firstScore;
    }

    public boolean isPlayed() {
        return firstScore != null;
    }

    public boolean isStrike() {
        return firstScore == ALL;
    }

    public boolean isSpare(int secondScore) {
        return firstScore + secondScore == ALL;
    }

    public boolean isMoreThanPinsStanding(int pinsKnocked){
        return pinsKnocked > ALL - firstScore;
    }

    @Override
    public String toString() {
        if (!isPlayed()) {
            return " ";
        }
        if (isStrike()) {
            return "X";
        }
        if (firstScore == NONE) {
            return "-";
        }
        return String.valueOf(firstScore);
    }
}