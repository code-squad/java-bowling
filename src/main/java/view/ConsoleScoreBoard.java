package view;

import domain.Player;
import domain.ScoreBoard;
import domain.frame.Frame;
import domain.score.FirstScore;

import java.util.ArrayList;
import java.util.List;

public class ConsoleScoreBoard implements ScoreBoard {
    private final List<Frame> frames = new ArrayList<>();

    private final Player player;

    public ConsoleScoreBoard(Player player) {
        this.player = player;
    }

    @Override
    public void printFirstScore(int frameNo, FirstScore firstScore) {

    }

    @Override
    public void printFrame(Frame frame) {
        frames.add(frame);
        printFrames();
    }

    @Override
    public void printPlayer() {
        System.out.print(player);
    }

    private void printFrames() {
        frames.forEach(System.out::print);
        System.out.println();
    }
}
