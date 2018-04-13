package saru;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingTest {
    @Test
    public void ballOf() {
        DownPin.of(10);
        Frame.of(2);
    }

    @Test
    public void nowPinCount() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(5));
        assertEquals(DownPin.of(5), frame.getNowDownPinCount());
    }

    @Test
    public void nowBallCount() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(5));
        assertEquals(1, frame.getNowBallCount());
    }

    //==============================================================

    @Test
    public void 맨처음십넣었을떄첫프레임() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(10));
        assertFalse(frame.checkThrowingPossible());
    }

    @Test
    public void 그냥하나넣었을때첫프레임() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(3));
        assertTrue(frame.checkThrowingPossible());
    }

    @Test
    public void 두개넣어서십이상일때첫프레임() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(3));
        frame.throwing(DownPin.of(7));
        assertFalse(frame.checkThrowingPossible());
    }

    @Test
    public void 세번넣었을때첫프레임() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(3));
        frame.throwing(DownPin.of(7));
        frame.throwing(DownPin.of(7));
        assertEquals(2, frame.getNowBallCount());
    }

    @Test
    public void 스트라이크넣고또넣었을떄첫프레임() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(10));
        frame.throwing(DownPin.of(3));
        assertEquals(1, frame.getNowBallCount());
    }
}
