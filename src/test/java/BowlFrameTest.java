import game.BowlFrame;
import game.Score;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BowlFrameTest {
    private BowlFrame bowlFrame;
    private Score score;

    @Before
    public void setUp() {
        bowlFrame = new BowlFrame();
        score = new Score(0);
    }

    @Test
    public void 스트라이크() {
        score.getNumbers().add(10);
        boolean result = bowlFrame.strike(score.getNumbers());
        assertTrue(result);
    }

    @Test
    public void 스페어() {
        List<Integer> scores = score.getNumbers();
        scores.add(1);
        scores.add(9);
        Boolean result = bowlFrame.spare(scores);
        System.out.println("점수는 : " + score.scoreSum(scores));
        assertTrue(result);
    }

    @Test
    public void not스트라이크() {
        List<Integer> scores = score.getNumbers();
        scores.add(8);
        System.out.println("점수는 : " + score.scoreSum(scores));
        boolean result = bowlFrame.strike(scores);
        assertFalse(result);
    }

    @Test
    public void not스페어() {
        List<Integer> scores = score.getNumbers();
        scores.add(7);
        scores.add(2);
        boolean result = bowlFrame.strike(scores);
        System.out.println("점수는 : " + score.scoreSum(scores));
        assertFalse(result);
    }

//    @Test
//    public void 스트라이크다음() {
//        List<Integer> scores = score.getNumbers();
//        score.getNumbers().add(9);
//        boolean strike = bowlFrame.strike(scores);
//        bowlFrame.nextFrame(scores);
//    }
}
