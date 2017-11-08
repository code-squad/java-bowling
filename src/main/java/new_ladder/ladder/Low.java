package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Low {
	final private int FALSE = 1;

	private List<Route> lows;

	private static int trueCount;
	// private int falseCount;

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
		Route route = lows.get(lastIndex);
		boolean check = route.getRoute();
		if (check) {
			lows.set(lastIndex, new Route(FALSE));
		}
		return 1;
	}

	public static int checkLow(List<Route> temp) {
		Route route;
		// int trueCount = 0;
		int falseCount = 0;
		final int FALSE = 1;
		for (int i = 0; i < temp.size(); i++) {
			route = temp.get(i);
			if (route.getRoute()) {
				++trueCount;
			} else {
				++falseCount;
			}
			if (trueCount == 2) {
				temp.set(i, new Route(FALSE));
				trueCount = 0;
			}
			if (falseCount == 2) {
				--trueCount;
				falseCount = 0;
			}
		}
		for (int i = 0; i < temp.size(); i++) {
			route = temp.get(i);
			if (route.getRoute()) {
				++trueCount;
			}
		}

		return trueCount;
	}

}
