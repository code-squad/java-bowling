package bowling.status;

/**
 * @author sangsik.kim
 */
public class Miss implements Status {
    private int first;
    private int second;

    public Miss(int first, int second) {
        if (first + second > 10) {
            throw new IllegalArgumentException("쓰러진 핀의 갯수가 올바르지 않습니다.");
        }
        this.first = first;
        this.second = second;
    }

    @Override
    public Status bowl(int pin) {
        return null;
    }

    @Override
    public String getScore() {
        return convertGutter(this.first) + "|" + convertGutter(this.second);
    }

    private String convertGutter(int pin) {
        return pin == 0 ? "-" : String.valueOf(pin);
    }
}
