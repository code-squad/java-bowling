package domain;

public enum Figure {

    STRIKE("X"), SPARE("/");

    private final String figure;

    private Figure(final String figureName) {
        figure = figureName;
    }

    @Override
    public String toString() {
        return figure;
    }
}
