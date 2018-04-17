package bowling;

/**
 * @author sangsik.kim
 */
public class Frame {
    private int current;
    private Round round;
    private int pins;
    private String score;

    private Frame(int current, Round round, int pins, String score) {
        this.current = current;
        this.round = round;
        this.pins = pins;
        this.score = score;
    }

    public static Frame initialFrame() {
        return new Frame(1, Round.READY, 10, null);
    }

    public Frame shot(int hitCount) {
        this.round = this.round.next();
        this.pins -= hitCount;
        this.score = this.round.isSecond() ? this.score + "|" + calculateScore(this.round, hitCount, this.pins) : calculateScore(this.round, hitCount, this.pins);

        // next frame
        if (isFinish()) {
            return new Frame(++this.current, Round.READY, 10, null);
        }
        // retry frame
        return this;
    }

    private boolean isFinish() {
        return round.isSecond() || pins == 0;
    }

    public String getScore() {
        return this.score;
    }

    public int current() {
        return this.current;
    }

    private String calculateScore(Round round, int hitCount, int pins) {
        if (hitCount == 0) {
            return "-";
        }
        if (round.isFirst() && pins == 0) {
            return "X";
        }
        if (round.isSecond() && pins == 0) {
            return "/";
        }
        return String.valueOf(hitCount);
    }

    public boolean canThrowBowling() {
        return this.round != Round.SECOND && this.pins != 0;
    }
}
