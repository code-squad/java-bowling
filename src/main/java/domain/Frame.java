package domain;

public class Frame {
    private Scores scores = new Scores();
    /* Frame 상태 넣어주기 */

    public void addScore(int score) throws IllegalArgumentException {
        scores.addScore(score);
    }

    public boolean isFinish() {
        return scores.isRecordFinish();
    }
}
