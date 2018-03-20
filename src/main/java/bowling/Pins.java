package bowling;

public class Pins {
	private int pinsDown;
	private final int MIN = 0;
	private final int MAX = 10;
	
	public Pins(int pinsDown) {
		if (MIN > pinsDown || MAX < pinsDown) {
			throw new IllegalStateException();
		}
		this.pinsDown = pinsDown;
	}
}
