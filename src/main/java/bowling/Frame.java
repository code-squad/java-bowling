package bowling;

public class Frame {
	private int frameNum;
	private int pinNum;
	private int tryNum;
	
	//생성자.
	public Frame() {
		frameNum = 0;
		pinNum = 10;
		tryNum = 1;
	}
	//int 형의 현재 프레임 넘버를 리턴.
	public int getFrameNum() {
		return frameNum;
	}
	//int 형의 현재 핀의 갯수를 리턴.
	public int getPinNum() {
		return pinNum;
	}
	//int 형의 투구수를 리턴한다.(현재 프레임의 투구수)
	public int getTryNum() {
		return tryNum;
	}
	//int 형의 투구 횟수 1 증가.
	public void addTryNum() {
		tryNum++;
	}
	//int 형의 투구 횟수 1로 다시 초기화.
	public void clearTryNum() {
		tryNum = 1;
	}
	//다음 프레임으로 넘어가면서 int 형의 프레임넘버만 1증가. 나머지는 초기화.
	public void goNextFrame() {
		frameNum++;
		clearPin();
		clearTryNum();
	}
	//int 형의 score를 입력받아서, 그만큼 핀을 넘어뜨리고 남은 핀을 리턴해준다.
	public void updatePin(int score) {
		pinNum -= score;
	}
	//int 형의 pinNum를 10으로 초기화.
	public void clearPin() {
		pinNum = 10;
	}
	//Spare처리가 되었는지 (Pin의 갯수가 0개로 다 넘어졌는지) boolean 값으로 리턴.
	public boolean isSpare() {
		return (pinNum == 0);
	}
}
