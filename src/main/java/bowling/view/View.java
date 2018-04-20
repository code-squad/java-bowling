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
        Frame frame = frameData.getFrame();

        printComplete(frames);
        if (frames.size() <= 9)
            printInCompleteFrame(frame);
        printEmpty(frames.size());
        System.out.println();
        printScore(frames, frame);
    }

    private static void printEmpty(int size) {
        for (int i = 0; i < 9 - size; i++) {
            System.out.print("      |");
        }
    }

    public static void printComplete(List<Frame> frames) {
        for (Frame frame : frames) {
            System.out.print(frame.toString());
        }
    }

    public static void printInCompleteFrame(Frame frame) {
        System.out.print(frame.toString());
    }

    public static void printScore(List<Frame> frames, Frame Frame) {
        System.out.print("|      |");
        for (Frame frame : frames) {
            if(frame.getScore().canCalculateScore())
            System.out.printf("  %3d |", frame.getScore().getScore());
            else {
                System.out.print("      |");
            }
        }
        for (int i = 0; i < 10 - frames.size(); i++) {
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