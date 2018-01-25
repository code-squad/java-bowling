package bowling.domain;

import bowling.domain.Score.Score;
import bowling.domain.number.Roll;
import bowling.domain.frame.Frame;
import bowling.io.OutPutView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameTest {

    @Test (expected = IllegalArgumentException.class)
    public void 프레임_준비_Score_스패어_거터_2개_까지만_add() {

        Frame gutter = new Frame();
        assertEquals(OutPutView.frameFormat(""),gutter.toString());
        Score newGutter = gutter.add(new Roll(0));
        assertEquals("-",newGutter.toString());
        Score gutterGutter = gutter.add(new Roll(0));
        assertEquals("-|-",gutterGutter.toString());

        Score spare = new Frame().add(new Roll(2));
        assertEquals("2",spare.toString());
        Score spared = spare.add(new Roll(8));
        assertEquals("2|/",spared.toString());

        Frame eight = new Frame();
        Score newFrame = eight.add(new Roll(8));
        assertEquals("8",newFrame.toString());
        Score eightBarEight = eight.add(new Roll(8));
        assertEquals("8|8",eightBarEight.toString());
        Score exceptionOccurred = eight.add(new Roll(8));
    }

    @Test (expected = IllegalArgumentException.class)
    public void 프레임_준비_Score_스트라이크_1개_초과_예외처리_add() {
        Score strike = new Frame().add(new Roll(10));
        Score exceptionOccurred = strike.add(new Roll(0));
    }

    @Test
    public void 프레임이_비어있는지_확인() {
        Frame frame = new Frame();
        assertTrue(frame.hasEmptyScore());

        assertTrue(frame.add(new Roll(8)).isEmpty());
        assertFalse(frame.add(new Roll(0)).isEmpty());
    }

    @Test
    public void 현재_프레임_찾기() {
        Player abc = new Player(new Name("abc"));
        assertEquals(1, abc.currentFrame());
        abc.roll(9);
        assertEquals(1, abc.currentFrame());
        abc.roll(0);
        assertEquals(2, abc.currentFrame());
        for (int i = 3; i < 10; i++) {
            abc.roll(10);
            assertEquals(i, abc.currentFrame());
        }
        assertEquals(9, abc.currentFrame());

        // 10프레임은 3번까지 가능하므로,
        for (int i = 0; i < 3; i++) {
            abc.roll(10);
            assertEquals(10, abc.currentFrame());
        }
    }
}