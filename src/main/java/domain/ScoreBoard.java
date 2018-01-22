package domain;

import domain.frame.Frame;
import domain.score.FirstScore;
import domain.score.TotalScore;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Frame> frames = new ArrayList<>();

    private final Player player;

    public ScoreBoard(Player player) {
        this.player = player;
    }

    public void printFirstScore(Frame frame, FirstScore firstScore) {

    }

    public void printFrame(Frame frame) {

    }

    public void printTotalScore(Frame frame, TotalScore totalScore) {

    }
}
