package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FrameTest {
    private Frame testFrame;

    @Before
    public void setUp() throws Exception {
        testFrame = new Frame();
        testFrame.addScore(5);
        testFrame.addScore(4);
    }

    @Test
    public void 프레임_점수_추가() {
        Frame frame = new Frame();
        frame.addScore(5);
        frame.addScore(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 프레임_점수_오버추가() {
        Frame frame = new Frame();
        frame.addScore(10);
        frame.addScore(2);
    }

    /*@Test
    public void 프레임_종료_체크() {
        //상태변경이 내부에서 되도록 코드짜기
        assertTrue(testFrame.isFinish());
    }*/
}
