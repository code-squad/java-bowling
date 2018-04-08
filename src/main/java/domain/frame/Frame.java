package domain.frame;

public interface Frame {

    String addScore(int score) throws IllegalArgumentException;

    boolean isFinish();

    String convertScore(int score);
}
