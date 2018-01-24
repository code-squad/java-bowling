package controller;

import model.FrameResult;
import model.frame.Frame;
import model.frame.NormalFrame;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Frame headFrame;
    private String playerName;

    public GameManager() {
        headFrame = new NormalFrame(1);
    }

    public void run() {
        this.playerName = ConsoleView.askName();
        Frame currentFrame = this.headFrame;
        while (currentFrame != null) {
            runFrame(currentFrame);

            currentFrame = getFrame(currentFrame);
        }
    }

    private void runFrame(Frame currentFrame) {
        currentFrame.bowl(ConsoleView.askPinCount(currentFrame.getRound()));
        ConsoleView.printScoreBoard(playerName, createFrameResults());
    }

    private Frame getFrame(Frame currentFrame) {
        if (currentFrame.isFinished()) {
            currentFrame = currentFrame.getNextFrame();
        }
        return currentFrame;
    }

    private List<FrameResult> createFrameResults() {
        List<FrameResult> frameResults = new ArrayList<>();

        Frame currentFrame = this.headFrame;

        int scoreSum = 0;
        while (currentFrame != null) {
            scoreSum += getReducedScoreSum(currentFrame);

            frameResults.add(new FrameResult(currentFrame.toString(), getScoreString(frameResults, currentFrame, scoreSum)));
            currentFrame = currentFrame.getNextFrame();
        }

        return frameResults;
    }

    private int getReducedScoreSum(Frame currentFrame) {
        if (currentFrame.isFinished())
            return currentFrame.getScoreSum();

        return 0;
    }

    private String getScoreString(List<FrameResult> frameResults, Frame currentFrame, int scoreSum) {
        String str = "";

        if (currentFrame.isFinished()) {
            str = String.valueOf(scoreSum);
        }

        if ((frameResults.size() > 0 && frameResults.get(frameResults.size() - 1).getScore().isEmpty())
                || currentFrame.getScoreSum() == -1) {
            str = "";
        }
        return str;
    }
}
