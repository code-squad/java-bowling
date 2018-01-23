package bowling.domain;

import bowling.domain.BowlingScore;
import bowling.domain.Roll;
import bowling.domain.Score;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ScoreTest {
    @Test (expected = IllegalArgumentException.class)
    public void 넘어진_핀_숫자의_범위() {
        int max = 10;
        int i = 0;
        while(i <= max) {
            new Roll(i++);
        }
        new Roll(i);
    }

    @Test
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

    @Test (expected = IllegalArgumentException.class)
    public void 점수_등록_예외_처리() {
        new Score(new Roll(10), new Roll(10));
    }

    @Test
    public void 스트라이크_스패어_미스_점수_확인() {
        Score strike = new Score(new Roll(10));
        Score spare = new Score(new Roll(8), new Roll(2));
        Score miss = new Score(new Roll(8), new Roll(1));

        assertEquals(BowlingScore.STRIKE, strike.toBowlingScore());
        assertEquals(BowlingScore.SPARE, spare.toBowlingScore());
        assertEquals(BowlingScore.MISS, miss.toBowlingScore());
    }

    @Test
    public void 출력_점수_문자열_비교() {
        assertEquals("-", new Roll(0).toBowlingScore().toString());
        assertEquals("1", new Roll(1).toBowlingScore().toString());
        assertEquals("2", new Roll(2).toBowlingScore().toString());
        assertEquals("3", new Roll(3).toBowlingScore().toString());
        assertEquals("4", new Roll(4).toBowlingScore().toString());
        assertEquals("5", new Roll(5).toBowlingScore().toString());
        assertEquals("6", new Roll(6).toBowlingScore().toString());
        assertEquals("7", new Roll(7).toBowlingScore().toString());
        assertEquals("8", new Roll(8).toBowlingScore().toString());
        assertEquals("9", new Roll(9).toBowlingScore().toString());
        assertEquals("/", new Roll(10).toBowlingScore().toString());
        assertEquals("/", new Score(new Roll(8), new Roll(2)).toBowlingScore().toString());
        assertEquals("X", new Score(new Roll(10)).toBowlingScore().toString());
        assertEquals("", new Score(new Roll(8), new Roll(1)).toBowlingScore().toString());
    }

    @Test
    public void 점수_문자열_비교() {
        Score gutterGutter = new Score(new Roll(0), new Roll(0));
        Score gutterSpare = new Score(new Roll(0), new Roll(10));
        Score noSparedScore = new Score(new Roll(8), new Roll(1));
        Score sparedScore = new Score(new Roll(8), new Roll(2));
        Score strikeScore = new Score(new Roll(10));

        assertEquals("-|-", gutterGutter.toString());
        assertEquals("-|/", gutterSpare.toString());
        assertEquals("8|1", noSparedScore.toString());
        assertEquals("8|/", sparedScore.toString());
        assertEquals("X", strikeScore.toString());
    }
}