package domain;

import domain.pin.Pins;
import domain.status.*;

public class Score {
	private int score;
	private int canScoreCount;
	
	public Score(int score, int canScoreCount) {
		this.score = score;
		this.canScoreCount = canScoreCount;
	}
	
	public static Score ofStatus(Status status, Pins pins) {
		if (status.ofInstance(Strike.class)) {
			return ofStrike();
		}
		if (status.ofInstance(Spare.class)) {
			return ofSpare();
		}
		if (status.ofInstance(Gutter.class, None.class)) {
			return new Score(pins.sum(), 1);
		}
		return ofNone(pins.sum());
	}
	
	public static Score ofNone(int score) {
		return new Score(score, 0);
	}
	
	public static Score ofSpare() {
		return new Score(10, 1);
	}
	
	public static Score ofStrike() {
		return new Score(10, 2);
	}
	
	public int getScore() {
		if(!canScore()) {
			throw new IllegalStateException("점수를 구할 수 없는 상태인 프레임의 점수를 합산시도하였습니다.");
		}
		
		return score;
	}
	
	public Score next(int pin) {
		return new Score(score + pin, canScoreCount - 1);
	}
	
	public boolean canScore() {
		return canScoreCount == 0;
	}
}
