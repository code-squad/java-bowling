package bowling.domain.frame;

public class Frames {
    private final Frame initialFrame;
    private Frame currentFrame;
    private int currentFrameNumber;

    public Frames() {
        this.initialFrame = new NormalFrame(1);
        this.currentFrame = initialFrame;
        this.currentFrameNumber = 1;
    }

    public void bowl(int pins) {
        Frame newFrame = currentFrame.bowl(pins);
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
        return initialFrame.convertStatusToPrintable();
    }

    public String convertScoreToPrintable() {
        return initialFrame.convertScoreToPrintable();
    }
}