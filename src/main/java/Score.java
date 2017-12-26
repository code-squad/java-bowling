
import java.util.ArrayList;
import java.util.List;

public class Score {
	
	List<Integer> scoreSet = new ArrayList<>();
	
	void bowl(int pinsPerTry) {
		this.scoreSet.add(pinsPerTry);
	}
	
	int calculateScoreSet() {
		int sumScoreSet = 0;
		for (int score : scoreSet) {
			sumScoreSet += score;
		}
		return sumScoreSet;
	}
	
	boolean isEnded() {
		if (scoreSet.isEmpty()) {
			return false;
		}
		if (scoreSet.get(0) == 10) {
			if (scoreSet.size() == 3) {
				return true;				
			}
			return false;
		}
		if (scoreSet.size() == 1) {
			return false;
		}
		if (scoreSet.get(0) + scoreSet.get(1) == 10) {
			if (scoreSet.size() == 3) {
				return true;				
			}
			return false;
		}
		return true;
	}
}
