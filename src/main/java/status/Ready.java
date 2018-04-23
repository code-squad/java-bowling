package status;

public class Ready implements State {
    @Override
    public String displayText() {
        return null;
    }

    public State bowl(int first) {
        if (first == 10)
            return new Strike();
        return new FirstBowl(first);
    }

    @Override
    public boolean isFinish() {
        return false;
    }
}
