package domain;

import org.junit.Before;
import org.junit.Test;

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
}
