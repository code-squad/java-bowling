package bowling;

public class Pins {
	
	private int pinsDown;
	public static final int MIN = 0;
	public static final int MAX = 10;

	public Pins(int pinsDown) {
		if (MIN > pinsDown || MAX < pinsDown) {
			throw new IllegalArgumentException("핀은 최소 0개에서 최대 10개 들어올 수 있습니다.");
		}
		this.pinsDown = pinsDown;
	}
	
	public int getPinsDown() {
		return pinsDown;
	}
	
	public Pins getRestPins() {
		return new Pins(Pins.MAX - pinsDown);
	}
	
}
