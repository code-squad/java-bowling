package saru;

import saru.domain.DownPin;
import saru.domain.ScoreBoard;
import saru.view.BowlingInput;
import saru.view.BowlingOutput;

public class BowlingController {
    private static final int MAX_FRAME_INDEX = 10;
    private BowlingInput bowlingInput = new BowlingInput();

    public static BowlingController of() {
        return new BowlingController();
    }

    void run() {
        ScoreBoard scoreBoard = ScoreBoard.of(bowlingInput.getUserInput());
        BowlingOutput bowlingOutput = new BowlingOutput(scoreBoard);

        while (scoreBoard.getNowFrameIndex() < MAX_FRAME_INDEX) {
            // 입력 받는다
            int throwingNum = bowlingInput.getThrowNum(scoreBoard);

            // 던진다
            scoreBoard.throwing(DownPin.of(throwingNum));

            // 결과출력
            bowlingOutput.printScore();
        }
    }
}