package bowling.domain;

import bowling.domain.number.Roll;
import bowling.domain.number.BowlingScore;
import bowling.domain.Score.Score;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ScoreTest {

    @Test
    public void 점수_등록_생성될_볼링핀_최대_갯수() {
        Score score = new Score().add(new Roll(4));
        Score add = score.add(new Roll(score.calcMaxDownCount()));
        assertTrue(add.calcMaxDownCount().toInteger().equals(6));
    }

    @Test
    public void 점수_등록_합계가_10개_초과하지_않는지_체크하는_로직() {
        Score score = new Score().add(new Roll(4));
        score.add(new Roll(6));
        assertFalse(score.isOverMaxCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void 점수_등록_예외_처리_10이상() {
        Score strike = new Score(new Roll(4));
        strike.add(new Roll(7));
    }


    @Test (expected = IllegalArgumentException.class) // Score.java :55l
    public void 점수_등록_예외_처리_스트라이크() {
        Score strike = new Score(new Roll(10));
        strike.add(new Roll(strike.calcMaxDownCount()));
    }

    @Test
    public void 점수_등록_자동_생성시_오류나지_않도록_Random_bound() { // Roll.java :36l
        for (int i = 0; i < 1000; i++) {
            Score strike = new Score(new Roll(9));
            strike.add(new Roll(strike.calcMaxDownCount()));
        }
    }

    @Test
    public void 등록된_점수_변환_확인() {
        Score strike = new Score(new Roll(10));
        Score spare = new Score(new Roll(8)).add(new Roll(2));
        Score miss = new Score(new Roll(8)).add(new Roll(1));

        assertEquals(BowlingScore.STRIKE, strike.toBowlingScore());
        assertEquals(BowlingScore.SPARE, spare.toBowlingScore());
        assertEquals(BowlingScore.MISS, miss.toBowlingScore());
    }

    @Test
    public void 출력_점수_문자열_비교() {
        assertEquals("/", new Score(new Roll(8)).add(new Roll(2)).toBowlingScore().getString());
        assertEquals("X", new Score(new Roll(10)).toBowlingScore().getString());
        assertEquals("", new Score(new Roll(8)).add(new Roll(1)).toBowlingScore().getString());
    }

    @Test
    public void 점수_문자열_비교() {
        Score gutterGutter = new Score(new Roll(0)).add(new Roll(0));
        Score gutterSpare = new Score(new Roll(0)).add(new Roll(10));
        Score noSparedScore = new Score(new Roll(8)).add(new Roll(1));
        Score sparedScore = new Score(new Roll(8)).add(new Roll(2));
        Score strikeScore = new Score(new Roll(10));

        assertEquals("-|-", gutterGutter.toString());
        assertEquals("-|/", gutterSpare.toString());
        assertEquals("8|1", noSparedScore.toString());
        assertEquals("8|/", sparedScore.toString());
        assertEquals("X", strikeScore.toString());
    }
}