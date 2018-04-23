package status;

public class Spare implements State {
    private int first;

    public Spare(int first) {
        this.first = first;
    }

    @Override
    public String displayText() {
        return "|" + "/ |";
    }

    @Override
    public State bowl(int first) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isFinish() {
        return true;
    }
}
