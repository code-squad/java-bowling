package domain;

import domain.frame.Frame;
import domain.score.FirstScore;

public interface ScoreBoard {

    void printFirstScore(int frameNo, FirstScore firstScore);

    void addFrame(Frame frame);

    void printScoreBoard();
}
