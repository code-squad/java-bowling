package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Low {
	final private int FALSE = 1;

	private List<Route> lows;

	public Low(int low) {
		createLow(low);
	}

	private void createLow(int low) {
		lows = new ArrayList<>();
		for (int i = 0; i < low; i++) {
			Random random = new Random();
			lows.add(new Route(random.nextInt()));
		}
	}

	public int size() {
		return lows.size();
	}

	public List<Route> getLow() {
		return lows;
	}

	public int checkLow(int lastIndex) {
		boolean check = lows.get(lastIndex).getRoute();
		if (check) {
			lows.set(lastIndex, new Route(FALSE));
		}
		System.out.println(check);
		return 1;
	}

	public int getTrueCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void checkLow() {
		// TODO Auto-generated method stub

	}

}
