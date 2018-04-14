package saru.view;

import saru.domain.*;

import java.util.List;

public class BowlingOutput {

    private List<Frame> frames;

    public BowlingOutput(ScoreBoard scoreBoard) {
        this.frames = scoreBoard.getFrames();
    }

    String getFrameResult(int frameIndex) {
        Frame frame = frames.get(frameIndex);
        List<DownPin> downPins = frame.copyDownPins();

        if (downPins.get(0).getDownPinCount() == 10) {
            return "X  ";
        }

        if (downPins.get(0).addWith(downPins.get(1)) == 10) {
            return downPins.get(0).getDownPinCount() + " | " + "/";
        }

        return downPins.get(0).getDownPinCount() + " | " + downPins.get(1).getDownPinCount();
    }
}
