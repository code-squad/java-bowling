package bowling.domain;

public class FinalScoreCell {

    private FinalScore score;
    private Roll bonusRoll;

    public FinalScoreCell() {
    }

    @Override
    public String toString() {
        return score == null ? "" : score.toString() + bonusRoll == null ? "" : bonusRoll.toString();
    }
}
