package bowling.frame.state;

class Strike extends Finished {
    @Override
    public Score getScore() {
        return new Score(10, 2);
    }

    public Score cacluateAdditionalScore(Score score) {
        if (score.canCalucateScore()) {
            return score;
        }
        return score.bowl(10);
    }

    @Override
    public String getDesc() {
        return "X";
    }
}
