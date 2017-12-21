package bowling;

public enum Status {
	STRIKE(true, 1),
	SPARE(true, 2),
	MISSORNORMAL(false, 2),
	FIRSTSHOT(false, 1),
	READY(true, 0);

	private Boolean isTen;
	private int size;

	Status(Boolean isTen, int size) {
		this.isTen = isTen;
		this.size = size;
	}

	public static Status valueOf(Boolean isTen, int size){
		for (Status status : Status.values()) {
			if(isTen == status.isTen && size == status.size)
				return status;
		}
		return null;
	}
	
	public void clearSize() {
		size = 0;
	}
}