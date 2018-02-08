package domain.frame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Frames {

    private final Frame[] frames = new Frame[10];

    private final List<Integer> sumOfScores = new ArrayList<>();

    void updateFrame(Frame frame) {
        frames[frame.getFrameNo() - 1] = frame;
        updateScore();
    }

    String sumOfScores() {
        return sumOfScores.stream()
                          .map(s -> String.format("%-4d", s))
                          .collect(Collectors.joining("|"));
    }

    private void updateScore() {
        int index = sumOfScores.size();

        getFrameScore(index).ifPresent(s -> {
            sumOfScores.add(s + lastSumOfScore());
            updateScore();
        });
    }

    private Optional<Integer> getFrameScore(int index) {
        return getFrame(index).flatMap(Frame::getFrameScore);
    }

    private Optional<Frame> getFrame(int index) {
        if (index >= 10) {
            return Optional.empty();
        }
        return Optional.ofNullable(frames[index]);
    }

    private Integer lastSumOfScore() {
        if (sumOfScores.isEmpty()) {
            return 0;
        }
        return sumOfScores.get(sumOfScores.size() - 1);
    }

    @Override
    public String toString() {
        return Arrays.stream(frames)
                     .filter(Objects::nonNull)
                     .map(f -> String.format("%-4s", f.toString()))
                     .collect(Collectors.joining("|"));
    }
}
