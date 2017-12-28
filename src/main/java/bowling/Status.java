package bowling;

public enum Status {
	STRIKE(true, 1),
	SPARE(true, 2),
	MISSORNORMAL(false, 2),
	FIRSTSHOT(false, 1),
	READY(false, 0),
	EXTRACLEARSHOT(true, 3),
	EXTRANORMALSHOT(false, 3);

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
	
	public boolean isExtraShot() {
		return size == 3;
	}
	
	public boolean isStrike() {
		return valueOf(isTen, size) == STRIKE;
	}
	
	public boolean isSpare() {
		return valueOf(isTen, size) == SPARE;
	}
	
	public boolean isMissOrNormal() {
		return valueOf(isTen, size) == MISSORNORMAL;
	}
	
	public boolean isFirstshot() {
		return valueOf(isTen, size) == FIRSTSHOT;
	}
	
	public boolean isReady() {
		return valueOf(isTen, size) == READY;
	}
	
	public boolean isExtraNormalShot() {
		return valueOf(isTen, size) == EXTRANORMALSHOT;
	}
	
	public boolean isExtraClearShot() {
		return valueOf(isTen, size) == EXTRACLEARSHOT;
	}
}