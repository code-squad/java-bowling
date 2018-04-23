package status;

public interface State {
    String displayText();

    State bowl(int first);

    boolean isFinish();
}
