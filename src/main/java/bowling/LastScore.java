package bowling;

public class LastScore {
	private int lastChance;

	public LastScore(int lastChance) {
		this.lastChance = lastChance;
	}

	public int useChance() {
		if(isLastChanceNotEnd())
			return lastChance -= 1;
		return lastChance;
	}

	public boolean isFinal() {
		return lastChance != 0;
	}
	
	public boolean isLastChanceNotEnd(){
		return lastChance > 0;
	}
	
	public boolean isSameSize(int totalScoreSize){
		return lastChance == totalScoreSize;
	}

	public boolean isGameEnd() {
		return lastChance == 0;
	}

	
	


}
