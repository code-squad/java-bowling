package domain;

public class LastFrame extends Frame {
    private BonusScore bonusScore;

    public LastFrame() {
        this.bonusScore = new BonusScore();
    }

    public void updateBonusThrow(int pinsKnocked) { //마지막으로 실행
        bonusScore.updateScore(pinsKnocked);
    }

//    @Override
//    public String toString() {
//        return
//    }
}