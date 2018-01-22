import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingTest {
    
    @Test
    public void 입력된_점수가_1부터_10사이인가() {
        Score score1 = Score.in(Input.generate("3").getScore());
        assertTrue(BowlingUtils.MIN_SCORE <= score1.get() && score1.get() <= BowlingUtils.MAX_SCORE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력된_점수가_1부터_10사이가_아닐때_에러를_발생시키는가() {
        Score score2 = Score.in(Input.generate("11").getScore());
        assertFalse(BowlingUtils.MIN_SCORE <= score2.get() && score2.get() <= BowlingUtils.MAX_SCORE);
    }

    @Test
    public void 점수에_의한_표기가_올바른가() {
        
    }

    @Test
    public void 하나의_프레임에서_두번칠_경우_더한_값이_10이하인가() {

    }

    @Test
    public void 점수계산이_올바른가() {

    }
}
