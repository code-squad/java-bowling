package bowling.domain;

import bowling.domain.number.Roll;
import bowling.domain.frame.Frames;
import bowling.io.OutPutView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FramesTest {
    @Test(expected = IllegalArgumentException.class)
    public void 프레임_리스트_add() {
        int frameCount = 9;
        Frames frames = new Frames();

        frames.add(new Roll(0));

        // 1Frame
        String expect = OutPutView.frameFormat("-");
        expect += forText(1, frameCount, "");
        assertEquals(expect, frames.toString());

        // 1Frame
        frames.add(new Roll(0));
        expect = OutPutView.frameFormat("-|-");
        expect += forText(1, frameCount, "");
        assertEquals(expect, frames.toString());

        // 2Frame
        frames.add(new Roll(10));
        expect = OutPutView.frameFormat("-|-");
        expect += OutPutView.frameFormat("X");
        expect += forText(2, frameCount, "");
        assertEquals(expect, frames.toString());

        // 3-8Frame
        int startFrame = 3;
        for(int frame=startFrame; frame<frameCount; frame++) {
            frames.add(new Roll(10));
            expect = OutPutView.frameFormat("-|-");
            expect += forText(1,frame,"X");
            expect += forText(frame, frameCount, "");
            assertEquals(expect, frames.toString());
        }

        // 9Frame
        frames.add(new Roll(10));
        expect = OutPutView.frameFormat("-|-");
        expect += forText(1,9,"X");
        expect += forText(9, frameCount, "");
        assertEquals(expect, frames.toString());

        // IllegalArgumentException
        frames.add(new Roll(10));
    }

    private String forText(int from, int to, String text) {
        String _temp = "";
        for (int i = from; i < to; i++) {
            _temp += OutPutView.frameFormat(text);
        }
        return _temp;
    }
}
