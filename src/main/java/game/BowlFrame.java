package game;

import java.util.List;

public class BowlFrame {
    private Score score;

    public BowlFrame() {
        score = new Score(0);
    }

    public List<Integer> shot(int firstShot) {
        System.out.println(firstShot + "개를 맞췄습니다.");
        score.getNumbers().add(firstShot);
        return score.getNumbers();
    }

    public Boolean strike(List<Integer> numbers) {
        if (numbers.size() == 1 && numbers.get(0) == 10)
            return true;
        return false;
    }

    public Boolean spare(List<Integer> numbers) {
        if (numbers.size() == 2 && score.scoreSum(numbers) == 10)
            return true;
        return false;
    }
}
