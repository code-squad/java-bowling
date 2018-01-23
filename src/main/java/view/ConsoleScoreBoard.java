package view;

import domain.Player;
import domain.ScoreBoard;
import domain.frame.Frame;
import domain.score.FirstScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleScoreBoard implements ScoreBoard {
    private final List<Frame> frames = new ArrayList<>();

    private final Player player;

    public ConsoleScoreBoard(Player player) {
        this.player = player;
    }

    @Override
    public void addFirstScore(int frameNo, FirstScore firstScore) {

    }

    @Override
    public void addFrame(Frame frame) {
        frames.add(frame);
        printScoreBoard();
    }

    @Override
    public void printScoreBoard() {
        printHeader(Math.max(frames.size(), 10));
        printFrameResult();
    }

    private void printFrameResult() {
        System.out.print(player);
        printFrames();
        printRemainFrames(10 - frames.size());
        printLine();
    }

    private void printHeader(int frameSize) {
        System.out.print("| NAME |");
        IntStream.range(0, frameSize)
                 .forEach(i -> System.out.printf(" %02d |", i + 1));
        printLine();
    }

    private void printRemainFrames(int remain) {
        if (remain > 0) {
            IntStream.range(0, remain)
                     .forEach(i -> System.out.print("    |"));
        }
    }

    private void printFrames() {
        frames.forEach(f -> System.out.printf("%4s|", f));
    }

    private void printLine() {
        System.out.println();
    }
}
