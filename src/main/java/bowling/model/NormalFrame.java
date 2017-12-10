package bowling.model;

public class NormalFrame extends Frame {
	private Pins pins = null;
	private Frame nextFrame = null;
	private int frameNum;
	
	public NormalFrame() {}
	public NormalFrame(int frameNum) {
		this.frameNum = frameNum;
		this.pins = new Ready();
	}

	public Frame makeNextFrame(int frameNum) {
		if (frameNum == 9) {
			return nextFrame = new TenFrame();
		}
		return nextFrame = new NormalFrame();
	}

	public Frame makeNextFrame2() {
		if (frameNum == 9) {
			return nextFrame = new TenFrame();
		}
		return nextFrame = new NormalFrame(frameNum + 1);
	}

	public Frame play(int pin) {
		if (checkTryNo(1)) {
			return tryOne(pin);
		}
		return tryTwo(pin);
	}

	private Frame tryOne(int pin) {
		pins = pins.makePins(pin);
		if (!pins.isStrike()) {
			addTryNo();
			return this;
		} 
		return makeNextFrame2();
	}

	private Frame tryTwo(int pin) {
		pins.checkPinsExceedCount(pin);// exception나면 어차피 아래코드 실행 안 됨
		pins.addPin(pin);
		return makeNextFrame2();
	}
	
/*	public void play(int pin) {
		if (checkTryNo(1)) {
			//this.score = tryOne(pin); //포비 코드
			tryOne(pin);
			return;
		}
		tryTwo(pin);
	}

	private void tryOne(int pin) {
		pins = new Pins(pin);
		if (!pins.isStrike()) {
			addTryNo();
		} 
	}

	private void tryTwo(int pin) {
		pins.checkPinsExceedCount(pin);// exception나면 어차피 아래코드 실행 안 됨
		pins.addPin(pin);
	}
*/
	public String getStatus() {
		//nullPointException
		/*if(pins == null) {
			return "";
		}*/
		if (!pins.hasSecondPin()) {
			return pins.makeFirstPinStatus();
		}
		return pins.makeSecondPinStatus();
	}

	public boolean isEnd() {
		if (pins != null && (pins.isStrike() || pins.hasSecondPin())) {
			return true;
		}
		return false;
	}

	public int getScore() {
		//nullPointException
		Score score = pins.getScore();
		if(score.isFinish()){
			return score.getScore();
		}
		if(nextFrame != null) {
			return nextFrame.calculate(score);
		}
		return -1;
	}
	
	public int calculate(Score beforeScore) {
		Score score = pins.calculate(beforeScore);
		if(score.isFinish()) {
			return score.getScore();
		}
		if(nextFrame != null) {
			return nextFrame.calculate(score);
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "NormalFrame [pins=" + pins + "]";
	}
}