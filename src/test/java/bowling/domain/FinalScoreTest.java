package bowling.domain;

import bowling.domain.FinalScore;
import bowling.domain.Roll;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FinalScoreTest {
    @Test
    public void 점수_문자열_비교() {
        FinalScore gutterGutter = new FinalScore(new Roll(0), new Roll(0));
        FinalScore gutterMiss = new FinalScore(new Roll(0), new Roll(9));
        FinalScore gutterSpared = new FinalScore(new Roll(0), new Roll(10));
        FinalScore missGutter = new FinalScore(new Roll(9), new Roll(0));
        FinalScore miss = new FinalScore(new Roll(8), new Roll(1));
        FinalScore spared = new FinalScore(new Roll(8), new Roll(2));
        FinalScore strike = new FinalScore(new Roll(10),new Roll(10));

        assertEquals("-|-", gutterGutter.toString());
        assertEquals("-|9", gutterMiss.toString());
        assertEquals("-|/", gutterSpared.toString());
        assertEquals("9|-",missGutter.toString());
        assertEquals("8|1", miss.toString());
        assertEquals("8|/", spared.toString());
        assertEquals("X|X", strike.toString());
    }
}
