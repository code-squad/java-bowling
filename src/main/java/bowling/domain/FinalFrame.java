package bowling.domain;

public class FinalFrame {

    //TODO : 추후 점수 계산이 필요한 시점에 구현.
    private FinalScore score;
    private Roll bonusRoll;

    public FinalFrame(FinalScore score) {
        this.score = score;
    }

    public FinalFrame(FinalScore score, Roll bonusRoll) {
        this.score = score;
        this.bonusRoll = bonusRoll;
    }
}
