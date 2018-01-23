package view;

import domain.ScoreBoard;
import domain.frame.Frame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleScoreBoard implements ScoreBoard {
    private final List<Frame> frames;

    private final String playerName;

    public ConsoleScoreBoard(String playerName) {
        this.playerName = playerName;
        this.frames = new ArrayList<>();
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
        System.out.print("| " + playerName + "  |");
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
        frames.forEach(f -> System.out.printf("%-4s|", f));
    }

    private void printLine() {
        System.out.println();
    }
}
