package domain;

public enum CalculateStatus {
    NOT_YET(false),
    DO(true),
    DONE,
    BONUS_NOT_COMPLETE;

    private boolean status;

    CalculateStatus(boolean status) {
        this.status = status;
    }


    CalculateStatus() {

    }

    public static CalculateStatus of(boolean status) {
        if (status) return DO;
        return NOT_YET;
    }

}
