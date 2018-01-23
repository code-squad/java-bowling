package bowling.domain.enums;

public enum ScoreType {
    STRIKE("X"),
    SPARE("/"),
    MISS("-"),
    GUTTER("-"),
    NUMBER("");

    private String value;

    ScoreType(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}