package bowling;

public abstract class Frame {
	private String player;
	private Pins firstRoll;
	private Pins secondRoll;

	public abstract void saveBowl(Pins pins);

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Pins getFirstRoll() {
		return firstRoll;
	}

	public void setFirstRoll(Pins firstRoll) {
		this.firstRoll = firstRoll;
	}

	public Pins getSecondRoll() {
		return secondRoll;
	}

	public void setSecondRoll(Pins secondRoll) {
		this.secondRoll = secondRoll;
	}
}
