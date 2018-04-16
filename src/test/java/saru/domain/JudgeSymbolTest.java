package saru.domain;

import org.junit.Before;
import org.junit.Test;
import saru.BowlSymbol;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JudgeSymbolTest {
    private ScoreBoard scoreBoard;

    @Before
    public void init() {
        scoreBoard = ScoreBoard.of(User.of("ABC"));

        for (int i = 0; i < 9; i++) {
            scoreBoard.throwing(DownPin.of(5));
            scoreBoard.throwing(DownPin.of(5));
        }
    }

    @Test
    public void 마지막프레임카피리턴테스트() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(8));

        List<DownPin> downPins = frame.copyDownPins();
        assertEquals(3, downPins.size());
    }

    @Test
    public void 첫번째위치테스트1() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 첫번째위치테스트2() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(3));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 두번째위치테스트1() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(6));
        scoreBoard.throwing(DownPin.of(4));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.SPARE, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 두번째위치테스트2() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 두번째위치테스트3() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(3));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 세번째위치테스트1() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(0));
        scoreBoard.throwing(DownPin.of(10));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.SPARE, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 세번째위치테스트2() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 세번째위치테스트3() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(8));
        scoreBoard.throwing(DownPin.of(10));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(downPins));
    }

    @Test
    public void 세번째위치테스트4() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(8));
        scoreBoard.throwing(DownPin.of(2));

        List<DownPin> downPins = frame.copyDownPins();

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(downPins));
    }
}

/*
X|X|X
X|X|3
X|3|/
X|3|4
3|/|4
3|/|X
3|4
 */