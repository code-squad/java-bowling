package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InCompleteNormalFrameTest {

    private InCompleteFrame inCompleteFrame;

    @Before
    public void setup() {
        inCompleteFrame = new InCompleteFrame();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSecondBallExceptionTest() { //두번째 핀과의 합이 10 초과 일때
        inCompleteFrame.play(5);
        inCompleteFrame.play(6);
    }

    @Test
    public void checkCompleteTest() { //스트라이크이거나 2번 쳤을때 true
        inCompleteFrame.play(5);
        inCompleteFrame.play(4);
        assertEquals(inCompleteFrame.checkComplete(), true);
    }

    @Test
    public void checkCompleteTest2() { //스트라이크이거나 2번 쳤을때 true
        inCompleteFrame.play(10);
        assertEquals(inCompleteFrame.checkComplete(), true);
    }
}