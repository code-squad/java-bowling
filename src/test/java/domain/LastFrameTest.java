package domain;

import org.junit.Before;
import org.junit.Test;
import org.omg.SendingContext.RunTime;
import state.Open;
import state.Spare;
import state.State;
import state.Strike;
import view.ResultView;

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
            frame.throwing(1);
            frame.throwing(9);
            frames.add(frame);
        }
        lastFrame = frames.get(8).next();
    }

    @Test
    public void throwing() {
        lastFrame.throwing(1);
        lastFrame.throwing(8);
        frames.add(lastFrame);
        ResultView.printFrames(frames, "HTW");
    }

    @Test
    public void updateStateToStrike() {
        State state = lastFrame.updateState(10);
        assertTrue(Strike.isStrike(state));
    }

    @Test
    public void updateStateToOpen() {
        lastFrame.throwing(1); // 초구
        State state = lastFrame.updateState(8);
        assertTrue(Open.isOpen(state));
    }

    @Test
    public void updateStateToSpare() {
        lastFrame.throwing(1);
        State state = lastFrame.updateState(9);
        assertTrue(Spare.isSpare(state));
    }

    @Test
    public void endCondition1() {
        // open
        lastFrame.throwing(1);
        lastFrame.throwing(8);
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition2() {
        // spare 후 한 번의 보너스 투구
        lastFrame.throwing(1);
        lastFrame.throwing(9);
        lastFrame.throwing(10);
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition3() {
        // 초구 스트라이크 이후 Spare
        lastFrame.throwing(10);
        lastFrame.throwing(1);
        lastFrame.throwing(9);
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition4() {
        // 초구 스트라이크 이후 Open
        lastFrame.throwing(10);
        lastFrame.throwing(1);
        lastFrame.throwing(8);
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition5() {
        // 초구, 2구 모두 스트라이크 이후 마지막 투구
        lastFrame.throwing(10);
        lastFrame.throwing(10);
        lastFrame.throwing(1);
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void endCondition6() {
        // 3번 모두의 스트라이크
        lastFrame.throwing(10);
        lastFrame.throwing(10);
        lastFrame.throwing(10);
        assertTrue(lastFrame.isEnd());
    }
}
