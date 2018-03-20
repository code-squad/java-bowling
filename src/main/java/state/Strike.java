package state;

import bowling.Pins;

public class Strike extends State implements Finish {
	public Strike() {
		super.firstRoll = new Pins(10);
		// null값 보다는 0으로 초기화 해주는게 좋을까?
		super.secondRoll = new Pins(0);
	}
}
