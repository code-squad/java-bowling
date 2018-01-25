package bowling.domain;

import bowling.domain.Score.Roll;
import bowling.domain.frame.Frame;
import bowling.domain.number.Pins;
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
        Frame newGutter = gutter.add(new Roll(new Pins(0)));
        assertEquals(OutPutView.frameFormat("-"),newGutter.toString());
        Frame gutterGutter = gutter.add(new Roll(new Pins(0)));
        assertEquals(OutPutView.frameFormat("-|-"),gutterGutter.toString());

        Frame spare = new Frame().add(new Roll(new Pins(2)));
        assertEquals(OutPutView.frameFormat("2"),spare.toString());
        Frame spared = spare.add(new Roll(new Pins(8)));
        assertEquals(OutPutView.frameFormat("2|/"),spared.toString());

        Frame eight = new Frame();
        assertEquals(OutPutView.frameFormat(""),eight.toString());
        Frame newFrame = eight.add(new Roll(new Pins(8)));
        assertEquals(OutPutView.frameFormat("8"),newFrame.toString());
        Frame eightBarEight = eight.add(new Roll(new Pins(8)));
        assertEquals(OutPutView.frameFormat("8|8"),eightBarEight.toString());
        Frame exceptionOccurred = eight.add(new Roll(new Pins(8)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void 프레임_준비_Score_스트라이크_1개_초과_예외처리_add() {
        Frame strike = new Frame().add(new Roll(new Pins(10)));
        Frame exceptionOccurred = strike.add(new Roll(new Pins(0)));
    }

    @Test
    public void 프레임이_비어있는지_확인() {
        Frame frame = new Frame();
        assertTrue(frame.hasEmptyScore());

        assertTrue(frame.add(new Roll(new Pins(8))).hasEmptyScore());
        assertFalse(frame.add(new Roll(new Pins(0))).hasEmptyScore());
    }

    @Test
    public void 현재_프레임_찾기() {
        Player abc = new Player(new Name("abc"));
        assertEquals(1, abc.currentFrame());
        abc.roll(new Pins(9));
        assertEquals(1, abc.currentFrame());
        abc.roll(new Pins(0));
        assertEquals(2, abc.currentFrame());
        for (int i = 3; i < 10; i++) {
            abc.roll(new Pins(10));
            assertEquals(i, abc.currentFrame());
        }
        assertEquals(9, abc.currentFrame());

        abc.roll(new Pins(10));
        assertEquals(10, abc.currentFrame());
        abc.roll(new Pins(10));
        assertEquals(10, abc.currentFrame());
        abc.roll(new Pins(10));
        assertEquals(10, abc.currentFrame());
    }
}