package bowling;

public enum Status {
	STRIKE(true, 1, 3),
	SPARE(true, 2, 2),
	MISSORNORMAL(false, 2, 1),
	READY(false, 1, 2);

	private Boolean isTen;
	public int size;
	private int lastChance;

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

	private static void useLastChance(Status finalStatus) {
		finalStatus.lastChance--;
	}

	public static int hasLastChance(Status finalStatus) {
		for (Status status : Status.values())
			if (status == finalStatus) {
				useLastChance(status);
				return status.lastChance;
			}
		return -1;
	}
}
