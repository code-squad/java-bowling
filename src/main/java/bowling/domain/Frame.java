package bowling.domain;

public class Frame {

    private FrameStatus frameStatus;
    private Score score;

    public Frame(FrameStatus frameStatus) {
        this.frameStatus = frameStatus;
    }

    public int firstInFrame() {
        return frameStatus.getFirst();
    }

    public int secondInFrame() {
        return frameStatus.getSecond();
    }

    public FrameStatus getFrameStatus() {
        return frameStatus;
    }

    public String frameStatusPrint() {
        return frameStatus.nomalPrint();
    }
}
