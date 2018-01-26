package model;


public abstract class Frame {
    private BowlingScore score;
    private Integer numberOfLastPins;

    public Frame() {
        this.numberOfLastPins = 10;
        this.score = new BowlingScore();
    }

    public Score obtainScore(Integer numberOfFallingPins){
        Score thisScore = Score.valueOf(numberOfFallingPins, numberOfLastPins);
        if (score.hasAnyScore()) {
            score.addNewScore(thisScore);
            calculatePins(numberOfFallingPins);
            return thisScore;
        }
        score = new BowlingScore(thisScore);
        calculatePins(numberOfFallingPins);
        return thisScore;
    }

    public BowlingScore getScore() {
        return score;
    }

    public Boolean isItOverAndHasNextFrame(){
        return score.isItOverAndHasNextFrame(this);
    }

    public boolean isDone(){
        return score.isItOver(this);
    }

    private void calculatePins(Integer numberOfFallingPins) {
        numberOfLastPins = numberOfLastPins - numberOfFallingPins;
    }

    public abstract Integer addFirstAndSecond();

    public Integer addFirstAndSecondOfScore(){
        return score.addFirstAndSecond();
    }

    public boolean hasAllScore() {
        return score.hasAllScore();
    }

    public Integer addOnlyFirst() {
        return score.getFirst();
    }

    public boolean hasStrikeOrSpare() {
        return score.hasStrikeOrSpare();
    }

    public Integer calculateLast() {
        return score.calculateIfExist();
    }

    public boolean hasAnyScore(){
        return score.hasAnyScore();
    }
}
