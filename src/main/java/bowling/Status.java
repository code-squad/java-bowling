package bowling;

public enum Status {
	STRIKE(1, 1, 3),
	SPARE(1, 2, 2),
	MISSORNORMAL(0, 2, 1),
	READY(0, 1, 2);

	private int scopeOfScore;
	private int size;
	public int lastChance;

	Status(int scopeOfScore, int size, int lastChance) {
		this.scopeOfScore = scopeOfScore;
		this.size = size;
		this.lastChance = lastChance;
	}

	public static Status valueOf(int scopeOfScore, int size) {
		for (Status status : Status.values()) {
			if (scopeOfScore == status.scopeOfScore && size == status.size)
				return status;
		}
		return null;
	}

}
