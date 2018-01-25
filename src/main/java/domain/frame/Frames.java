package domain.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Frames {

    private static final String BLANK = "|      |";

    private final List<Frame> frames = new ArrayList<>();

    private final List<Integer> scores = new ArrayList<>();

    void addFrame(Frame frame) {
        if (frame == null || frames.size() > 10) {
            throw new IllegalArgumentException();
        }
        frames.add(frame);
    }

    String getUpdateScoreResult() {
        updateScore();
        if (scores.isEmpty()) {
            return BLANK;
        }
        return BLANK + scores.stream()
                             .map(s -> String.format("%-4d", s))
                             .collect(Collectors.joining("|")) + "|";
    }

    private void updateScore() {
        int index = scores.size();
        Optional<Integer> score = getFrameScore(index);
        score.ifPresent(s -> {
            scores.add(s + getSumOfFrameScore());
            updateScore();
        });
    }

    private Optional<Integer> getFrameScore(int index) {
        Frame now = get(index);
        if (now == null) {
            return Optional.empty();
        }
        if (now.calculateFrameScore().isPresent()) {
            return now.calculateFrameScore();
        }
        Frame next = get(index + 1);
        if (next == null) {
            return Optional.empty();
        }
        Optional<Integer> score = next.calculateAdditionalScore(now);
        if (score.isPresent()) {
            return score;
        }
        Frame nextOfNext = get(index + 2);
        if (nextOfNext == null) {
            return Optional.empty();
        }
        return nextOfNext.calculateAdditionalScore(now, next);
    }

    private Frame get(int index) {
        if (index >= frames.size()) {
            return null;
        }
        return frames.get(index);
    }

    private Integer getSumOfFrameScore() {
        if (scores.isEmpty()) {
            return 0;
        }
        return scores.get(scores.size() - 1);
    }

    @Override
    public String toString() {
        if (frames.isEmpty()) {
            return "";
        }
        return frames.stream()
                     .map(Frame::toString)
                     .collect(Collectors.joining("|")) + "|";
    }
}
