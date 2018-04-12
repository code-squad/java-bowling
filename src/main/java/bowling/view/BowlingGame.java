package bowling.view;

import bowling.domain.Player;

import static bowling.view.Prompter.promptForThrow;

public class BowlingGame {
    private static final int NUMBER_OF_THROWS = 20;
    private static final int LAST_FRAME = 9;
    private static final ScoreBoard SCORE_BOARD = new ScoreBoard();
    private final Player player;

    public BowlingGame(Player player) {
        this.player = player;
    }

    public void startGame() {
        proceedUntilLastFrame();
        playLastFrame();
    }

    private void proceedUntilLastFrame() {
        for (int throwCount = 0; throwCount < NUMBER_OF_THROWS; throwCount++) {
            int frameNumber = throwCount / 2;
            getAndUpdateScores(frameNumber);
            SCORE_BOARD.printScoreBoard(player);
            if (player.isStrike(frameNumber)) {
                throwCount++;
            }
        }
    }

    private void playLastFrame() {
        if (player.isStrike(LAST_FRAME) || player.isSpare(LAST_FRAME)) {
            getAndUpdateScores(LAST_FRAME);
            SCORE_BOARD.printScoreBoard(player);
        }
    }

    private boolean getAndUpdateScores(int frameNumber) {
        try {
            int pinsKnocked = promptForThrow(frameNumber);
            return player.updateScores(frameNumber, pinsKnocked);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAndUpdateScores(frameNumber);
        }
    }
}