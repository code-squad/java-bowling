package bowling.frame.state;

import bowling.frame.pin.Pins;

class Miss extends Finished {
    private Pins firstPins;
    private Pins secondPins;

    Miss(Pins firstPins, Pins secondPins) {
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    @Override
    public Score getScore() {
        return new Score(this.firstPins.getFalledPins() + this.secondPins.getFalledPins(), 0);
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
    public String getDesc() {
        return this.firstPins.getFalledPins() + " | " + this.secondPins.getFalledPins();
    }
}
