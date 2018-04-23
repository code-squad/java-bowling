package status;

public class Strike implements State {
    @Override
    public String displayText() {
        return "  X   |";
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
