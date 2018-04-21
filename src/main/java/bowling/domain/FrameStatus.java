package bowling.domain;

public enum FrameStatus {

    STRIKE("X "),
    SPARE("/"),
    MISS("  "),
    GUTTER("-"),
    PLAYING("  ")
    ;

    private String symbol;

    FrameStatus(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
