package model;

import java.util.List;
import java.util.stream.Collectors;

public class BowlingResult {
    public static List<String> getResult(BowlingGame bowlingGame) {
        return bowlingGame.getResult().stream()
                          .filter(score -> score.hasAnyScore())
                          .map(score -> score.toString())
                          .collect(Collectors.toList());
    }
}
