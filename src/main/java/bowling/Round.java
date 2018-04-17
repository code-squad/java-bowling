package bowling;

/**
 * @author sangsik.kim
 */
public enum Round {
    SECOND(null),
    FIRST(SECOND),
    READY(FIRST);

    Round(Round next) {
        this.next = next;
    }

    private final Round next;

    public Round next() {
        return this.next;
    }

    public boolean isFirst() {
        return this.equals(FIRST);
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }
}
