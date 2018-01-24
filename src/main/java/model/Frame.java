package model;


public abstract class Frame {
    private BowlingScore score;
    public Integer numberOfLastPins;

    public Frame() {
        this.numberOfLastPins = 10;
        this.score = new BowlingScore();
    }

    public BowlingScore obtainScore(Integer numberOfFallingPins){
        if (score.hasAnyScore()) {
            score.addNewScore(Score.valueOf(numberOfFallingPins, numberOfLastPins));
            calculatePins(numberOfFallingPins);
            return score;
        }
        score = new BowlingScore(Score.valueOf(numberOfFallingPins, numberOfLastPins));
        calculatePins(numberOfFallingPins);
        return score;
    }

    public BowlingScore getScore() {
        return score;
    }

    public Boolean isItOverAndHasNextFrame(Frame frame){
        return score.isItOverAndHasNextFrame(frame);
    }

    public boolean isDone(){
        return score.isItOver(this);
    }

    private void calculatePins(Integer numberOfFallingPins) {
        numberOfLastPins = numberOfLastPins - numberOfFallingPins;
    }
}
