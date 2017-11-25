package model;
import java.util.ArrayList;
import java.util.List;

public class Bowling {
	private List<Integer> falledPins = new ArrayList<>();
	private List<Frame> frames;
	private Frame currFrame;
	public static int count = 0;
	
	public Bowling() {
		frames = new ArrayList<>();
	}
	
	public List<Frame> roll(int falledPin) {
		int[] falledPinsArray = createFalledPinsArray(falledPin);
		// 맨처음 프레임 생성.
		if(frames.size() == 0) {
			return createFirstFrame(falledPinsArray);
		}
		return createFrames(falledPinsArray, count);
	}

	public int[] createFalledPinsArray(int falledPin) {
		falledPins.add(falledPin);
		int[] falledPinsArray = falledPins.stream().mapToInt(i -> i).toArray();
		if(falledPins.size() >= 2 || falledPin == 10) {
			falledPins.removeAll(falledPins);
		}
		return falledPinsArray;
	}
	public List<Frame> createFirstFrame(int[] falledPinsArray) {// 첫번째 프레임 생성.
		// 점수 생성.
		Score score = new Score(falledPinsArray);
		currFrame = new Frame();
		currFrame.updateScore(score);
		currFrame.updateFrameNum(count+1);
		frames.add(currFrame);
		return frames;
	}
	public List<Frame> createFrames(int[] falledPinsArray, int frameNum) {
		// 새 score 생성.
		Score score = new Score(falledPinsArray);
		// 조건에 따라 새 프레임 or 기존 프레임 반환.
		Frame properFrame = currFrame.createFrameOrNot();
		// score 업데이트 
		properFrame.updateScore(score);
		if(properFrame != currFrame) { // 새 프레임이 생긴 경우.
			count++;
			properFrame.updateFrameNum(count+1);
			frames.add(count, properFrame);
			currFrame = properFrame; // 비교대상을 변경.
			return frames;
		}
		// 기존프레임일 경우.
		frames.set(count, properFrame);
		return frames;
	}
	// 9 프레임까지 끝난 이후.
	public List<Frame> createTenthFrame(int[] falledPinsArray, Frame tenthFrame) {
		// 새 score 생성.
		Score score = new Score(falledPinsArray);
		// 첫 score 설정.
		tenthFrame.updateScore(score);
		frames.add(9, tenthFrame);
		return frames;
	}
	public List<Frame> getFrames() {
		return frames;
	}

	public List<Integer> getFalledPins() {
		return falledPins;
	}
	

}
