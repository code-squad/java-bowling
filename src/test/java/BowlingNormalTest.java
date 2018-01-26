import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;
import org.junit.Test;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.*;

public class BowlingNormalTest {

    @Test
    public void 입력받은_점수가_스트라이크면_프레임이_끝나는가() {
        Frame frame = makeNormalFrame(10);
        assertTrue(frame.isEnd());
    }

    @Test
    public void 입력받은_첫번쨰_라운드_점수가_10이하면_두번의_라운드를_실행하는가() {
        Frame frame = makeNormalFrameByDoubleScore(6, 3);
        assertTrue(frame.isEnd());
    }

    @Test
    public void 다음_라운드가_존재하는가() {
        assertFalse(makeNormalFrame(4).isEnd());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 두번칠_경우_점수가_10을_넘기면_에러를_발생시키는가() {
        makeNormalFrameByDoubleScore(4, 8);
    }

    @Test
    public void 입력받은_점수가_스트라이크일때_출력이_올바른가() {
        Frame frame = makeNormalFrame(10);
        assertEquals("X", frame.result());
    }

    @Test
    public void 입력받은_점수가_스페어일때_출력이_올바른가() {
        Frame frame = makeNormalFrameByDoubleScore(6, 4);
        assertEquals("6|/", frame.result());
    }

    @Test
    public void 입력받은_총점수가_10이하일때_출력이_올바른가() {
        Frame frame = makeNormalFrameByDoubleScore(3, 3);
        assertEquals("3|3", frame.result());
    }

    @Test
    public void 첫번째_입력받은_점수가_미스일때_출력이_올바른가() {
        Frame frame = makeNormalFrameByDoubleScore(4, 0);
        assertEquals("4|-", frame.result());
    }

    @Test
    public void 두번쨰_입력받은_점수가_미스일때_출력이_올바른가() {
        Frame frame = makeNormalFrameByDoubleScore(0, 4);
        assertEquals("-|4", frame.result());
    }

    @Test
    public void 입력받은_점수가_거터일때_출력이_올바른가() {
        Frame frame = makeNormalFrameByDoubleScore(0, 0);
        assertEquals("-|-", frame.result());
    }

    private NormalFrame makeNormalFrameByDoubleScore(int first, int second) {
        NormalFrame frame = makeNormalFrame(first);
        if(!frame.isEnd()) {
            return frame.nextRound(Score.in(ofNullable(second)));
        }
        return frame;
    }

    private NormalFrame makeNormalFrame(int first) {
        return NormalFrame.generate(Score.in(ofNullable(first)));
    }
}
