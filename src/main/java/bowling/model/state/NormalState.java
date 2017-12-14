package bowling.model.state;

import bowling.model.Score;

public class NormalState implements State {
	NormalPins pins;
	
	public NormalState(int pin) {
		pins = new NormalPins(pin);
	}

	@Override
	public State play(int pin) {
		pins.addPin(pin);		
		return this;
	}
//코드를 객체지향적으로 짤 수록 이런 코드가 많이 생긴다. 그냥 전달만 하는. 그래도 이 클래스가 다른 하는 일이 있기 때문에 괜찮음
	@Override
	public String getStatus() {
		return pins.getStatus();
	}

	@Override
	public Score getScore() {
		return pins.getScore();
	}

	@Override
	public Score calculate(Score beforeScore) {
		return pins.calculate(beforeScore);
	}
	
	@Override
	public boolean isEnd() {
		return pins.isEnd();
	}
}
