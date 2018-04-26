package domain;

import org.junit.Before;
import org.junit.Test;
import state.Open;
import state.Ready;
import state.State;
import state.Strike;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
        State state = lastFrame.bowl(new Pins(10));
        assertTrue(Strike.isStrike(state));
    }

    @Test
    public void updateStateToOpen() {
        lastFrame.bowl(new Pins(1)); // 초구
        State state = lastFrame.bowl(new Pins(8));
        assertTrue(Open.isOpen(state));
    }

    @Test
    public void updateState() {
        // 내부적으로 다음 상태를 위해 Open을 제외한 나머지의 경우 Ready로 초기화
        State state = lastFrame.bowl(new Pins(1));
        state = lastFrame.bowl(new Pins(9));
        assertTrue(Ready.isReady(state));
    }

    @Test
    public void isEnd_open일때() {
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(8));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void isEnd_spare후_보너스투구() {
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(9));
        lastFrame.bowl(new Pins(10));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void isEnd_초구스트라이크후_spare() {
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(9));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void isEnd_초구스트라이크후_open() {
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(8));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void isEnd_초구_2구_스트라이크후_마지막투구() {
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(1));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void isEnd_세번모두스트라이크() {
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        assertTrue(lastFrame.isEnd());
    }

    @Test
    public void printState_모두스트라이크() {
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        lastFrame.bowl(new Pins(10));
        assertThat(lastFrame.printState(), is("XXX"));
    }

    @Test
    public void printState_spare후_스트라이크() {
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(9));
        lastFrame.bowl(new Pins(10));
        assertThat(lastFrame.printState(), is("1|/X"));
    }

    @Test
    public void printState_open() {
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(8));
        assertThat(lastFrame.printState(), is("1|8"));
    }

    @Test
    public void createScore() {
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(8));
        Score score = lastFrame.createScore(10);
        assertThat(score.getScore(), is(19));
    }

    @Test
    public void getScore() {
        lastFrame.bowl(new Pins(1));
        lastFrame.bowl(new Pins(9));
        lastFrame.bowl(new Pins(10));
        assertThat(lastFrame.getScore(10), is(30));
    }
}
