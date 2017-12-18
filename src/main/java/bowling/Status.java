package bowling;

public enum Status {
	STRIKE(true, 1, "X"),
	SPARE(true, 2, "/"),
	NORMAL(false, 2, "-");
	
	Boolean isTen;
	int size;
	String symbol;

	Status(Boolean isTen, int size, String symbol) {
		this.isTen = isTen;
		this.size = size;
		this.symbol = symbol;
	}
	
	public static Status valueOf(Boolean isTen, int size){
		for (Status status : Status.values()) {
			if(isTen == status.isTen && size == status.size)
				return status;
		}
		return null;
	}

}
