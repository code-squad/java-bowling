package view;

import domain.Player;
import domain.ScoreBoard;
import domain.frame.Frame;
import domain.score.FirstScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleScoreBoard implements ScoreBoard {
    private final List<Frame> frames;

    private final Player player;

    public ConsoleScoreBoard(Player player) {
        this.player = player;
        this.frames = new ArrayList<>();
    }

    @Override
    public void printFirstScore(int frameNo, FirstScore firstScore) {
        int frameSizeIncludeFirstScore = frames.size() + 1;

        printHeader(Math.max(frames.size(), frameSizeIncludeFirstScore));
        printPlayer();
        printFrames();
        printFirstScore(firstScore);
        printRemainFrames(10 - frameSizeIncludeFirstScore);
        printLine();
    }

    @Override
    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    @Override
    public void printScoreBoard() {
        printHeader(Math.max(frames.size(), 10));
        printPlayer();
        printFrames();
        printRemainFrames(10 - frames.size());
        printLine();
    }

    private void printPlayer() {
        System.out.print(player);
    }

    private void printHeader(int frameSize) {
        System.out.print("| NAME |");
        IntStream.range(0, frameSize)
                 .forEach(i -> System.out.printf(" %02d |", i + 1));
        printLine();
    }

    private void printFirstScore(FirstScore firstScore) {
        System.out.printf("%-4s|", firstScore);
    }

    private void printRemainFrames(int remain) {
        if (remain > 0) {
            IntStream.range(0, remain)
                     .forEach(i -> System.out.print("    |"));
        }
    }

    private void printFrames() {
        frames.forEach(f -> System.out.printf("%-4s|", f));
    }

    private void printLine() {
        System.out.println();
    }
}
