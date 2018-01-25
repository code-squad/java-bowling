package bowling.domain;

import bowling.domain.Score.Roll;
import bowling.domain.number.BowlingScore;
import bowling.domain.number.Pins;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RollTest {
    @Test(expected = IllegalArgumentException.class)
    public void 넘어진_핀_숫자의_범위_1에서_10() {
        int max = 10;
        int i = 0;
        while(i <= max) {
            new Roll(new Pins(i++));
        }
        new Roll(new Pins(i));
    }

    @Test // Roll.java :40l
    public void random_테스트_핀_텀어진_숫자_생성시_자체_범위_테스트() {
        for (int i = 0; i < 10000; i++) {
            new Roll();
        }
    }

    @Test
    public void 넘어진_핀_숫자_볼링_점수로_변환() {
        for (int i = 0; i < 11; i++) {
            assertEquals(BowlingScore.values()[i], new Roll(new Pins(i)).toBowlingScore());
        }
    }

    @Test
    public void 출력_점수_문자열_비교() {
        assertEquals("-", new Roll(new Pins(0)).toBowlingScore().toString());
        assertEquals("1", new Roll(new Pins(1)).toBowlingScore().toString());
        assertEquals("2", new Roll(new Pins(2)).toBowlingScore().toString());
        assertEquals("3", new Roll(new Pins(3)).toBowlingScore().toString());
        assertEquals("4", new Roll(new Pins(4)).toBowlingScore().toString());
        assertEquals("5", new Roll(new Pins(5)).toBowlingScore().toString());
        assertEquals("6", new Roll(new Pins(6)).toBowlingScore().toString());
        assertEquals("7", new Roll(new Pins(7)).toBowlingScore().toString());
        assertEquals("8", new Roll(new Pins(8)).toBowlingScore().toString());
        assertEquals("9", new Roll(new Pins(9)).toBowlingScore().toString());
        assertEquals("/", new Roll(new Pins(10)).toBowlingScore().toString());
    }
}
