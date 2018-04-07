package domain;

import java.util.Arrays;
import java.util.List;

public class Frame {

    int score = 0;

    public void putFisrtTryPoint(int i) {
        score += i;
    }

    public int totalScore() {
        return score;
    }

    public void tryInning(int first, int second) {
        List<Integer> scores = Arrays.asList(first, second);
        int turn = 0;
        while (!isTurnEnd(scores, turn)) {
            score += scores.get(turn);
            turn++;
        }
    }

    private boolean isTurnEnd(List<Integer> scores, int turn) {
        return score == 10 | turn == scores.size();
    }
}
