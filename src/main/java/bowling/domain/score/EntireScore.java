package bowling.domain.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntireScore {
    private List<Score> scores = new ArrayList<>();
    private ScoreType scoreType;

    public EntireScore(Score score) {
        scores.add(score);
    }

    public static EntireScore generate(Score score) {
        return new EntireScore(score);
    }

    public EntireScore inScore(Score nextScore) {
        scores.add(nextScore);
        return this;
    }

    public boolean validTotalScore(Score nextScore)  {
        return beforeLastScore().validTotalScore(nextScore);
    }

    public Score lastScore() {
        return Optional.of(scores.get(scores.size()-1)).orElseThrow(() -> new ArrayIndexOutOfBoundsException("프레임에 점수가 입력되지 않았습니다."));
    }

    public Score beforeLastScore() {
        return Optional.of(scores.get(scores.size()-2)).orElseThrow(() -> new ArrayIndexOutOfBoundsException("프레임에 2번 이상 점수가 입력되지 않았습니다."));
    }

    public int length() {
        return scores.size();
    }
}
