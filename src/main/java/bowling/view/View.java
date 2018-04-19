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
        List<NormalFrame> frames = frameData.getFrames();
        InCompleteFrame inCompleteFrame = frameData.getInCompleteFrame();
        LastFrame lastFrame = frameData.getLastFrame();

        printComplete(frames);
        if (frames.size() < 9)
            printInCompleteFrame(inCompleteFrame);
        if (player.userFrameNumber() == 10) {
            printLastFrame(lastFrame, inCompleteFrame);
        } else {
            printEmpty(frames.size());
        }
        System.out.println();
        printScore(frames, lastFrame);
    }

    private static void printEmpty(int size) {
        for (int i = 0; i < 9 - size; i++) {
            System.out.print("      |");
        }
    }

    public static void printComplete(List<NormalFrame> frames) {
        for (NormalFrame frame : frames) {
            System.out.print(frame.toString());
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
        System.out.print(lastFrame.lastFramePrint());
    }

    public static void printScore(List<NormalFrame> frames, LastFrame lastFrame) {
        System.out.print("|      |");
        for (NormalFrame frame : frames) {
            System.out.printf("  %3d |", frame.getScore().getScore());
        }
        for (int i = 0; i < 9 - frames.size(); i++) {
            System.out.print("      |");
        }
        if (lastFrame.getScore()!= null) {
            System.out.printf("  %3d |", lastFrame.getScore().getScore());
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