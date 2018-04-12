package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public void assignCalculableState() {
        if (!isTrySecond() && !isFirstStrike()) {
            System.out.println("첫째 조건 통과, 계산 Do");
            calculate = Calculate.DO;
            return;
        }
        if (isFrameEnd() && (!isSpare() && !isFirstStrike())) {
            System.out.println("둘째 조건 통과, 계산 Do");
            calculate = Calculate.DO;
            return;
        }
        System.out.println("마지막 조건 통과, 계산 Do not");
        calculate = Calculate.DONOT;
    }

    public void assignCalculableState(Frame beforeFrame) {
        if (beforeFrame.calculate == Calculate.DONOT) {
            if (beforeFrame.isFirstStrike()) {
                System.out.println("이전 프레임이 스트라이크");
                if (!isTrySecond()) calculate = Calculate.DONOT;
                if (!isTrySecond() && !isFirstStrike()) calculate = Calculate.DO;
                if (isSpare()) calculate = Calculate.DONOT;
                if (!isSpare() && !isFirstStrike()) calculate = Calculate.DO;
                return;
            }
            if (beforeFrame.isSpare()) {
                System.out.println("이전 프레임이 스페어");
                if (!isTrySecond() && isFirstStrike()) calculate = Calculate.DONOT;
                if (!isTrySecond() && !isFirstStrike()) calculate = Calculate.DO;
                if (isSpare()) calculate = Calculate.DONOT;
                calculate = Calculate.DO;
            }
        }
        assignCalculableState();
    }

    public Calculate getCalculate() {
        return calculate;
    }
}

