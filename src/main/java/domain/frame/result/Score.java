package domain.frame.result;

import domain.frame.pin.Pin;

public class Score {
    private int score;
    private int leftNum;

    public Score(int score, int leftNum) {
        this.score = score;
        this.leftNum = leftNum;
    }

    public void addBonusScore(Pin bonusPin) {
        if (leftNum == 0) {
            return;
        }
        score += bonusPin.getNum();
        leftNum--;
    }

    public boolean hasBonusCount() {
        return leftNum != 0;
    }

    public int get() {
        return score;
    }
}
