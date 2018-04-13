package bowling.domain.Util;

import bowling.domain.Frame;

import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    private final List<Frame> frames;

    public ScoreCalculator(List<Frame> frames) {
        this.frames = frames;
    }

    public List<Integer> calculateScores() {
        List<Integer> scores = new ArrayList<>();
        int bonusStack = 0;
        for (Frame frame : frames) {
            bonusStack += frame.calculateSum();
            scores.add(frame.calculateSum());
        }
        int reversedIndex = scores.size() - 1;
        for (int score : scores) {

        }
    }
}
