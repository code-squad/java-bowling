package bowling.print;

import java.util.List;

public class ResultView {

	public void blank(int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%5s|", "");
		}
	}

	public void name(String name) {
		System.out.printf("\n| %4s |", name);
	}

	public void throwedPin(List<String> throwedPins, String name) {
		frame();
		name(name);
		for (int j = 0; j < throwedPins.size(); j++) {
			System.out.printf("%-5s|", throwedPins.get(j));
		}
		blank(10 - throwedPins.size());
	}

	public void frame() {
		System.out.printf("| %4s |", "NAME");
		for (int i = 1; i < 11; i++) {
			System.out.printf(" %02d  ", i);
			System.out.print("|");
		}
	}
}
