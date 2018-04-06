package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScoresTest {
    private Scores scores;

    @Before
    public void setUp() throws Exception {
        scores = new Scores();
    }

    @Test
    public void 점수정상추가() {
        scores.addScore(4);
        scores.addScore(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 점수오버추가() {
        scores.addScore(10);
        scores.addScore(1);
    }

    @Test
    public void 최대치점수일때_점수추가_더이상할수없다() {
        scores.addScore(10);
        assertTrue(scores.isScoreLimit());
    }

    @Test
    public void 던진횟수_소진시_점수추가_더이상할수없다() {
        scores.addScore(5);
        scores.addScore(3);
        assertTrue(scores.isLimitSize());
    }
}
