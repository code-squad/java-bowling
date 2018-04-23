package status;

public class Miss implements State {
    private int first;
    private int second;

    public Miss(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String displayText() {
        return "|" + String.valueOf(second) + " |";
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
