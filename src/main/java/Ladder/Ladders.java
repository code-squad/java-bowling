package Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladders {
	List<Ladder> ladders;

	public List<Ladder> create(int height) {
		ladders = new ArrayList<>();
		Random random = new Random();
		int x = random.nextInt();
		for (int i = 0; i < height; i++) {
			ladders.add(new Ladder(0, "wsh", x % 3));
		}
		return ladders;
	}

	public String show() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Ladder ladder : ladders) {
			stringBuilder.append(ladder);
			stringBuilder.append("\n");
		}
		stringBuilder.append(ladders);
		return stringBuilder.toString();
	}

}
