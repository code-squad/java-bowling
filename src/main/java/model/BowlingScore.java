package model;

public class BowlingScore {
    private Score firstScore;
    private Score secondScore;

    public BowlingScore() {
    }

    public BowlingScore(Score firstScore) {
        this.firstScore = firstScore;
    }

    public void addNewScore(Score secondScore) {
        this.secondScore = secondScore;
    }

    public boolean hasAnyScore() {
        return firstScore != null;
    }

    public boolean isItOverAndHasNextFrame(Frame frame) {
        if (isaFinalFrame(frame) && hasStrike(firstScore)){
            return true;
        }

        if (isaFinalFrame(frame) && hasSpare(secondScore)){
            return true;
        }

        if (isaFinalFrame(frame)){
            return false;
        }

        if (firstScore.equals(Score.STRIKE) || secondScore != null){
            return true;
        }

        return false;
    }

    public boolean isItOver(Frame frame) {
        if (isaFinalFrame(frame) && hasStrike(firstScore)){
            return false;
        }
        if (isaFinalFrame(frame) && hasAnyScore() && hasStrike(secondScore)){
            return false;
        }
        if (isaFinalFrame(frame) && hasAnyScore() && hasSpare(secondScore)) {
            return false;
        }
        if (secondScore != null){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        if (secondScore == null){
            return Score.of(firstScore) + "   ";
        }

        return Score.of(firstScore) + "|" + Score.of(secondScore) + " ";
    }

    private boolean hasStrike(Score score) {
        return score != null && score.equals(Score.STRIKE);
    }

    private boolean isaFinalFrame(Frame frame) {
        return frame instanceof FinalFrame;
    }

    private boolean hasSpare(Score score) {
        return score != null && score.equals(Score.SPARE);
    }
}
