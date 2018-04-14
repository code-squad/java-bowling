package saru;

import saru.domain.DownPin;
import saru.domain.ScoreBoard;
import saru.view.BowlingInput;
import saru.view.BowlingOutput;

public class BowlingController {
    public BowlingController() {
    }

    public static BowlingController of() {
        return new BowlingController();
    }

    public void run() {
        ScoreBoard scoreBoard = ScoreBoard.of();
        BowlingInput bowlingInput = new BowlingInput(scoreBoard);
        BowlingOutput bowlingOutput = new BowlingOutput(scoreBoard);

        while (scoreBoard.getNowFrameIndex() < 10) {
            // 입력 받는다
            int throwingNum = bowlingInput.getUserInput();

            // 던진다
            scoreBoard.throwing(DownPin.of(throwingNum));

            // 결과출력
            bowlingOutput.printScore();
        }
    }
}