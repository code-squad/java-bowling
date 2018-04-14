package saru.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreBoardTest {
    @Test
    public void 스코어보드테스트() {
        ScoreBoard scoreBoard = ScoreBoard.of();
        assertEquals(10, scoreBoard.getFrameSize());
    }

    @Test
    public void 현재프레임에던지기() {
        ScoreBoard scoreBoard = ScoreBoard.of();
        int nowFrameDownPinsSize = scoreBoard.throwing(DownPin.of(10));
        assertEquals(1, nowFrameDownPinsSize);
    }

    @Test
    public void 다음프레임으로넘기기() {
        ScoreBoard scoreBoard = ScoreBoard.of();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.nextFrame();
        assertEquals(1, scoreBoard.getNowFrameIndex());
    }
}
