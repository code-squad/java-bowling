package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingResult {
    private List<Integer> scores;
    private ScoreStrategy scoreStrategy;

    public BowlingResult() {
        this.scores = new ArrayList();
        scoreStrategy = new ScoreStrategy();
    }

    public List<String> getResult(List<BowlingScore> result) {
        return result.stream()
                     .filter(score -> score.hasAnyScore())
                     .map(score -> score.toString())
                     .collect(Collectors.toList());
    }

    public List<String> getTotalScore() {
        List<Integer> result = scores.stream()
                                     .filter(score -> !score.equals(0))
                                     .collect(Collectors.toList());

        for (int i = 0; i < result.size(); i++) {
            if (i >= 1 && result.get(i).equals(result.get(i - 1))) {
                result.remove(i);
            }
        }
        return result.stream().map(score -> score.toString()).collect(Collectors.toList());
    }

    public void calculateUntilNow(Frame currentFrame) {
        scores.add(addUntilNow(currentFrame));
    }

    private Integer addUntilNow(Frame currentFrame) {
        Integer result = scoreStrategy.calculateUtilNow(currentFrame);

        if (!scores.isEmpty()) {
            return scores.get(scores.size() - 1) + result;
        }
        return result;
    }

    public void calculateNextTrial(Score thisScore) {
        scoreStrategy.calculateNextTrial(thisScore);
    }

    public boolean hasMoreTrial() {
        return scoreStrategy.hasMoreNextTrial();
    }

    public boolean stillCanCalculate() {
        return scoreStrategy.stillCanCalculate();
    }
}
