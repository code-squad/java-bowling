package bowling.domain;

public class Score {

    private int score;
    private int leftBonus;

    private Score(int score, int leftBonus) {
        this.score = score;
        this.leftBonus = leftBonus;
    }

    public static Score of(int score, int left) {
        return new Score(score, left);
    }

    public Score add(Score score) {
        return Score.of(this.score + score.getScore(), this.leftBonus + score.getLeftBonus());
    }

    public Score addBonusScore(Pin pin) {
        if (!isAddable()) return this;
        return of(score + pin.getPin(), leftBonus - 1);
    }

    public boolean isAddable() {
        return leftBonus != 0;
    }

    public int getScore() {
        return score;
    }

    public int getLeftBonus() { return leftBonus; }
}
