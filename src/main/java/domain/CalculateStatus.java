package domain;

public enum CalculateStatus {
    DONOT(false),
    DO(true),
    DONE;

    private boolean status;

    CalculateStatus(boolean status) {
        this.status = status;
    }


    CalculateStatus() {

    }

    public static CalculateStatus of(boolean status) {
        if (status) return DO;
        return DONOT;
    }

}
