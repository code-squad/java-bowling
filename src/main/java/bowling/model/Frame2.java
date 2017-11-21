package bowling.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame2 {
	//자식 클래스에서 사용하기 위해 default 사용하는 건 괜찮은가? - 다른 클래스에서 필드 접근 가능해짐
	//공통되는 건 다 부모 클래스로 올려도 되나?
	int tryNo = 1;
	String status;
	boolean hasNext = true;
	
	
	private static final Logger log = LoggerFactory.getLogger(Frame2.class);

	
	//Resultview에서 사용하기 위해. 다른 방법은??
	public String getStatus() {
		return status;
	}
	
	public int getTryNo() {
		return tryNo;
	}
	
	public void play(int pin) {}
	
	public boolean hasNext() {
		return hasNext;
	}
	
	boolean isSpare(int lastPin, int pin) {
		return lastPin + pin == 10;
	}

	boolean isMiss(int lastPin, int pin) {
		return lastPin + pin < 10;
	}
	
	boolean isStrike(int pin) {
		return pin == 10;
	}
	
	void addSpare() {
		status += "|/";
	}
	
	void addMiss(int pin) {
		status += "|" + makeStatus(pin);
	}
	
	
	void addTryNo() {
		tryNo++;
	}
	
	//일 2가지 하는 것인가?
	String makeStatus(int pin) {
		log.debug(String.valueOf(pin));
		if (pin == 0) {
			return "-";
		}
		return String.valueOf(pin);
	}

}