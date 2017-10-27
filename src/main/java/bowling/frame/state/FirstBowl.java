package bowling.frame.state;

import bowling.frame.CannotCalculateException;

class FirstBowl extends Running {
    private int countOfPin;

    FirstBowl(int countOfPin) {
        this.countOfPin = countOfPin;
    }

    @Override
    public State bowl(int countOfPin) {
        if (this.countOfPin + countOfPin == 10) {
            return new Spare(this.countOfPin, countOfPin);
        }

        return new Miss(this.countOfPin, countOfPin);
    }

    public Score cacluateAdditionalScore(Score score) {
        score = score.bowl(this.countOfPin);
        if (score.canCalucateScore()) {
            return score;
        }
        throw new CannotCalculateException();
    }

    @Override
    public String getDesc() {
        return this.countOfPin + " | ";
    }
}
