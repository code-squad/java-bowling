package domain;

public class LastFrame extends Frame {
    private Score firstScore;
    private Score secondScore;
    private BonusScore bonusScore;

    public LastFrame() {
        this.firstScore = new FirstScore();
        this.secondScore = new SecondScore();
        this.bonusScore = new BonusScore();
    }

    public void updateFirstThrow(int pinsKnocked) { //첫번째로 실행
        firstScore.updateScore(pinsKnocked);
        firstScore.updatePinsStanding(pinsKnocked);
    }

    public boolean isStrike() {
        return firstScore.isNoPinStanding();
    }

    public void updateSecondThrow(int pinsKnocked) { //세번째로 실행
        secondScore.updateScore(pinsKnocked);
        secondScore.updatePinsStanding(pinsKnocked);
    }

    public boolean isSpare() {
        return secondScore.isNoPinStanding();
    }

    public void updateBonusThrow(int pinsKnocked) { //마지막으로 실행
        bonusScore.updateScore(pinsKnocked);
    }

    @Override
    public String toString() {
        return firstScore.toString() + secondScore.toString() + bonusScore.toString();
    }
}
