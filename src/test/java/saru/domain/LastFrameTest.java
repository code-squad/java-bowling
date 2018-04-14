package saru.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastFrameTest {
    @Test
    public void 마지막프레임스페어미만() {
        ScoreBoard scoreBoard = ScoreBoard.of();

        for (int i = 0; i < 9; i++) {
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.nextFrame();
        }

        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(3));
        scoreBoard.throwing(DownPin.of(3));

        assertEquals(2, scoreBoard.getNowFrame().getDownPinsSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 마지막프레임스페어미만인데합이십넘는경우() {
        ScoreBoard scoreBoard = ScoreBoard.of();

        for (int i = 0; i < 9; i++) {
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.nextFrame();
        }

        scoreBoard.throwing(DownPin.of(5));
        scoreBoard.throwing(DownPin.of(10));
    }

    @Test
    public void 마지막프레임스트라이크() {
        ScoreBoard scoreBoard = ScoreBoard.of();

        for (int i = 0; i < 9; i++) {
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.nextFrame();
        }

        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(3));
        scoreBoard.throwing(DownPin.of(3));

        assertEquals(3, scoreBoard.getNowFrame().getDownPinsSize());
    }

    @Test
    public void 마지막프레임스페어() {
        ScoreBoard scoreBoard = ScoreBoard.of();

        for (int i = 0; i < 9; i++) {
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.nextFrame();
        }

        scoreBoard.throwing(DownPin.of(7));
        scoreBoard.throwing(DownPin.of(3));
        scoreBoard.throwing(DownPin.of(3));

        // full test
        scoreBoard.throwing(DownPin.of(3));

        assertEquals(3, scoreBoard.getNowFrame().getDownPinsSize());
    }
}
