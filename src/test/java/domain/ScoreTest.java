package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreTest {

    @Test
    public void 유효한_범위() {
        assertTrue(Score.isValidRange(10));
    }

    @Test
    public void 유효하지않은_범위() {
        assertFalse(Score.isValidRange(11));
    }

    @Test
    public void 합산점수_최대치인가() {
        List<Score> scores = Arrays.asList(new Score(5), new Score(5));
        assertTrue(Score.isScoreLimit(scores));
    }

    @Test
    public void 합산점수_최대치인가2() {
        List<Score> scores = Arrays.asList(new Score(2), new Score(7));
        assertFalse(Score.isScoreLimit(scores));
    }
}
