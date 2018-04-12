package domain;

public enum CalculateStatus {
    DONOT(false),
    DO(true);

    private boolean status;

    CalculateStatus(boolean status) {
        this.status = status;
    }

    public static CalculateStatus of(boolean status) {
        if (status) return DO;
        return DONOT;
    }

}
