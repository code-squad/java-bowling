package bowling.domain;

import bowling.domain.Score.FinalScore;
import bowling.domain.Score.Roll;
import bowling.domain.number.Pins;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FinalScoreTest {
    @Test
    public void 점수_문자열_비교() {
        FinalScore gutterGutter = new FinalScore(new Roll(new Pins(0))).add(new Roll(new Pins(0)));
        FinalScore gutterMiss = new FinalScore(new Roll(new Pins(0))).add(new Roll(new Pins(9)));
        FinalScore gutterSpared = new FinalScore(new Roll(new Pins(0))).add(new Roll(new Pins(10)));
        FinalScore missGutter = new FinalScore(new Roll(new Pins(9))).add(new Roll(new Pins(0)));
        FinalScore miss = new FinalScore(new Roll(new Pins(8))).add(new Roll(new Pins(1)));
        FinalScore spared = new FinalScore(new Roll(new Pins(8))).add(new Roll(new Pins(2)));
        FinalScore strike = new FinalScore(new Roll(new Pins(10))).add(new Roll(new Pins(10)));;

        assertEquals("-|-", gutterGutter.toString());
        assertEquals("-|9", gutterMiss.toString());
        assertEquals("-|/", gutterSpared.toString());
        assertEquals("9|-",missGutter.toString());
        assertEquals("8|1", miss.toString());
        assertEquals("8|/", spared.toString());
        assertEquals("X|X", strike.toString());
    }
}
