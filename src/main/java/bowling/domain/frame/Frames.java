package bowling.domain.frame;

public class Frames {
    private final Frame frames;
    private Frame currentFrame;
    private int currentFrameNumber;

    public Frames() {
        this.frames = new NormalFrame(1);
        this.currentFrame = frames;
        this.currentFrameNumber = 1;
    }

    public void bowl(int pins) {
        Frame newFrame = currentFrame.bowl(pins);
        frames.calculateScore(0);
        if (newFrame != null) {
            currentFrame = newFrame;
            currentFrameNumber++;
        }
    }

    public boolean isDone() {
        return currentFrame.isLast();
    }

    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public String convertStatusToPrintable() {
        return frames.convertStatusToPrintable();
    }

    public String convertScoreToPrintable() {
        return frames.convertScoreToPrintable();
    }
}