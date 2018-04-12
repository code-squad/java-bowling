package bowling.domain;

import static bowling.view.Prompter.promptForThrow;

public class BowlingGame {
    private static final int NUMBER_OF_THROWS = 20;
    private static final int LAST_FRAME = 9;
    private final ScoreBoard scoreBoard;

    public BowlingGame(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void startGame() {
        int frameNumber;
        int pinsKnocked;

        for (int throwCount = 0; throwCount < NUMBER_OF_THROWS; throwCount++) {
            frameNumber = throwCount / 2;

            pinsKnocked = getScore(frameNumber);
            scoreBoard.updateScores(throwCount, pinsKnocked);
            System.out.println(scoreBoard.toString());

            if (scoreBoard.isStrike(frameNumber)) {
                ++throwCount;
            }
        }
        if (scoreBoard.isStrike(LAST_FRAME) || scoreBoard.isSpare(LAST_FRAME)) {
            pinsKnocked = getScore(LAST_FRAME);
            scoreBoard.updateScores(LAST_FRAME, pinsKnocked);
            System.out.println(scoreBoard.toString());
        }
    }

    public int getScore(int frameNumber) {
        try {
            return promptForThrow(frameNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getScore(frameNumber);
        }
    }
}