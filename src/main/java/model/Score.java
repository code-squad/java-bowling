package model;

public class Score {
	private String result;
	
	public Score(int... pins) {
		createScore(pins);
	}
	public String createScore(int... pins) {
		if (pins.length == 1) {
			this.result = createStrikeOrNotFull(pins[0]);
			return this.result;
		}
		this.result = createSpareOrMiss(pins);
		return this.result;
	}
	
	
	public String getResult() {
		return this.result;
	}
	
	private String createSpareOrMiss(int... pins) {
		if (isSpare(pins)) {// spare 일때.
			return pins[0] + "|/";
		}
		return createMiss(pins);
	}

	private String createMiss(int... pins) {
		if (pins[1] == 0) {// miss 일때 && 두번째 투구가 0일때.
			return pins[0] + "|-";
		}
		// miss 일때.
		return pins[0] + "|" + pins[1];
	}

	private String createStrikeOrNotFull(int pin) {
		if (isStrike(pin)) {
			return "X";
		}
		// strike 아니고 첫번째 구일때.
		return pin + "";
	}

	boolean isStrike(int pin) {
		if (pin == 10) {
			return true;
		}
		return false;
	}
	
	private boolean isSpare(int... pins) {
		if (pins[0] + pins[1] == 10) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
		Score other = (Score) obj;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}
	
	
}
