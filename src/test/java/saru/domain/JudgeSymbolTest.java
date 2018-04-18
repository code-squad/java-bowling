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
    public void 라스트프레임_첫번째위치테스트1() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(frame, 0));
    }

    @Test
    public void 라스트프레임_첫번째위치테스트2() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(3));

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(frame, 0));
    }

    @Test
    public void 라스트프레임_두번째위치테스트1() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(6));
        scoreBoard.throwing(DownPin.of(4));

        assertEquals(BowlSymbol.SPARE, JudgeSymbol.judge(frame, 1));
    }

    @Test
    public void 라스트프레임_두번째위치테스트2() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(frame, 1));
    }

    @Test
    public void 라스트프레임_두번째위치테스트3() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(3));

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(frame, 1));
    }

    @Test
    public void 라스트프레임_세번째위치테스트1() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(0));
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(BowlSymbol.SPARE, JudgeSymbol.judge(frame, 2));
    }

    @Test
    public void 라스트프레임_세번째위치테스트2() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(frame, 2));
    }

    @Test
    public void 라스트프레임_세번째위치테스트3() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(8));
        scoreBoard.throwing(DownPin.of(10));

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(frame, 2));
    }

    @Test
    public void 라스트프레임_세번째위치테스트4() {
        Frame frame = scoreBoard.getNowFrame();
        scoreBoard.throwing(DownPin.of(2));
        scoreBoard.throwing(DownPin.of(8));
        scoreBoard.throwing(DownPin.of(2));

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(frame, 2));
    }

    @Test
    public void 노멀프레임_첫번째위치테스트1() {
        ScoreBoard normalBoard = ScoreBoard.of(User.of("DEF"));

        for (int i = 0; i < 3; i++) {
            normalBoard.throwing(DownPin.of(10));
        }

        normalBoard.throwing(DownPin.of(10));
        Frame frame = normalBoard.getPreFrame();

        assertEquals(BowlSymbol.STRIKE, JudgeSymbol.judge(frame, 0));
    }

    @Test
    public void 노멀프레임_첫번째위치테스트2() {
        ScoreBoard normalBoard = ScoreBoard.of(User.of("DEF"));

        for (int i = 0; i < 3; i++) {
            normalBoard.throwing(DownPin.of(10));
        }

        normalBoard.throwing(DownPin.of(3));
        Frame frame = normalBoard.getNowFrame();

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(frame, 0));
    }

    @Test
    public void 노멀프레임_두번째위치테스트1() {
        ScoreBoard normalBoard = ScoreBoard.of(User.of("DEF"));

        for (int i = 0; i < 3; i++) {
            normalBoard.throwing(DownPin.of(10));
        }

        normalBoard.throwing(DownPin.of(3));
        normalBoard.throwing(DownPin.of(7));
        Frame frame = normalBoard.getPreFrame();

        assertEquals(BowlSymbol.SPARE, JudgeSymbol.judge(frame, 1));
    }

    @Test
    public void 노멀프레임_두번째위치테스트2() {
        ScoreBoard normalBoard = ScoreBoard.of(User.of("DEF"));

        for (int i = 0; i < 3; i++) {
            normalBoard.throwing(DownPin.of(10));
        }

        normalBoard.throwing(DownPin.of(3));
        normalBoard.throwing(DownPin.of(4));
        Frame frame = normalBoard.getPreFrame();

        assertEquals(BowlSymbol.NORMAL, JudgeSymbol.judge(frame, 1));
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

X
3|/
3|4
 */