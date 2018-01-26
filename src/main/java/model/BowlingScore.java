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

        if (firstScore.equals(Score.STRIKE) || hasAllScore()){
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
        if (hasAllScore()){
            return true;
        }

        return false;
    }

    public Integer addFirstAndSecond(){
        return Integer.parseInt(Score.of(firstScore)) + Integer.parseInt(Score.of(secondScore));
    }

    @Override
    public String toString() {
        if (!hasAllScore()){
            return Score.of(firstScore) + "   ";
        }

        return Score.of(firstScore) + "|" + Score.of(secondScore) + " ";
    }

    public boolean hasStrike(Score score) {
        return score != null && score.equals(Score.STRIKE);
    }

    private boolean isaFinalFrame(Frame frame) {
        return frame instanceof FinalFrame;
    }

    private boolean hasSpare(Score score) {
        return score != null && score.equals(Score.SPARE);
    }

    public boolean hasAllScore() {
        return secondScore != null;
    }

    public Integer getFirst() {
        return Integer.valueOf(Score.of(firstScore));
    }

    public Integer calculateWithNextFrame(Frame currentFrame) {
        if (hasStrike(firstScore)) {
            return currentFrame.addFirstAndSecond() + 10;
        }
        if (hasSpare(secondScore)) {
            return currentFrame.addOnlyFirst() + 2 + getFirst();
        }
        if (hasAllScore()){
            return currentFrame.addFirstAndSecond();
        }
        return currentFrame.addOnlyFirst();
    }

    public boolean hasStrikeOrSpare() {
        return hasStrike(firstScore) || hasSpare(secondScore);
    }

    public Integer calculateIfExist() {
        if (hasAllScore()) {
            return addFirstAndSecond();
        }
        return addOnlyFirst();
    }

    private Integer addOnlyFirst() {
        return Integer.valueOf(Score.of(firstScore));
    }
}
