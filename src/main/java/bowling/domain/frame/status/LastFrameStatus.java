package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LastFrameStatus {
    private static final int MAX_BOWL = 3;
    private final List<Status> status = new ArrayList<>();

    public LastFrameStatus() {
        status.add(new NotPlayed());
    }

    public void bowl(int pins) {
        getCurrentStatus().bowl(pins);
    }

    private Status getCurrentStatus() {
        for (Status status : status) {
            if (!status.isComplete()) {
                return status;
            }
        }
        Status newStatus = new NotPlayed();
        status.add(newStatus);
        return newStatus;
    }

    private Status getFirst() {
        return status.get(0);
    }

    private Status getSecond() {
        return status.get(1);
    }

    private boolean firstIsMiss() {
        return getFirst().isMiss();
    }

    private boolean bothAreNotStrike() {
        return !getFirst().isStrike()
                && !getSecond().isStrike();
    }

    private boolean twoAreComplete() {
        if (status.size() != 2) {
            return false;
        }
        return getFirst().isComplete()
                && getSecond().isComplete();
    }

    public boolean isComplete() {
        if (firstIsMiss()) {
            return true;
        }
        if (twoAreComplete() && bothAreNotStrike()) {
            return true;
        }
        return status.size() == MAX_BOWL;
    }

    public boolean firstIsPlayed() {
        return getFirst().isPlayed();
    }

    public Score createScore() {
        return getFirst().createScore();
    }

    public void updateScore(Score score) {
        for (Status status : status) {
            status.updateScore(score);
        }
    }

    public void updateScoresFromPreviousFrames(Score prevScore) {
        for (Status status : status) {
            status.updateScore(prevScore);
        }
    }

    @Override
    public String toString() {
        return status
                .stream()
                .map(Status::toString)
                .collect(Collectors.joining("|"));
    }
}