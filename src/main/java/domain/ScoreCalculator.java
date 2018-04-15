package domain;

import static domain.CalculateStatus.DO;
import static domain.CalculateStatus.DONE;
import static domain.CalculateStatus.DONOT;
import static domain.CalculationDirection.LEFT;
import static domain.CalculationDirection.RIGHT;

public class ScoreCalculator {

    private CalculateStatus calculateStatus;
    private CalculationDirection calculationDirection;


    private ScoreCalculator() {
        calculationDirection = RIGHT;
    }

    private ScoreCalculator(Frame presentFrame, Frame beforeFrame) {
        calculateStatus = CalculateStatus.of(changeStatus(presentFrame, beforeFrame));
        calculationDirection = RIGHT;
    }

    private ScoreCalculator(CalculationDirection calculationDirection) {
        this.calculationDirection = calculationDirection;
    }

    private ScoreCalculator(CalculateStatus calculateStatus) {
        this.calculateStatus = calculateStatus;
        calculationDirection = RIGHT;
    }

    public static ScoreCalculator of() {
        return new ScoreCalculator();
    }

    public static ScoreCalculator of(CalculateStatus calculateStatus) {
        return new ScoreCalculator(calculateStatus);
    }

    public static ScoreCalculator of(CalculationDirection calculationDirection) {
        return new ScoreCalculator(calculationDirection);
    }

    public static ScoreCalculator of(Frame presentFrame, Frame beforeFrame) {
        return new ScoreCalculator(presentFrame, beforeFrame);
    }

    private boolean changeStatus(Frame presentFrame, Frame beforeFrame) {
        if (beforeFrame.isBonus())
            return StatusChanger.beforeFrameDoNotCase(beforeFrame, presentFrame);
        return StatusChanger.beforeFrameDoCase(presentFrame);
    }

    public CalculateStatus getCalculateStatus() {
        return calculateStatus;
    }

    public boolean isConditionBackward(Frame beforeFrame, Frame presentFrame) {
        return calculateStatus != DONE || (beforeFrame.isBonus() && calculateStatus == DONE && !presentFrame.isBonus() && !presentFrame.isFrameEnd());
    }

    public void changeCalculateDirectionToLeft() {
        calculationDirection = LEFT;
    }

    public boolean isConditionForward(Frame frame) {
        return calculationDirection == LEFT && calculateStatus != DONE && frame.isFrameEnd();
    }

    public void changeCalculationStatusToDone() {
        calculateStatus = DONE;
    }

    public void changeCalculateDirectionToRight() {
        calculationDirection = RIGHT;
    }

    public void changeCalculationStatusToDo() {
        calculateStatus = DO;
    }

    public void changeCalculationStatusToDoNOT() {
        calculateStatus = DONOT;
    }

    public boolean isCalculationDo() {
        return calculateStatus == DO;
    }

}
