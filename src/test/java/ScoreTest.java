import game.Score;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ScoreTest {
    private Score score;
    private List<Integer> scores;
    @Before
    public void setUp() {
        Score score = new Score(0);
        scores = score.getNumbers();
    }


}
