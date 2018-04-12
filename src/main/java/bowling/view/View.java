package bowling.view;

import bowling.domain.LastFrame;
import bowling.domain.NomalFrame;
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
        List<NomalFrame> frames = player.getFrames();
        NomalFrame currentFrame = player.getNomalFrame();
        LastFrame lastFrame = player.getLastFrame();

        List<NomalFrame> allFrames = new ArrayList<>(frames);
        if (frames.size() < 9) {
            allFrames.add(currentFrame);
        }
        for (NomalFrame frame : allFrames) {
            nomalFramePrint(frame);
        }
        if (frames.size() == 9) {
            lastFramePrint(lastFrame);
        }
        blankPrint(frames, currentFrame, lastFrame);
    }

    public static void nomalFramePrint(NomalFrame frame) {
        if (frame.isTwiceBall()) {
            twiceBallPrint(frame);
        } else if (!frame.isNewFrame()) {
            firstOfFramePrint(frame);
        }
    }

    public static void lastFramePrint(LastFrame lastFrame) {
        if (!lastFrame.isThirdNull()) {
            lastBallStrike(lastFrame);
        } else if (lastFrame.isTwiceBall()) {
            lastFrameTwiceBall(lastFrame);
        } else if (!lastFrame.isNewFrame()) {
            lastFrameFirstBall(lastFrame);
        }
    }

    public static void lastFrameFirstBall(LastFrame lastFrame) {
        if (lastFrame.isStrike()) {
            System.out.printf("  X   |");
        } else {
            System.out.print(" " + lastFrame.firstInFrame() + "|");
            System.out.print("   |");
        }
    }

    public static void lastFrameTwiceBall(LastFrame lastFrame) {
        System.out.print(" " + lastFrame.firstInFrame() + "|");
        if (lastFrame.isSpare()) {
            System.out.print("/");
        } else {
            System.out.print(lastFrame.secondInFrame());
        }
        System.out.print("  |");
    }


    public static void lastBallStrike(LastFrame lastFrame) {
        if (lastFrame.isStrike()) {
            System.out.printf("  X |");
            System.out.print(lastFrame.thirdInFrame());
            System.out.print(" |");
        } else {
            lastBallNotStrike(lastFrame);
        }
    }

    public static void lastBallNotStrike(LastFrame lastFrame) {
        System.out.print(" " + lastFrame.firstInFrame() + "|");
        if (lastFrame.isSpare()) {
            System.out.print("/");
            System.out.print("|");
            System.out.print(lastFrame.thirdInFrame());
            System.out.print("|");
        } else {
            System.out.print(lastFrame.secondInFrame());
            System.out.print(" |");
        }
    }

    public static void twiceBallPrint(NomalFrame frame) {
        System.out.print(" " + frame.firstInFrame() + "|");
        if (frame.isSpare()) {
            System.out.print("/");
        } else {
            System.out.print(frame.secondInFrame());
        }
        System.out.print("  |");
    }

    public static void firstOfFramePrint(NomalFrame frame) {
        if (frame.isStrike()) {
            System.out.printf("  X   |");
        } else {
            System.out.print(" " + frame.firstInFrame() + "|");
            System.out.print("   |");
        }
    }

    public static void blankPrint(List<NomalFrame> frames, NomalFrame thisFrame, LastFrame lastFrame) {
        int size = sizeOfFrame(frames, thisFrame, lastFrame);
        for (int i = 0; i < 9 - size; i++) {
            System.out.print("      |");
        }
        System.out.println();
    }

    public static int sizeOfFrame(List<NomalFrame> frames, NomalFrame thisFrame, LastFrame lastFrame) {
        if (thisFrame.isNewFrame()) {
            return frames.size() - 1;
        } else if (!lastFrame.isNewFrame()) {
            return frames.size();
        }
        return frames.size();
    }
}
