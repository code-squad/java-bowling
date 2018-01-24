package view;

import domain.ScoreBoard;
import domain.frame.BowlingGame;

import java.util.stream.IntStream;

public class ConsoleScoreBoard implements ScoreBoard {

    @Override
    public void printGameResult(BowlingGame bowlingGame) {
        printHeader(Math.max(bowlingGame.size(), 10));
        System.out.println(bowlingGame);
        printLine();
    }

    private void printHeader(int frameSize) {
        System.out.print("| NAME |");
        IntStream.range(0, frameSize)
                 .forEach(i -> System.out.printf(" %02d |", i + 1));
        printLine();
    }

    private void printLine() {
        System.out.println();
    }
}
