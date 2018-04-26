package bowling.domain.frame.status;

import bowling.domain.frame.FrameCompleteException;
import bowling.domain.frame.score.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LastFrameStatus {
    private final List<Status> status = new ArrayList<>();
    private Status currentStatus = new NotPlayed();

    public void bowl(int pins) {
        currentStatus = currentStatus.bowl(pins);
        if (currentStatus.isComplete()) {
            status.add(currentStatus);
            currentStatus = new NotPlayed();
        }
        if (firstIsSpare() && currentStatus.isPlayed()) {
            status.add(new Bonus(pins));
        }
//        if (isComplete()) {
//            throw new FrameCompleteException();
//        }
    }

    public boolean bowlStarted() {
        if (status.size() == 0) {
            return currentStatus.isPlayed();
        }
        return firstIsPlayed();
    }

    private boolean firstIsPlayed() {
        return status.size() > 0;
    }

    private boolean secondIsPlayed() {
        return status.size() > 1;
    }

    private boolean thirdIsPlayed() {
        return status.size() == 3;
    }

    private boolean firstIsSpare() {
        return firstIsPlayed()
                && status.get(0).isSpare();
    }

    private boolean firstIsMiss() {
        return firstIsPlayed()
                && status.get(0).isMiss();
    }

    private boolean firstIsStrike() {
        return firstIsPlayed()
                && status.get(0).isStrike();
    }

    private boolean secondIsStrike() {
        return secondIsPlayed()
                && status.get(1).isStrike();
    }

    private boolean twoBowlsComplete() {
        return secondIsPlayed()
                && status.get(1).isComplete();
    }

    public boolean isComplete() {
        if (firstIsMiss()) {
            return true;
        }
        if (twoBowlsComplete()
                && !firstIsStrike()
                && secondIsStrike()) {
            return true;
        }
        return thirdIsPlayed();
    }

    public Score createScore() {
        if (firstIsPlayed()) {
            return status.get(0).createScore();
        }
        return currentStatus.createScore();
    }

    public void updateLastFrameScore(Score score) {
        if (secondIsPlayed()) {
            status.get(1).updateScore(score);
        }
        if (thirdIsPlayed()) {
            status.get(2).updateScore(score);
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