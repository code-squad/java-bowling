package domain;

public enum Figure {

    STRIKE("X"),
    SPARE("/"),
    FRAMEBAR("|"),
    ZERO("-");

    private final String figure;

    Figure(final String figureName) {
        figure = figureName;
    }

    @Override
    public String toString() {
        return figure;
    }
}
