package bowling.domain;

public interface Frame {
    boolean notYet();

    void setTry(Try eachTry);

    String showMessage();
}
