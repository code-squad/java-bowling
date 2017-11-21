package bowling.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frames {

	
	private static final Logger log = LoggerFactory.getLogger(Frames.class);

	List<Frame2> frames = new ArrayList<>();
	public Frames() {
		frames.add(new NormalFrame());
	}
	
	public int getFrameNo() {
		if(lastFrame().hasNext()) {
			return frames.size();
		}
		return frames.size() + 1;
	}
	
	public List<Frame2> play(int pin) {
		Frame2 frame = setUpFrame();
		frame.play(pin);
		return frames;
	}
	
	private Frame2 setUpFrame() {
		Frame2 frame = lastFrame();
		if(frames.size() < 9 && !frame.hasNext()) {
			frames.add(new NormalFrame());
		}else if(frames.size() == 9 && !frame.hasNext()) {
			frames.add(new TenFrame());
		}
		return lastFrame();
	}
	
	private Frame2 lastFrame() {
		return frames.get(frames.size()-1);
	}
	
	public boolean isEnd() {
		Frame2 frame = lastFrame();
		return frames.size() == 10 &&  !frame.hasNext(); 
	}
}
