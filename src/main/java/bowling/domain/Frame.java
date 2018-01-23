package bowling.domain;

public class Frame {

    private TotalScore totalScore;
    private Score score;

    public Frame() {
    }

    public Frame(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String temp = totalScore == null ? "" : totalScore.toString() + score == null ? String.format("%6s","") : score.toString();
        return  String.format("  %2s  |", temp);
    }
}
