package bowling;

import java.util.HashMap;

public class Player {// 밖에서 frame 생성한거를 안에 있는 frames를 직접적으로 호출하여 넣어준다. 넣어줄때 중복체크 ㅎ
	private String player;
	HashMap<Integer, Frame> frames = new HashMap<>();

	public Player(String name) {
		player = name;
	}

	
	public HashMap<Integer, Frame> getFrames(){
		return frames;
	}
	
	public Frame addFrame(Frame currentFrame) {
		if(currentFrame.isAddPossible(frames)){
			currentFrame.addFrames(frames);
		}
		return currentFrame;
	}
	

	public String getPlayerName() {
		return player;
	}

	@Override
	public String toString() {
		return (player != null ? player : "") + "";
	}

	public boolean isGameOver() {
		return frames.size() == 10 && frames.get(frames.size() - 1).isGameEnd();
	}


	public int getFramesSize() {
		return frames.size();
	}


	public boolean isGameStart() {
		return frames.size() == 0;
	}


	public void setNextFrame(Frame nextFrame) {
		if(frames.size() > 0)
			frames.get(frames.size() - 1).setNextFrame(nextFrame);
	}





}
