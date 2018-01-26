package domain.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Frames {

    private static final String BLANK = "|      |";

    private final Frame[] frames = new Frame[10];

    private final List<Integer> scores = new ArrayList<>();

    void updateFrame(Frame frame) {
        frames[frame.frameNo - 1] = frame;
        updateScore();
    }

    String getScoresToString() {
        if (scores.isEmpty()) {
            return BLANK;
        }
        return BLANK + scores.stream()
                             .map(s -> String.format("%-4d", s))
                             .collect(Collectors.joining("|")) + "|";
    }

    private void updateScore() {
        int index = scores.size();

        getFrameScore(index).ifPresent(s -> {
            scores.add(s + getSumOfFrameScore());
            updateScore();
        });
    }

    private Optional<Integer> getFrameScore(int index) {
        Frame now = get(index);
        if (now == null) {
            return Optional.empty();
        }
        return now.getFrameScore();
    }

    private Frame get(int index) {
        if (index >= 10) {
            return null;
        }
        return frames[index];
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
                     .filter(Objects::nonNull)
                     .map(f -> String.format("%-4s", f.toString()))
                     .collect(Collectors.joining("|")) + "|";
    }
}
