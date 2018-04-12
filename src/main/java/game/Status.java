package game;

import java.util.List;

public class Status {
    private Score score;

    public Status() {
        score = new Score(0);
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

    public Boolean missing(List<Integer> numbers) {
        if (!spare(numbers) && !strike(numbers))
            return true;
        return false;
    }

    public Boolean onGoing(List<Integer> numbers) {
        if (!strike(numbers) && numbers.size() == 1)
            return true;
        return false;
    }
}
