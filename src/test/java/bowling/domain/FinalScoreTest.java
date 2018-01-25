package bowling.domain;

import bowling.domain.Score.FinalScore;
import bowling.domain.number.Roll;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FinalScoreTest {
    @Test
    public void 점수_문자열_비교() {
        FinalScore gutterGutter = new FinalScore(new Roll(0)).add(new Roll(0));
        FinalScore gutterMiss = new FinalScore(new Roll(0)).add(new Roll(9));
        FinalScore gutterSpared = new FinalScore(new Roll(0)).add(new Roll(10));
        FinalScore missGutter = new FinalScore(new Roll(9)).add(new Roll(0));
        FinalScore miss = new FinalScore(new Roll(8)).add(new Roll(1));
        FinalScore spared = new FinalScore(new Roll(8)).add(new Roll(2));
        FinalScore strike = new FinalScore(new Roll(10)).add(new Roll(10));;

        assertEquals("-|-", gutterGutter.toString());
        assertEquals("-|9", gutterMiss.toString());
        assertEquals("-|/", gutterSpared.toString());
        assertEquals("9|-",missGutter.toString());
        assertEquals("8|1", miss.toString());
        assertEquals("8|/", spared.toString());
        assertEquals("X|X", strike.toString());
    }
}
