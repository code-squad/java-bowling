package bowling.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Frame {
	private static final Logger log = LoggerFactory.getLogger(Frame.class);
	int tryNo = 1;
	
	abstract public String getStatus();
	
	public int getTryNo() {
		return tryNo;
	}
	
	abstract public void play(int pin);
	//왜 구지 static? 
	static boolean isSpare(int lastPin, int pin) {
		return lastPin + pin == 10;
	}

	static boolean isMiss(int lastPin, int pin) {
		return lastPin + pin < 10;
	}
	
	static boolean isStrike(int pin) {
		return pin == 10;
	}
	//리뷰: 인자명 일관성 없음
	String makeSpare(int noOne) {
		 return makeStatus(noOne) + "|/";
	}
	//리뷰: 변수명 무슨 뜻인지 모르겠음
	String makeMiss(int noOne, int noTwo) {
		return makeStatus(noOne) + "|" + makeStatus(noTwo);
	}
	
	void addTryNo() {
		tryNo++;
	}

	String makeStatus(int noOne) {
		if (isStrike(noOne)) {
			return "X";
		}
		return pinToStatus(noOne);
	}
	
	String pinToStatus(int noOne) {
		if (noOne == 0) {
			return "-";
		}
		return String.valueOf(noOne);
	}
	
	String makeStatus(int noOne, int noTwo) {
		if(isSpare(noOne, noTwo)) {
			return makeSpare(noOne);
		}
		return makeMiss(noOne, noTwo);
	}
	
	boolean isNotBlank(int no) {
		return no >= 0;
	}
	
	abstract boolean isEnd();
}