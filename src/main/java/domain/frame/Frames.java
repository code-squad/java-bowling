package domain.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Frames {

    private static final String BLANK = "|      |";

    private final Frame[] frames = new Frame[10];

    private final List<Integer> scores = new ArrayList<>();

    void updateFrame(Frame frame) {
        frames[frame.frameNo - 1] = frame;
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
        if (now.getFrameScore().isPresent()) {
            return now.getFrameScore();
        }
        Frame next = get(index + 1);
        if (next == null) {
            return Optional.empty();
        }
        Optional<Integer> score = next.calculateScoreWithBefore(now);
        if (score.isPresent()) {
            return score;
        }
        Frame nextOfNext = get(index + 2);
        if (nextOfNext == null) {
            return Optional.empty();
        }
        return nextOfNext.calculateScoreWithBefore(now, next);
    }

    private Frame get(int index) {
        if (index > 10) {
            return null;
        }
        return frames[index - 1];
    }

    private Integer getSumOfFrameScore() {
        if (scores.isEmpty()) {
            return 0;
        }
        return scores.get(scores.size() - 1);
    }

    @Override
    public String toString() {
        if (frames[0] == null) {
            return "";
        }
        return Arrays.stream(frames)
                     .map(f -> String.format("%-4s", f.toString()))
                     .collect(Collectors.joining("|")) + "|";
    }
}
