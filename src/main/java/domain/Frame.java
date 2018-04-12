package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static domain.Calculate.DO;
import static domain.Calculate.DONOT;
import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public abstract class Frame {

    private Score totalScore;
    private List<Score> scores;
    private Calculate calculate;

    public abstract boolean isFrameEnd();

    Frame() {
        this.scores = new ArrayList<>();
        this.totalScore = Score.of();
    }

    public void trying(final int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        addition(score);
    }

    void addition(final int score) {
        this.scores.add(Score.of(score));
        this.totalScore.sum(Score.of(score));
    }

    boolean isTrySecond() {
        return scores.size() == 2;
    }

    boolean isSpare() {
        return totalScore.isTen() && isTrySecond();
    }

    boolean isFirstStrike() {
        return scores.get(0).isTen();
    }

    Score getFrameScore() {
        return totalScore;
    }

    boolean isValidScore(final int score) {
        return isValidScoreToTotalScore(score);
    }

    boolean isValidScoreToTotalScore(final int score) {
        return totalScore.isValidAdditionScore(score);
    }

    private String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    private String spareString() {
        return scores.get(0).toString() + FRAMEBAR + SPARE;
    }

    String toFrameString() {
        if (isSpare()) return spareString();
        return toScoreString();
    }

    public boolean isCalculateUntilNow() {
        return !isFirstStrike() && !isSpare();
    }

    public void assignCalculableState() {
        if (!isTrySecond() && !isFirstStrike()) {
            calculate = DO;
            return;
        }
        if (isFrameEnd() && (!isSpare() && !isFirstStrike())) {
            calculate = DO;
            return;
        }
        calculate = DONOT;
    }

    public void assignCalculableState(Frame beforeFrame) {
        if (beforeFrame.calculate == DONOT) {
            changeStatusBeforeFrameDoNotCase(beforeFrame);
        }
        assignCalculableState();
    }

    private void changeStatusBeforeFrameDoNotCase(Frame beforeFrame) {
        if (beforeFrame.isFirstStrike()) {
            calculate = changeStatusBeforeFrameDoNotAndStrike();
        }
        if (beforeFrame.isSpare()) {
            changeStatusBeforeFrameDoNotAndSpare();
        }
    }

    private Calculate changeStatusBeforeFrameDoNotAndSpare() {
        if (!isTrySecond() && isFirstStrike()) return DONOT;
        if (!isTrySecond() && !isFirstStrike()) return DO;
        if (isSpare()) return DONOT;
        return DO;
    }

    private Calculate changeStatusBeforeFrameDoNotAndStrike() {
        if (!isTrySecond()) return DONOT;
        if (!isTrySecond() && !isFirstStrike()) return DO;
        if (isSpare()) return DONOT;
        if (!isSpare() && !isFirstStrike()) return DO;
        return DO;
    }

    public Calculate getCalculate() {
        return calculate;
    }

    @Override
    public String toString() {
        return toFrameString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return Objects.equals(scores, frame.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }

}

