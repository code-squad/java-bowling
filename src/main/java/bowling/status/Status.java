package bowling.status;

/**
 * @author sangsik.kim
 */
public interface Status {
    Status bowl(int pin);

    String getScore();
}
