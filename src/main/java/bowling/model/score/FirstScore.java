package bowling.model.score;

public class FirstScore implements Score {

    private final int first;

    public FirstScore (int first) {
        this.first = first;
    }

    @Override
    public int currentScore() {
        return first;
    }

    @Override
    public int firstScore() {
        return first;
    }

    @Override
    public int getScore(Score next, Score nextNext) {
        return first;
    }
}
