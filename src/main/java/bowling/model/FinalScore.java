package bowling.model;

import java.util.List;
import java.util.stream.Collectors;

public class FinalScore implements Score {

    private List<Integer> scores;

    public FinalScore(List<Integer> scores) {
        this.scores = scores;
    }

    @Override
    public int currentScore() {
        return 0;
    }

    @Override
    public String toString() {
        String str = scores.stream()
                .map(score -> score.toString())
                .collect(Collectors
                        .joining("|"));

        str = str.replaceAll("10", "X");
        str = str.replaceAll("0", "-");

        StringBuilder builder = new StringBuilder(str);
        if (isFirstSpare())
            builder.setCharAt(2, '/');

        if (isSecondSpare())
            builder.setCharAt(4, '/');

        return builder.toString();
    }

    private boolean isFirstSpare() {
        return scores.get(1) > 0 && scores.get(0) + scores.get(1) == 10;
    }

    private boolean isSecondSpare() {
        return scores.get(2) > 0 && scores.get(1) + scores.get(2) == 10;
    }
}
