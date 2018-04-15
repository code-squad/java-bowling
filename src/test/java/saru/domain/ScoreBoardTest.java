package saru.domain;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @Before
    public void init() {
        scoreBoard = ScoreBoard.of(User.of("ABC"));
    }

    @Test
    public void 스코어보드테스트() {
        assertEquals(10, scoreBoard.getFrameSize());
    }

    @Test
    public void 현재프레임에던지기() {
        int nowFrameDownPinsSize = scoreBoard.throwing(DownPin.of(10));
        assertEquals(1, nowFrameDownPinsSize);
    }

    @Test
    public void 다음프레임으로넘기기() {
        scoreBoard.throwing(DownPin.of(10));
        //scoreBoard.nextFrame();
        assertEquals(1, scoreBoard.getNowFrameIndex());
    }

    @Test
    public void 수동입력테스트() {
        assertEquals(0, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(4));
        scoreBoard.throwing(DownPin.of(6));

        assertEquals(1, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(3));
        scoreBoard.throwing(DownPin.of(6));

        assertEquals(2, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(3, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(4));
        scoreBoard.throwing(DownPin.of(3));

        assertEquals(4, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(5, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(0));
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(6, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(7, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(9));
        scoreBoard.throwing(DownPin.of(1));

        assertEquals(8, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(9, scoreBoard.getNowFrameIndex());
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));
    }
}
