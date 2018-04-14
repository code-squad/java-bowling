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
        if (beforeFrame.calculateStatus == DONOT)
            return StatusChanger.beforeFrameDoNotCase(beforeFrame, this);
        return StatusChanger.beforeFrameDoCase(this);
    }

    public void assignCalculableState(Frame beforeFrame) {
        calculateStatus = CalculateStatus.of(changeStatus(beforeFrame));
    }

    public void assignCalculableState() {
        calculateStatus = CalculateStatus.of(StatusChanger.beforeFrameDoCase(this));
    }

    public CalculateStatus getCalculateStatus() {
        return calculateStatus;
    }

    @Override
    public String toString() {
        return toFrameString();
    }

    public void isGivenMessageFromPresentFrameGaveVersion(Frame frame) {
        if (calculateStatus == DONOT) {
//        if (calculateStatus == DONOT && calculationDirection == RIGHT || calculateStatus == DO && isFirstStrike()) {
            if (frame.totalScore.isBonusOverThirty()) {
                System.out.println("보너스 까지 합계가 30점이 넘으므로");
                System.out.printf("현재 %s점\n", totalScore);
                totalScore.sum(20);
                System.out.printf("이전 프레임이 보너스를 받아야 하니 %s점을 받고 그래서 %s가지고 있음\n", 20, totalScore);
            } else {
                totalScore.sum(frame.totalScore);
                System.out.printf("이전 프레임이 보너스를 받아야 하니 %s점을 받고 그래서 %s가지고 있음\n", frame.totalScore, totalScore);
            }
//            changeCalculateDirectionToLeft();
        }
        frame.changeCalculateDirectionToLeft();
    }

    public void isGivenMessageFromBeforeFrameGaveVersion(Frame beforeFrame) {
        System.out.println("점수를 받아야 하는 프레임의 방향은 " + calculationDirection);
        if (calculationDirection == LEFT && calculateStatus != DONE && isFrameEnd()) {
//        if (calculationDirection == LEFT && calculateStatus == DONOT) {
            System.out.printf("현재 프레임 계산 상태는 %s\n", calculateStatus);
            System.out.printf("현재 %s점을 가지고 있음\n", totalScore);
            totalScore.sum(beforeFrame.totalScore);
            System.out.printf("이전프레임으로부터 %s를 받고 \n지금은 %s만큼 가지고 있다.\n", beforeFrame.totalScore, totalScore);
//            changeCalculateDirectionToRIGHT();
            changeCalculationStatusToDone();
            return;
        }
//        if (beforeFrame.isBonus() && !isBonus()) {
//            changeCalculateDirectionToRIGHT();
//            changeCalculationStatusToDo();
//            return;
//        }
//        if (isFrameEnd() && !isBonus()) {
//            System.out.printf("현재 프레임 계산 상태는 %s\n", calculateStatus);
//            System.out.printf("현재 %s점을 가지고 있음\n", totalScore);
//            totalScore.sum(beforeFrame.totalScore);
//            System.out.printf("이전프레임으로부터 %s를 받고 \n지금은 %s만큼 가지고 있다.\n", beforeFrame.totalScore, totalScore);
//            changeCalculateDirectionToRIGHT();
//        }
    }

    private void changeCalculationStatusToDone() {
        calculateStatus = DONE;
    }

    public boolean isBonus(){
        return isFirstStrike() || isSpare();
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

    public Score getTotalScore() {
        return totalScore;
    }

    public boolean isCalculationDo() {
        return calculateStatus == DO;
    }

    public void changeCalculateDirectionToLeft() {
        calculationDirection = LEFT;
    }

    public void changeCalculateDirectionToRIGHT() {
        calculationDirection = RIGHT;
    }

    public void changeCalculationStatusToDo() {
        calculateStatus = DO;
    }
}


