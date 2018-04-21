package bowling.domain;

public class Shot {

    public static final int MAX_NUMBER_OF_PIN = 10;

    private int numberOfPin;

    public Shot(int numberOfPin) {
        if (numberOfPin < 0 || MAX_NUMBER_OF_PIN < numberOfPin) {
            throw new IllegalArgumentException();
        }

        this.numberOfPin = numberOfPin;
    }

    public int numberOfPin() {
        return numberOfPin;
    }

    @Override
    public String toString() {
        return numberOfPin == 0 ? "-" : String.valueOf(numberOfPin);
    }
}
