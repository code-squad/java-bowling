package saru;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    @Test(expected = IllegalArgumentException.class)
    public void ballCountFail() {
        DownPin.of(11);
    }

    @Test
    public void ballCount() {
        DownPin.of(0);
        DownPin.of(10);
    }

    @Test
    public void makeBalls() {
        투구현황.of(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeBallsOverFour() {
        투구현황.of(4);
    }

    @Test
    public void 투구() {
        투구현황 투구현황_ = 투구현황.of(2);
        투구현황_.투구(DownPin.of(5));
        assertEquals(DownPin.of(5), 투구현황_.투구결과());
    }

    @Test
    public void 현재투구횟수() {
        투구현황 투구현황_ = 투구현황.of(2);
        투구현황_.투구(DownPin.of(5));
        assertEquals(1, 투구현황_.현재투구횟수());
    }
}
