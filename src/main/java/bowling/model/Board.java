package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<PlayerResult> results =  new ArrayList<>();
	
	public void add(PlayerResult result) {
		results.add(result);
	}

	public List<PlayerResult> getResults() {
		return results;
	}
}
