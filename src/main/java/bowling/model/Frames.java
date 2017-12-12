package bowling.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frames {
	private static final Logger log = LoggerFactory.getLogger(Frames.class);
	
	private List<Frame> frames = new ArrayList<>();

	public Frames() {
		frames.add(new NormalFrame(1));
	}

	public int getFrameNo() {
		if (!lastFrame().isEnd()) {
			return frames.size();
		}
		return frames.size() + 1;
	}
	
	public List<Frame> play(int pin) {
		try {
			Frame frame = lastFrame().play(pin);
			if(lastFrame() != frame) {
				frames.add(frame);
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return frames;
	}

	private Frame lastFrame() {
		return frames.get(frames.size() - 1);
	}

	public boolean isEnd() {
		Frame frame = lastFrame();
		return frames.size() == 10 && frame.isEnd();
	}
}