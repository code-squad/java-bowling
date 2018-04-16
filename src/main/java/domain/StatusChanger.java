package domain;

import static domain.CalculateStatus.*;

public class StatusChanger {

    private CalculateStatus calculateStatus;

    private StatusChanger(Frame presentFrame, Frame beforeFrame) {
        calculateStatus = CalculateStatus.of(changeStatus(presentFrame, beforeFrame));
    }

    private StatusChanger(CalculateStatus calculateStatus) {
        this.calculateStatus = calculateStatus;
    }

    public static StatusChanger of(CalculateStatus calculateStatus) {
        return new StatusChanger(calculateStatus);
    }

    public static StatusChanger of(Frame presentFrame, Frame beforeFrame) {
        return new StatusChanger(presentFrame, beforeFrame);
    }

    private boolean changeStatus(Frame presentFrame, Frame beforeFrame) {
        if (beforeFrame.isBonusFrame())
            return CalculateStatusInitializer.beforeFrameNotYetCase(beforeFrame, presentFrame);
        return CalculateStatusInitializer.beforeFrameDoCase(presentFrame);
    }

    public CalculateStatus getCalculateStatus() {
        return calculateStatus;
    }

    public boolean isConditionBackward() {
        return calculateStatus != DONE;
    }

    public boolean isConditionForward(Frame presentFrame, Frame beforeFrame) {
        System.out.println(calculateStatus);
        if (presentFrame.isStrike(0) && presentFrame.isCalculationNotComplete() && !beforeFrame.isSpare()) return true;
        return presentFrame.isCalculationNotYet();
    }

    public void changeCalculationStatusToDone() {
        calculateStatus = DONE;
    }

    public void changeCalculationStatusToDo() {
        calculateStatus = DO;
    }

    public boolean isCalculationDo() {
        return calculateStatus == DO;
    }

    public void changeCalculationStatusToNotYet() {
        calculateStatus = NOT_YET;
    }

    public boolean isCalculationNotYet() {
        return calculateStatus == NOT_YET;
    }

    public boolean isCalculationDone() {
        return calculateStatus == DONE;
    }

    public void changeCalculationStatusToNotComplete() {
        calculateStatus = BONUS_NOT_COMPLETE;
    }

    public boolean isCalculationNotComplete() {
        return calculateStatus == BONUS_NOT_COMPLETE;
    }
}
