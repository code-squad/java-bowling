package bowling;

public enum Status {
	STRIKE(true, 1, 2),
	SPARE(true, 2, 1),
	MISSORNORMAL(false, 2, 0),
	READY(false, 1, 1);

	private Boolean isTen;
	private int size;
	public int lastChance;

	Status(Boolean isTen, int size, int lastChance) {
		this.isTen = isTen;
		this.size = size;
		this.lastChance = lastChance;
	}

	public static Status valueOf(Boolean isTen, int size) {
		for (Status status : Status.values()) {
			if (isTen == status.isTen && size == status.size)
				return status;
		}
		return null;
	}

}
