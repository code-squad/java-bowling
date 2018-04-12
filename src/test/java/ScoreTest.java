import game.Score;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreTest {
    private Score score;
    private List<Integer> numbers;
    @Before
    public void setUp() {
        score = new Score(0);
        numbers = score.getNumbers();
    }

    @Test
    public void 한프레임스코어합() {
        numbers = Arrays.asList(2,4);
        int sum = score.scoreSum(numbers);
        assertEquals(6, sum);
    }
}
