package bowling.frame.state;

import bowling.frame.pin.Pins;
import bowling.frame.pin.Score;

class Spare extends Finished {
    private Pins firstPins;
    private Pins secondPins;

    public Spare(Pins firstPins, Pins secondPins) {
        if (!firstPins.isSpare(secondPins)) {
            throw new IllegalArgumentException();
        }
        
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    public Score cacluateAdditionalScore(Score score) {
        score = firstPins.sumScore(score);
        if (score.canCalucateScore()) {
            return score;
        }
        score = secondPins.sumScore(score);
        return score;
    }

    @Override
    public Score getScore() {
        return new Score(Pins.MAX_PINS, 1);
    }

    @Override
    public String getDesc() {
        return firstPins.getDesc(secondPins);
    }
}
