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
        this.score = this.round.equals(Round.SECOND) ? this.score + "|" + calculateScore(hitCount) : calculateScore(hitCount);

        // next frame
        if (this.round.equals(Round.SECOND) || this.pins == 0) {
            return new Frame(++this.current, Round.READY, 10, null);
        }
        // retry frame
        return this;
    }

    public String getScore() {
        return this.score;
    }

    public int current() {
        return this.current;
    }

    private String calculateScore(int hitCount) {
        if (hitCount == 0) {
            return "-";
        }
        if (this.round.equals(Round.FIRST) && this.pins == 0) {
            return "X";
        }
        if (this.round.equals(Round.SECOND) && this.pins == 0) {
            return "/";
        }
        return String.valueOf(hitCount);
    }

    public boolean canThrowBowling() {
        return this.round != Round.SECOND && this.pins != 0;
    }
}
