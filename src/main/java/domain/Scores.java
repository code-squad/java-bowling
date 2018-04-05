package domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    //프레임별로 사이즈 제한이 들어갈 수 있음
    private static final int LIMIT_SIZE = 2;
    private List<Score> scores = new ArrayList<>();

    public void addScore(int number) throws IllegalArgumentException {
        Score newScore = new Score(number);
        if (newScore.isOverRecord(scores)) {
            throw new IllegalArgumentException("합산 : " + Score.MAX + "점을 넘을 수 없습니다");
        }
        scores.add(newScore);
    }

    public boolean isLimitSize() {
        return scores.size() == LIMIT_SIZE;
    }

    //점수를 더해서 비교하자 : Score 다 돌면서 10점인가 체크해봐야하나(스트라이크, 스페어, 미스 고려해가면서)
}
