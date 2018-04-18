package bowling.domain;

public class BonusBowl {
    private Integer pinsDown;

    public Integer bowl(Integer pinsDown) {
        if (!isPlayed()) {
            return this.pinsDown = pinsDown;
        }
        return null;
    }

    public boolean isPlayed() {
        return pinsDown != null;
    }
}