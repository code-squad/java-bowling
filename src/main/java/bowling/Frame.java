package bowling;

public class Frame {
	private int frameNum;
	private int pinNum;
	
	//생성자.
	public Frame() {
		frameNum = 1;
		pinNum = 10;
	}
	//int 형의 현재 프레임 넘버를 리턴.
	public int getFrameNum() {
		return frameNum;
	}
	//int 형의 현재 핀의 갯수를 리턴.
	public int getPinNum() {
		return pinNum;
	}
}
