package bowling;

public class LastScore {
	private int lastChance;

	public LastScore(int lastChance) {
		this.lastChance = lastChance;
	}

	public int useChance() {
		return lastChance -= 1;
	}

}
