package model;


public abstract class Frame {
    private BowlingScore score;
    private Integer numberOfLastPins;

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

    private void calculatePins(Integer numberOfFallingPins) {
        numberOfLastPins = numberOfLastPins - numberOfFallingPins;
    }

    public BowlingScore getScore() {
        return score;
    }

    public Boolean isItOverAndHasNextFrame(Integer numberOfFrame){
        return score.isItOverAndHasNextFrame(numberOfFrame);
    }

    public boolean isDone(Integer numberOfFrame){
        return score.isItOver(numberOfFrame);
    }
}
