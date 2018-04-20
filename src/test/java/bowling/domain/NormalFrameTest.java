package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalFrameTest {

    private Frame normalFrame;

    @Before
    public void setup() {
        normalFrame = NormalFrame.ofInComplete();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkSecondBallExceptionTest() { //두번째 핀과의 합이 10 초과 일때
        normalFrame.updateFrameStatus(5);
        normalFrame.updateFrameStatus(6);
    }

    @Test
    public void checkCompleteTest() { //스트라이크이거나 2번 쳤을때 true
        normalFrame.updateFrameStatus(5);
        normalFrame.updateFrameStatus(4);
        assertEquals(normalFrame.checkComplete(), true);
    }

    @Test
    public void checkCompleteTest2() { //스트라이크이거나 2번 쳤을때 true
        normalFrame.updateFrameStatus(10);
        assertEquals(normalFrame.checkComplete(), true);
    }
}