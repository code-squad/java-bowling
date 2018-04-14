package saru.view;

import saru.domain.*;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BowlingOutputTest {
    private ScoreBoard scoreBoard;
    private BowlingOutput bowlingOutput;

    @Before
    public void init() {
        scoreBoard = ScoreBoard.of();
        initData();
        bowlingOutput = new BowlingOutput(scoreBoard);
    }

    @Test
    public void 볼링컨트롤러() {
        //System.out.println(scoreBoard);

        String[] frameResult = {bowlingOutput.getFrameResult(0),
                bowlingOutput.getFrameResult(1),
                bowlingOutput.getFrameResult(2),
                bowlingOutput.getFrameResult(3),
                bowlingOutput.getFrameResult(4),
                bowlingOutput.getFrameResult(5),
                bowlingOutput.getFrameResult(6),
                bowlingOutput.getFrameResult(7),
                bowlingOutput.getFrameResult(8),
                bowlingOutput.getFrameResult(9)};

        System.out.printf(
                "%d프레임 투구 : %d\n" +
                        "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n" +
                        "|  PJS |%6s|%6s|%6s|%6s|%6s|%6s|%6s|%6s|%6s|%6s|\n",
                scoreBoard.getNowFrameIndex() + 1, 0,
                frameResult[0],
                frameResult[1],
                frameResult[2],
                frameResult[3],
                frameResult[4],
                frameResult[5],
                frameResult[6],
                frameResult[7],
                frameResult[8],
                frameResult[9]);
    }

    public void initData() {
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
        scoreBoard.throwing(DownPin.of(0));
        scoreBoard.throwing(DownPin.of(10));
        assertEquals(9, scoreBoard.getNowFrameIndex());
    }
}
