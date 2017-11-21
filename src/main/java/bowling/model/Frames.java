package bowling.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frames {
	List<Frame> frames = new ArrayList<>();
	
	public Frames() {
		frames.add(new NormalFrame());
	}
	
	public int getFrameNo() {
		if(!lastFrame().isEnd()) {
			return frames.size();
		}
		return frames.size() + 1;
	}
	
	public List<Frame> play(int pin) {
		Frame frame = setUpFrame();
		frame.play(pin);
		return frames;
	}
	
	private Frame setUpFrame() {
		Frame frame = lastFrame();
		if(frame.isEnd()) {
			addFrame(frames.size());
		}
		return lastFrame();
	}
	
	private void addFrame(int framesSize) {
		if(framesSize < 9) {
			frames.add(new NormalFrame());
			return;
		}
		frames.add(new TenFrame());
	}
	
	private Frame lastFrame() {
		return frames.get(frames.size()-1);
	}
	
	public boolean isEnd() {
		Frame frame = lastFrame();
		return frames.size() == 10 &&  frame.isEnd(); 
	}
}
