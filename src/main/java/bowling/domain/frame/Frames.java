package bowling.domain.frame;

import bowling.domain.Score.Roll;
import bowling.domain.Score.Score;
import bowling.domain.number.MaxCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Frames {
    private final static int MAX_FRAME_COUNT = 9;
    private List<Frame> frames;
    public Frames() {
        this.frames = new ArrayList<>();
        for (int i = 0; i < MAX_FRAME_COUNT; i++) {
            frames.add(new Frame(new Score()));
        }
    }

    public boolean hasEmptyFrame() {
        return frames.stream().anyMatch(Frame::hasEmptyScore);
    }

    public void add(Roll roll) {
        if (frames == null) {
            System.out.println(frames);
        }
        if (!hasEmptyFrame()) throw new IllegalArgumentException();
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i).hasEmptyScore()) {
                frames.set(i, new Frame(frames.get(i).add(roll)));
                break;
            }
        }
    }

    public MaxCount nextMaxCount() {
        return !hasEmptyFrame() ? null : emptyFrames().findFirst().get().nextMaxCount();
    }

    public int firstEmptyFrameIndex() {
        return (frames.size() - (int) emptyFrames().count())+1;
    }

    private Stream<Frame> emptyFrames() {
        return frames.stream().filter(Frame::hasEmptyScore);
    }

    public int size() {
        return frames.size();
    }

    @Override
    public String toString() {
        String temp = "";
        if (frames != null) {
            for (Frame frame : frames) {
                temp+=frame.toString();
            }
        }
        return temp;
    }
}