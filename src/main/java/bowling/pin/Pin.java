package bowling.pin;

public class Pin {
	final private int MAX_PINNUMBER = 10;
	final private int MINIMUM_PINNUMBER = 0;

	private int lostPinNumber;
	private int leftPinNumber;

	public Pin(int lostPinNumber) {
		this.leftPinNumber = MAX_PINNUMBER - lostPinNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leftPinNumber;
		result = prime * result + lostPinNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pin other = (Pin) obj;
		if (leftPinNumber != other.leftPinNumber)
			return false;
		if (lostPinNumber != other.lostPinNumber)
			return false;
		return true;
	}
}
