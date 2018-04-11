package domain;

public abstract class Score {
    Integer pinsStanding;

    public Score() {
        this.pinsStanding = 10;
    }

    public int updatePinsStanding(int pinsKnocked) {
        this.pinsStanding -= pinsKnocked;
        return this.pinsStanding;
    }

    public abstract boolean isNoPinStanding();

    public abstract boolean isPlayed();

    public abstract int updateScore(int pinsKnocked);

}
