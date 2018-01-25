package bowling.domain;

import bowling.domain.number.Roll;
import bowling.domain.number.BowlingScore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RollTest {
    @Test(expected = IllegalArgumentException.class)
    public void 넘어진_핀_숫자의_범위_1에서_10() {
        int max = 10;
        int i = 0;
        while(i <= max) {
            new Roll(i++);
        }
        new Roll(i);
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
            assertEquals(BowlingScore.values()[i], new Roll(i).toBowlingScore());
        }
    }

    @Test
    public void 출력_점수_문자열_비교() {
        assertEquals("-", new Roll(0).toBowlingScore().getString());
        for (int i = 1; i < 9; i++) {
            assertEquals(String.valueOf(i), new Roll(i).toBowlingScore().getString());
        }
        assertEquals("/", new Roll(10).toBowlingScore().getString());
    }
}
