package bowling;

public enum RollForTotal {
	ZEROROLL(0), ONEROLL(1), TWOROLL(2);
	
	private final int roll;
	
	private RollForTotal(int roll) {
		this.roll = roll;
	}
	
	public int getRollForTotal() {
		return roll;
	}
}
