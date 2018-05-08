package bowling;

/**
 * @author sangsik.kim
 */
public interface Frame {
    Frame bowl(int pin);

    boolean isFinish();

    String status();

    Score getScore();
}
