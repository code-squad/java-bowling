package domain.score;

public class FirstBowl implements State {

    private final int countOfPin;

    public FirstBowl(int countOfPin) {
        this.countOfPin = countOfPin;
    }

    @Override
    public State bowl(int countOfPin) {
        if (this.countOfPin + countOfPin > 10) {
            throw new IllegalArgumentException();
        }
        if (this.countOfPin + countOfPin == 10) {
            return new Spare(this.countOfPin, countOfPin);
        }
        return new Miss();
    }
}
