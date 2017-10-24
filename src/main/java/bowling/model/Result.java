package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private List<String> knockedPins;
	private List<String> sumScores;
	private int index;

	public Result() {
		knockedPins = new ArrayList<String>();
		sumScores = new ArrayList<String>();
		index = 0;
		for (int i = 0; i < 10; i++) {
			knockedPins.add("  ");
			sumScores.add("  ");
		}
	}

	public void updateKnockedPins(int no, String knockedPin) {
		knockedPins.set(no - 1, knockedPin);
	}

	public List<String> getKnockedPins() {
		return knockedPins;
	}

	public List<String> getSumScores() {
		return sumScores;
	}

	public void updateSumScores(String sumScore) {
		sumScores.set(index++, sumScore);
	}

}
