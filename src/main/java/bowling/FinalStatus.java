package bowling;

public enum FinalStatus {
	STRIKE(true, 1),
	SPARE(true, 2),
	MISSORNORMAL(false, 2),
	FIRSTSHOT(false, 1),
	READY(false, 0);

	private Boolean isTen;
	private int size;

	FinalStatus(Boolean isTen, int size) {
		this.isTen = isTen;
		this.size = size;
	}

	public static FinalStatus valueOf(Boolean isTen, int size){
		for (FinalStatus status : FinalStatus.values()) {
			if(isTen == status.isTen && size == status.size)
				return status;
		}
		return null;
	}
}
