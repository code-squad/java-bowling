package bowling.domain;

public class Score {

    private int score;
    private int count;

    private Score(int score, int count) {
        if (count < Miss.COUNT_ZERO || Strike.COUNT_TWO < count) {
            throw new IllegalArgumentException("보너스 볼의 수가 맞지 않습니다.");
        }

        this.score = score;
        this.count = count;
    }

    public static Score of(int score, int count) {
        return new Score(score, count);
    }

    public Score ofMinusCount(int pin) {
        return new Score(score + pin, count - 1);
    }

    public Score ofStayCount(int pin) {
        return new Score(score + pin, count);
    }

    public int getScore() {
        return score;
    }

    public boolean canCalculateScore() {
        return this.count == 0;
    }

    public boolean canCalculateStrike() {
        return this.count == 2;
    }
}
