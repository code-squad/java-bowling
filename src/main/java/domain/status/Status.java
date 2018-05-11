package domain.status;

import domain.pin.Pin;

import java.util.Arrays;

public abstract class Status {
	public abstract String display();
	public abstract boolean isClear();
	public abstract boolean isComplete();
	public abstract Status next(int pin);
	public abstract int getLeftPin();
	public boolean ofInstance(Object... statuses) {
		return Arrays.stream(statuses)
				.map(status -> ((Class) status).getName().equals(this.getClass().getName()))
				.reduce((aBoolean, aBoolean2) -> aBoolean || aBoolean2)
				.orElse(false);
	}
	void validNext(int pin) {
		if(pin > Pin.DEFAULT_START_PIN_COUNT) {
			throw new IllegalArgumentException("주어진 핀 개수를 초과하는 핀으로 게임할 수 없습니다.");
		}
		
		if(pin > getLeftPin()) {
			throw new IllegalArgumentException("주어진 핀 개수를 초과하는 핀으로 게임할 수 없습니다.");
		}
	}
}
