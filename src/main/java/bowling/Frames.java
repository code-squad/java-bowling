package bowling;

import java.util.ArrayList;

public class Frames {
	ArrayList<Frame> frames = new ArrayList<>();

	Frames() {
		
	}

	public int recentIndex() {
		return frames.size();
	}

	public void addFrame(Frame frame) {
		frames.add(frame);
	}

	public int countFrame() {
		return frames.size();
	}

	public Boolean isGameEnd(){
		return frames.size() < 10;
	}

	public ArrayList<String> updateResultBoard(ArrayList<String> resultList, Frame frame) {
		String result = resultList.get(frames.size());
		result += frame.changeFormat();
		resultList.set(frames.size(), result);
		return resultList;
	}
}