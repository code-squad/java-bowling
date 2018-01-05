package bowling;

public enum Status {
	STRIKE(1, 1, 3, 3),
	SPARE(1, 2, 2, 3),
	MISSORNORMAL(0, 2, 1, 2),
	READY(0, 1, 0, 1);

	private int scopeOfScore;
	private int size;
	private int lastChance;
	private int scoreSize;

	Status(int scopeOfScore, int size, int lastChance, int scoreSize) {
		this.scopeOfScore = scopeOfScore;
		this.size = size;
		this.lastChance = lastChance;
		this.scoreSize = scoreSize;
	}

	public int getScoreSize() {
		return scoreSize;
	}

	public int getLastChance() {
		return lastChance;
	}

	public static Status valueOf(int scopeOfScore, int size) {
		for (Status status : Status.values()) {
			if (scopeOfScore == status.scopeOfScore && size == status.size)
				return status;
		}
		return null;
	}

	public boolean isStrike() {
		return this != STRIKE && this != null;
	}

	

}
