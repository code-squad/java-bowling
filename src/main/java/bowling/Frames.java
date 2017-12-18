package bowling;

import java.util.ArrayList;

public class Frames {
	ArrayList<Frame> frames = new ArrayList<>();

	Frames() {
	}

	public ArrayList<Frame> getFrames() {
		return frames;
	}

	public void addFrame(Frame frame) {
		frames.add(frame);
	}

	public int countFrame() {
		return frames.size() + 1;
	}
	
	public Boolean isGameEnd(){
		return frames.size() < 10;
	}


}
