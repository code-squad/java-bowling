package saru;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    @Test(expected = IllegalArgumentException.class)
    public void ballCountFail() {
        DownPin.of(11);
    }

    @Test
    public void downPinMake() {
        DownPin.of(0);
        DownPin.of(10);
    }

    @Test
    public void frameMake() {
        Frame.of(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeBallsOverFour() {
        Frame.of(4);
    }

    @Test
    public void throwing() {
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

    @Test
    public void getFirstSecondDownPinCount() {
        Frame frame = Frame.of(2);
        frame.throwing(DownPin.of(5));
        frame.throwing(DownPin.of(4));

        assertEquals(DownPin.of(5), frame.getFirstDownPinCount());
        assertEquals(DownPin.of(4), frame.getSecondDownPinCount());
    }

    @Test
    public void scoreHandlerInit() {
        ScoreHandler scoreHandler = ScoreHandler.of();
        scoreHandler.init();
        assertEquals(0, scoreHandler.getNowPageIndex());
    }

    @Test
    public void scoreHandlerPaginateNotApply() {
        ScoreHandler scoreHandler = ScoreHandler.of();
        scoreHandler.init();
        scoreHandler.pageinate();
        assertEquals(0, scoreHandler.getNowPageIndex());
    }

    @Test
    public void scoreHandlerPaginateApply() {
        ScoreHandler scoreHandler = ScoreHandler.of();
        scoreHandler.init();

        // TODO 프레임 이동
        Frame frame = scoreHandler.getNowFrame();
        frame.throwing(DownPin.of(5));
        frame.throwing(DownPin.of(4));

        scoreHandler.pageinate();
        assertEquals(1, scoreHandler.getNowPageIndex());
    }
}
