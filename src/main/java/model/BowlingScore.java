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

    @Override
    public String toString() {
        if (secondScore == null){
            return Score.of(firstScore) + "   ";
        }

        return Score.of(firstScore) + "|" + Score.of(secondScore) + " ";
    }

    public boolean hasAnyScore() {
        return firstScore != null;
    }

    public boolean isItOverAndHasNextFrame(Frame frame) {
        if (isaFinalFrame(frame)){
            if (isOverCondition(firstScore)){
                return true;
            }
            if (secondScore != null && secondScore.equals(Score.SPARE)) {
                return true;
            }
            return false;
        }

        if (firstScore.equals(Score.STRIKE) || secondScore != null){
            return true;
        }

        return false;
    }

    private boolean isOverCondition(Score score) {
        return score.equals(Score.STRIKE) || score.equals(Score.STRIKE);
    }

    public boolean isItOver(Frame frame) {
        if (isaFinalFrame(frame) && hasAnyScore()){
            if (firstScore.equals(Score.STRIKE)){
                return false;
            }
            if (secondScore != null){
                if (secondScore.equals(Score.STRIKE) || secondScore.equals(Score.SPARE)){
                    return false;
                }
                return true;
            }
        }

        return false;
    }

    private boolean isaFinalFrame(Frame frame) {
        return frame instanceof FinalFrame;
    }

}
