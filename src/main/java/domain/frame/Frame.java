package domain.frame;

public interface Frame {
    String recordPins(int num) throws IllegalArgumentException;

    boolean isFinish();

    String convertPinNum(int num);

    int getTotalScore();
}
