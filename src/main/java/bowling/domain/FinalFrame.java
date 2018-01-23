package bowling.domain;

public class FinalFrame {

    private TotalScore totalScore;
    private FinalScoreCell score;

    public FinalFrame() {
    }

    @Override
    public String toString() {
        String temp = totalScore == null ? "" : totalScore.toString() + score == null ? String.format("%6s","") : score.toString();
        return  String.format("  %2s  |", temp);
    }
}
