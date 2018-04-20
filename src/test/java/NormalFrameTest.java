import domain.Frame;
import domain.NormalFrame;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NormalFrameTest {

    /**
     * 1. 프레임 생성
     * 2. 첫번째 투구 득점
     * 3. 두번째 투구 득점
     */
    @Test
    public void 프레임생성() {
        Frame frame = new NormalFrame(1);
        assertEquals(1, frame.getFrameNo());
    }

    @Test
    public void 첫번째투구득점() {
        Frame frame = new NormalFrame(1);
        frame.setFallingPinNum(10);
        assertEquals(10, frame.getFirstRoll());
    }

    @Test
    public void 두번째투구득점() {
        Frame frame = new NormalFrame(1);
        frame.setFallingPinNum(3);
        frame.setFallingPinNum(7);
        assertEquals(7, frame.getSecondRoll());

    }

}
