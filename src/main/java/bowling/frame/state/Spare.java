package bowling.frame.state;

import bowling.frame.pin.Pins;

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
        score = score.bowl(this.firstPins.getFalledPins());
        if (score.canCalucateScore()) {
            return score;
        }
        score = score.bowl(this.secondPins.getFalledPins());
        return score;
    }

    @Override
    public Score getScore() {
        return new Score(10, 1);
    }

    @Override
    public String getDesc() {
        return this.firstPins.getFalledPins() + " | /";
    }
}
