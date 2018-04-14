package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static domain.CalculateStatus.DO;
import static domain.CalculateStatus.DONE;
import static domain.CalculateStatus.DONOT;
import static domain.CalculationDirection.LEFT;
import static domain.CalculationDirection.RIGHT;
import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public abstract class Frame {

    private Score frameScore;
    private Score totalScore;
    private List<Score> scores;
    private CalculateStatus calculateStatus;
    private CalculationDirection calculationDirection = RIGHT;

    public abstract boolean isFrameEnd();

    Frame() {
        this.scores = new ArrayList<>();
        this.frameScore = Score.of();
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
        this.frameScore.sum(Score.of(score));
        this.totalScore.sum(Score.of(score));
    }

    boolean isTrySecond() {
        return scores.size() == 2;
    }

    boolean isSpare() {
        return frameScore.isTen() && isTrySecond();
    }

    boolean isFirstStrike() {
        return scores.get(0).isTen();
    }

    Score getFrameScore() {
        return frameScore;
    }

    boolean isValidScore(final int score) {
        return isValidScoreToTotalScore(score);
    }

    boolean isValidScoreToTotalScore(final int score) {
        return frameScore.isValidAdditionScore(score);
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

    private boolean changeStatus(Frame beforeFrame) {
        if (beforeFrame.isBonus())
            return StatusChanger.beforeFrameDoNotCase(beforeFrame, this);
        return StatusChanger.beforeFrameDoCase(this);
    }

    public void assignCalculableState(Frame beforeFrame) {
        calculateStatus = CalculateStatus.of(changeStatus(beforeFrame));
    }

    public CalculateStatus getCalculateStatus() {
        return calculateStatus;
    }

    @Override
    public String toString() {
        return toFrameString();
    }

    public void isGivenMessageFromPresentFrameGaveVersion(Frame frame) {
        if (calculateStatus != DONE || (isBonus() && !frame.isBonus() && calculateStatus == DONE && !frame.isFrameEnd())) {
            System.out.println("헬로우");
            if (frame.totalScore.isBonusOverThirty()) {
                totalScore.sum(20);
                frame.changeCalculateDirectionToLeft();
                return;
            }
            totalScore.sum(frame.totalScore);
        }
        frame.changeCalculateDirectionToLeft();
    }

    private boolean isBonus() {
        return isSpare() || isFirstStrike();
    }

    public void isGivenMessageFromBeforeFrameGaveVersion(Frame beforeFrame) {
        System.out.println(calculationDirection);
        System.out.println(calculateStatus);
        if (calculationDirection == LEFT && calculateStatus != DONE && isFrameEnd()) {
            System.out.println("안녕");
            totalScore.sum(beforeFrame.totalScore);
            beforeFrame.changeCalculationStatusToDone();
            changeCalculationStatusToDone();
            changeCalculateDirectionToRight();
        }
    }

    public Score getTotalScore() {
        return totalScore;
    }

    public boolean isCalculationDo() {
        return calculateStatus == DO;
    }

    public void changeCalculateDirectionToLeft() {
        calculationDirection = LEFT;
    }

    private void changeCalculateDirectionToRight() {
        calculationDirection = RIGHT;
    }

    public void changeCalculationStatusToDo() {
        calculateStatus = DO;
    }

    public void changeCalculationStatusToDone() {
        calculateStatus = DONE;
    }

    public void assignFirstState() {
        if (isBonus()) {
            calculateStatus = DONOT;
            return;
        }
        changeCalculationStatusToDone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return Objects.equals(frameScore, frame.frameScore) &&
                Objects.equals(totalScore, frame.totalScore) &&
                Objects.equals(scores, frame.scores) &&
                calculateStatus == frame.calculateStatus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(frameScore, totalScore, scores, calculateStatus);
    }

}


