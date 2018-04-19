package bowling.domain.status;

import bowling.domain.score.Score;

public abstract class Status {

    public abstract Status bowl(int pins);

    public abstract boolean isPlayedOnce();

    public abstract boolean isStrike();

    public abstract boolean isSpare();

    public abstract boolean isAllPlayed();

    public abstract boolean isNotPlayed();

    public abstract boolean isComplete();

    public abstract Score createScore();

    public abstract int getFirstBowl();

    public abstract int getBothBowl();
}
