package saru;

public enum BowlSymbol {
    STRIKE("X"),
    SPARE("/"),
    NORMAL("");

    private String symbol;

    BowlSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isSTRIKE() {
        return STRIKE == this;
    }

    public boolean isSPARE() {
        return SPARE == this;
    }

    public boolean isNORMAL() {
        return NORMAL == this;
    }

    public String getSymbol() {
        return symbol;
    }
}
