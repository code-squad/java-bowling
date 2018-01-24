import org.junit.Test;

import bowling.domain.frame.FinalFrame;
import bowling.domain.score.Score;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingFinalTest {

    @Test
    public void 마지막_프레임에서_연속_스트라이크시_3라운드까지_가는가() {
        FinalFrame frame = isEndTest(10, 10);
        assertFalse(frame.isEnd());
    }

    @Test
    public void 마지막_프레임에서_스페어일때_3라운드까지_가는가() {
        FinalFrame frame = isEndTest(0, 10);
        assertFalse(frame.isEnd());
    }

    @Test
    public void 마지막_프레임에서_일반숫자일때_끝나는가() {
        FinalFrame frame = isEndTest(3, 5);
        assertTrue(frame.isEnd());
    }

    @Test
    public void 마지막_프레임에서_첫번째_라운드가_미스일때_끝나는가() {
        FinalFrame frame = isEndTest(0, 5);
        assertTrue(frame.isEnd());
    }

    @Test
    public void 마지막_프레임에서_두번째_라운드가_미스일때_끝나는가() {
        FinalFrame frame = isEndTest(5, 0);
        assertTrue(frame.isEnd());
    }

    @Test
    public void 마지막_프레임에서_거터일때_끝나는가() {
        FinalFrame frame = isEndTest(0, 0);
        assertTrue(frame.isEnd());
    }

    @Test
    public void 마지막_프레임에서_연속_세번_스트라이크() {
        FinalFrame frame = threeTimeNextFrame(10, 10, 10);
        assertEquals("X|X|X", frame.result());
    }

    @Test
    public void 마지막_프레임에서_연속_두번_스트라이크() {
        FinalFrame frame = threeTimeNextFrame(10, 10, 3);
        assertEquals("X|X|3", frame.result());
    }

    @Test
    public void 마지막_프레임에서_스트라이크_후_스페어() {
        FinalFrame frame = threeTimeNextFrame(0, 10, 4);
        assertEquals("X|-|4", frame.result());
    }

    @Test
    public void 마지막_프레임에서_스페어_후_미스_숫자() {
        FinalFrame frame = threeTimeNextFrame(3, 7, 10);
        assertEquals("3|/|X", frame.result());
    }

    @Test
    public void 마지막_프레임에서_거터_미스() {
        FinalFrame frame = secondTimeNextFrame(4, 0);
        assertEquals("4|-", frame.result());
    }

    @Test
    public void 마지막_프레임에서_일반숫자() {
        FinalFrame frame = secondTimeNextFrame(4, 3);
        assertEquals("4|3", frame.result());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 투구점수가_올바르지_않으면_에러를_발생시키는가() {
        threeTimeNextFrame(0, 10, 11);
    }

    private FinalFrame isEndTest(int first, int second) {
        FinalFrame frame = FinalFrame.generate(Score.in(ofNullable(first)));
        if (!frame.isEnd()) { frame.nextRound(Score.in(ofNullable(second))); }
        return frame;
    }

    private FinalFrame secondTimeNextFrame(int first, int second) {
        FinalFrame frame = FinalFrame.generate(Score.in(ofNullable(first)));
        frame = frame.nextRound(Score.in(ofNullable(second)));
        return frame;
    }

    private FinalFrame threeTimeNextFrame(int first, int second, int third) {
        FinalFrame frame = FinalFrame.generate(Score.in(ofNullable(first)));
        frame.nextRound(Score.in(ofNullable(second)));
        frame.nextRound(Score.in(ofNullable(third)));
        return frame;
    }
}
