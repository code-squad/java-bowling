package saru.view;

import saru.domain.*;

import java.util.List;

public class BowlingOutput {
    private ScoreBoard scoreBoard;
    private List<Frame> frames;

    public BowlingOutput(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.frames = scoreBoard.getFrames();
    }

    String getFrameResult(int frameIndex) {
        if (frameIndex > scoreBoard.getNowFrameIndex()) {
            return "";
        }

        Frame frame = frames.get(frameIndex);
        List<DownPin> downPins = frame.copyDownPins();

        if (downPins.size() == 0) {
            return "";
        }

        if (downPins.size() < 2) {
            int toView = downPins.get(0).getDownPinCount();
            if (toView == 10) {
                return "X";
            }

            return toView + "";
        }

        if (downPins.size() == 3) {
            if (downPins.get(0).getDownPinCount() == 10) {
                return "X" + "|" +
                        downPins.get(1).getDownPinCount() + "|" +
                        downPins.get(2).getDownPinCount();
            }

            if (downPins.get(0).addWith(downPins.get(1)) == 10) {
                if (downPins.get(2).getDownPinCount() == 10) {

                    return downPins.get(0).getDownPinCount() + "|" +
                            "/" + "|" + " X";
                }

                return downPins.get(0).getDownPinCount() + " | " +
                        "/" +
                        downPins.get(2).getDownPinCount();
            }

            return downPins.get(0).getDownPinCount() + "|" +
                    downPins.get(1).getDownPinCount() + "|" +
                    downPins.get(2).getDownPinCount();
        }

        if (downPins.get(0).getDownPinCount() == 10 && downPins.size() == 2) {
            return "X" + " | " + downPins.get(1).getDownPinCount();
        }

        if (downPins.get(0).getDownPinCount() == 10) {
            return "X  ";
        }

        if (downPins.get(0).addWith(downPins.get(1)) == 10) {
            return downPins.get(0).getDownPinCount() + " | " + "/";
        }

        if (downPins.get(1).getDownPinCount() == 0) {
            return downPins.get(0).getDownPinCount() + " | " + "-";
        }

        return downPins.get(0).getDownPinCount() + " | " + downPins.get(1).getDownPinCount();
    }

    public void printScore() {
        String frameOne = getFrameResult(0);
        String frameTwo = getFrameResult(1);
        String frameThree = getFrameResult(2);
        String frameFour = getFrameResult(3);
        String frameFive = getFrameResult(4);
        String frameSix = getFrameResult(5);
        String frameSeven = getFrameResult(6);
        String frameEight = getFrameResult(7);
        String frameNine = getFrameResult(8);
        String frameTen = getFrameResult(9);

        System.out.printf(
                "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n" +
                        "|  PJS |%6s|%6s|%6s|%6s|%6s|%6s|%6s|%6s|%6s|%6s|\n",
                frameOne, frameTwo, frameThree, frameFour, frameFive, frameSix, frameSeven, frameEight,
                frameNine, frameTen);
    }
}
