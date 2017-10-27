package bowling.frame.state;

class Miss extends Finished {
    private int first;
    private int second;

    Miss(int first, int second) {
        if (first + second > 10) {
            throw new IllegalArgumentException();
        }

        this.first = first;
        this.second = second;
    }

    @Override
    public Score getScore() {
        return new Score(this.first + this.second, 0);
    }

    public Score cacluateAdditionalScore(Score score) {
        score = score.bowl(this.first);
        if (score.canCalucateScore()) {
            return score;
        }
        score = score.bowl(this.second);
        return score;
    }

    @Override
    public String getDesc() {
        return this.first + " | " + this.second;
    }
}
