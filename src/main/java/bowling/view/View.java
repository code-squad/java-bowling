package bowling.view;

import bowling.domain.*;

import java.util.List;

public class View {

    public static void numberOfFrameView() {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
    }

    public static void namePrint(String name) {
        System.out.printf("| %4s |", name);
    }

    public static void framePrint(Player player) {
        namePrint(player.getName());
        FrameData frameData = player.getFrameData();
        List<Frame> frames = frameData.getFrames();
        InCompleteFrame inCompleteFrame = frameData.getInCompleteFrame();
        LastFrame lastFrame = frameData.getLastFrame();
        Scores scores = frameData.getScores();

        printComplete(frames);
        if (frames.size() < 9)
            printInCompleteFrame(inCompleteFrame);
        if (player.userFrameNumber() == 10) {
            printLastFrame(lastFrame, inCompleteFrame);
        } else {
            printEmpty(frames.size());
        }
        System.out.println();
        printScore(scores);
    }

    private static void printEmpty(int size) {
        for (int i = 0; i < 9 - size; i++) {
            System.out.print("      |");
        }
    }

    public static void printComplete(List<Frame> frames) {
        for (Frame frame : frames) {
            System.out.print(frame.frameStatusPrint());
        }
    }

    public static void printInCompleteFrame(InCompleteFrame inCompleteFrame) {
        if (inCompleteFrame.isFirst()) {
            System.out.print("      |");
        } else {
            System.out.print("  " + isStrike(inCompleteFrame.firstInFrame()) + "|  |");
        }
    }

    public static void printLastFrame(LastFrame lastFrame, InCompleteFrame inCompleteFrame) {
        if (lastFrame == null) {
            if (inCompleteFrame.isFirst()) {
                System.out.print("      |");
            } else {
                System.out.print("  " + isStrike(inCompleteFrame.firstInFrame()) + "|  |");
            }
        } else {
            if (lastFrame.isThird()) {
                System.out.print("  " + isStrike(lastFrame.firstInFrame()) + "|" + lastFrame.secondInFrame() + " |");
            } else {
                System.out.print(isStrike(lastFrame.firstInFrame()) + "|" + lastFrame.secondInFrame() + "|" + lastFrame.getThird() + "|");
            }
        }

    }

    public static void printScore(Scores scores2) {
        System.out.print("|      |");
        List<Score> scores = scores2.getScores();
        for (Score score : scores) {
            System.out.printf("  %3d |", score.getScore());
        }
        for (int i = 0; i < 10 - scores.size(); i++) {
            System.out.print("      |");
        }
        System.out.println();
    }

    public static String isStrike(int pin) {
        if (pin == 10) {
            return "X";
        }
        return String.valueOf(pin);
    }
}