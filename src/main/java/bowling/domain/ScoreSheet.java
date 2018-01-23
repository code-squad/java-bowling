package bowling.domain;

public class ScoreSheet {
    private Frames frames;
    private FinalFrame finalFrame;

    public ScoreSheet() {
        frames = new Frames();
        finalFrame = new FinalFrame();
    }

    @Override
    public String toString() {
        String temp = frames == null ? "" : frames.toString();
        temp += finalFrame == null ? "" : finalFrame.toString();
        return temp;
    }
}
