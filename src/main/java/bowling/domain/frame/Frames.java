package bowling.domain.frame;

public class Frames {
    private static final int FIRST = 1;
    private static final int INITIAL = 0;

    private final Frame frames;
    private Frame currentFrame;
    private int currentFrameNumber;

    public Frames() {
        this.frames = new NormalFrame(FIRST);
        this.currentFrame = frames;
        this.currentFrameNumber = FIRST;
    }

    public void bowl(int pins) {
        Frame newFrame = currentFrame.bowl(pins);
        frames.calculateScore(INITIAL);
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