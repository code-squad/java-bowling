package bowling;

/**
 * @author sangsik.kim
 */
public enum Round {
    SECOND(null),
    FIRST(Round.SECOND),
    READY(Round.FIRST);

    Round(Round next) {
        this.next = next;
    }

    private final Round next;

    public Round next() {
        return this.next;
    }
}
