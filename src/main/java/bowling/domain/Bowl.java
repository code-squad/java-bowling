package bowling.domain;

public class Bowl {
    private Integer score;

    public boolean isPlayed() {
        return score != null;
    }

    public Integer updateBowl(int pinsKnocked) {
        if (!isPlayed()) {
            return score = pinsKnocked;
        }
        return null;
    }
}
