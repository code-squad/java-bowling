package bowling.type;

public enum ScoreType {
    STRIKE(2, "X"), SPARE(1, "/"), MISS(0, "%d"), GUTTER(0, "-");

    private int needScoreCount;
    private String expression;

    ScoreType(int needScoreCount, String expression){
        this.needScoreCount = needScoreCount;
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }
}
