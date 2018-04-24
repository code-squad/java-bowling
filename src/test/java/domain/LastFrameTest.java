package domain;

import org.junit.Before;
import org.junit.Test;
import state.Open;
import state.Spare;
import state.State;
import state.Strike;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LastFrameTest {
    private List<Frame> frames;
    private Frame lastFrame;

    @Before
    public void setup() {
        frames = new ArrayList<>();
        for (int index = 0; index < 9; index++) {
            Frame frame = new NormalFrame(index + 1);
            frame.bowl(new Pins(1));
            frame.bowl(new Pins(9));
            frames.add(frame);
        }
        lastFrame = frames.get(8).next();
    }

    @Test
    public void updateStateToStrike() {
        State state = lastFrame.updateState(new Pins(10));
        assertTrue(Strike.isStrike(state));
    }

    @Test
    public void updateStateToOpen() {
        lastFrame.bowl(new Pins(1)); // 초구
        State state = lastFrame.updateState(new Pins(8));
        assertTrue(Open.isOpen(state));
    }

    @Test
    public void updateStateToSpare() {
        lastFrame.bowl(new Pins(1));
        State state = lastFrame.updateState(new Pins(9));
        assertTrue(Spare.isSpare(state));
    }

    @Test
    public void endCondition1() {
        // open
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(8));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition2() {
        // spare 후 한 번의 보너스 투구
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(9));
        lastFrame.bowl(new Pins(10));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition3() {
        // 초구 스트라이크 이후 Spare
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(9));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition4() {
        // 초구 스트라이크 이후 Open
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(8));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition5() {
        // 초구, 2구 모두 스트라이크 이후 마지막 투구
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(1));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition6() {
        // 3번 모두의 스트라이크
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        assertTrue(lastFrame.isEnd());
    }
}
