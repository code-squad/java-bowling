package bowling.view;

import bowling.domain.Frame;
import bowling.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class View {

    public static void numOfFrameView() {
        System.out.print("| NAME |");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("  %02d  |", i);
        }
        System.out.println();
    }

    public static void scoreView(Player player) {
        System.out.print("|  " + player.getName() + " |");
        List<Frame> frames = player.getFrames();
        Frame thisFrame = player.getThisFrame();

        List<Frame> allFrames = new ArrayList<>(frames);
        allFrames.add(thisFrame);
        for (Frame frame : allFrames) {
            oneOrTwoPrint(frame);
        }
        blankPrint(frames, thisFrame);
    }

    public static void oneOrTwoPrint(Frame frame) {
        if (frame.isTwiceBall()) {
            twiceBallPrint(frame);
        } else if (!frame.isNewFrame()) {
            firstOfFramePrint(frame);
        }
    }

    public static void twiceBallPrint(Frame frame) {
        System.out.print(" " + frame.firstInFrame() + "|");
        if (frame.isSpare()) {
            System.out.print("/");
        } else {
            System.out.print(frame.secondInFrame());
        }
        System.out.print("  |");
    }

    public static void firstOfFramePrint(Frame frame) {
        if (frame.isStrike()) {
            System.out.printf("  X   |");
        } else {
            System.out.print(" " + frame.firstInFrame() + "|");
            System.out.print("   |");
        }
    }

    public static void blankPrint(List<Frame> frames, Frame thisFrame) {
        int size = sizeOfFrame(frames, thisFrame);
        for (int i = 0; i < 9 - size; i++) {
            System.out.print("      |");
        }
        System.out.println();
    }

    public static int sizeOfFrame(List<Frame> frames, Frame thisFrame) {
        if (thisFrame.isNewFrame()) {
            return frames.size() - 1;
        }
        return frames.size();
    }
}
