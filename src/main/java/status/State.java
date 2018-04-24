package status;

public interface State {
    String displayText();

    State bowl(int first);

    boolean isFinish();

    boolean isStrike();

    boolean isSpare();

    boolean isMiss();

    boolean isFirstBowl();
}
