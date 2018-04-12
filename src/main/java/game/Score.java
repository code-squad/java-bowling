package game;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private int score;
    private List<Integer> numbers;

    public Score(int score) {
        this.score = score;
        numbers = new ArrayList<>();
    }

    public Integer scoreSum(List<Integer> numbers) {
        int sum = 0;
        for (int score : numbers)
            sum += score;
        return sum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
