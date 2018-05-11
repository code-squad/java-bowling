package domain.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Frames {
	private List<Frame> frames;
	
	public Frames() {
		this.frames = new ArrayList<>();
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
	
	public boolean isEmpty() {
		return frames.isEmpty();
	}
	
	public Frame getLast() {
		return frames.get(frames.size() - 1);
	}
	
	public int getNextFrameNumber() {
		if (frames.isEmpty()) {
			return Frame.MIN_FRAME_NUMBER;
		}
		
		if (getLast().isComplete()) {
			return frames.size() + 1;
		}
		
		return frames.size();
	}
	
	public boolean contains(Frame nowFrame) {
		return frames.contains(nowFrame);
	}
	
	public Frames add(Frame frame) {
		frames.add(frame);
		return this;
	}
	
	public Stream<Frame> stream() {
		return frames.stream();
	}
	
	public int size() {
		return frames.size();
	}
}
