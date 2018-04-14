package domain;

public enum Status {
    STRIKE("X"), // 첫 구에 10개를 쓰러트림
    SPARE("/"), // 스트라이크를 제외한 1,2구에 핀을 모두 쓰러트림
    OPEN(""), // 프레임을 마칠 때, 핀이 1개 이상 남아있을 때.
    GUTTER("-"),
    NOT_FINISHED("");

    static final int NO_PINS = 0;
    private String indicator;

    Status(String status) {
        this.indicator = status;
    }

    public static String getIndicator(Status status) {
        return status.indicator;
    }

    public static boolean isGutter(String count) {
        return Integer.parseInt(count) == NO_PINS;
    }
}
