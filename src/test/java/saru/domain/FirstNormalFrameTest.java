package saru.domain;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class FirstNormalFrameTest {
    private Frame normalFrame;

    @Before
    public void init() {
        normalFrame = NormalFrame.of();
    }

    @Test
    public void downPinOf() {
        DownPin.of(10);
        NormalFrame.of();
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalDownPinOf() {
        DownPin.of(11);
    }

    @Test
    public void nowPinCount() {
        normalFrame.throwing(DownPin.of(5));
        assertEquals(DownPin.of(5), normalFrame.getNowDownPin());
        assertEquals(DownPin.of(5).hashCode(), normalFrame.getNowDownPin().hashCode());
    }

    @Test
    public void nowBallCount() {
        normalFrame.throwing(DownPin.of(5));
        assertEquals(1, normalFrame.getDownPinsSize());
    }

    //==============================================================

    @Test
    public void 맨처음십넣었을떄첫프레임() {
        normalFrame.throwing(DownPin.of(10));
        assertFalse(normalFrame.checkThrowingPossible());
    }

    @Test
    public void 그냥하나넣었을때첫프레임() {
        normalFrame.throwing(DownPin.of(3));
        assertTrue(normalFrame.checkThrowingPossible());
    }

    @Test
    public void 두개넣어서십이상일때첫프레임() {
        normalFrame.throwing(DownPin.of(3));
        normalFrame.throwing(DownPin.of(7));
        assertFalse(normalFrame.checkThrowingPossible());
    }

    @Test
    public void 세번넣었을때첫프레임() {
        normalFrame.throwing(DownPin.of(3));
        normalFrame.throwing(DownPin.of(7));
        normalFrame.throwing(DownPin.of(7));
        assertEquals(2, normalFrame.getDownPinsSize());
    }

    @Test
    public void 스트라이크넣고또넣었을떄첫프레임() {
        normalFrame.throwing(DownPin.of(10));
        normalFrame.throwing(DownPin.of(3));
        assertEquals(1, normalFrame.getDownPinsSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 두번넣는데합이십이상일때첫프레임() {
        normalFrame.throwing(DownPin.of(5));
        normalFrame.throwing(DownPin.of(7));
    }

    @Test
    public void 현재프레임다운핀즈카피리턴받기() {
        normalFrame.throwing(DownPin.of(10));

        List<DownPin> downPins = new ArrayList<>();
        downPins.add(DownPin.of(10));

        assertEquals(downPins, normalFrame.copyDownPins());
    }
}
