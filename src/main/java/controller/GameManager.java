package controller;

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
        ConsoleView.printScoreBoard(playerName, frameStatusToString(), frameScoreToString());
    }

    private Frame getFrame(Frame currentFrame) {
        if (currentFrame.isFinished()) {
            currentFrame = currentFrame.getNextFrame();
        }
        return currentFrame;
    }

    private List<String> frameStatusToString() {
        List<String> statusStrings = new ArrayList<>();

        Frame currentFrame = this.headFrame;

        while (currentFrame != null) {
            statusStrings.add(currentFrame.toString());

            currentFrame = currentFrame.getNextFrame();
        }

        return statusStrings;
    }

    private List<String> frameScoreToString() {
        List<String> scoreStrings = new ArrayList<>();

        Frame currentFrame = this.headFrame;

        int scoreSum = 0;

        while (currentFrame != null) {
            scoreSum += getReducedScoreSum(currentFrame);

            scoreStrings.add(getString(scoreStrings, currentFrame, scoreSum));
            currentFrame = currentFrame.getNextFrame();
        }

        return scoreStrings;
    }

    private int getReducedScoreSum(Frame currentFrame) {
        if (currentFrame.isFinished())
            return currentFrame.getScoreSum();

        return 0;
    }

    private String getString(List<String> scoreStrings, Frame currentFrame, int scoreSum) {
        String str = "";

        if (currentFrame.isFinished()) {
            str = String.valueOf(scoreSum);
        }

        if ((scoreStrings.size() > 0 && scoreStrings.get(scoreStrings.size() - 1).isEmpty())
                || currentFrame.getScoreSum() == -1) {
            str = "";
        }
        return str;
    }
}
