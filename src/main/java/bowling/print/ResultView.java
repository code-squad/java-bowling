package bowling.print;

import java.util.List;

public class ResultView {

	//util로 빼야할까?
	public void blank(int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%5s|", "");
		}
	}

	public void name(String name) {
		System.out.printf("\n| %4s |", name);
	}

	public void throwedPin(List<String> marks, String name) {
		frame();
		name(name);
		for (String mark : marks) {
			System.out.printf("%-5s|", mark);
		}
		blank(10 - marks.size());
	}

	public void frame() {
		System.out.printf("| %4s |", "NAME");
		 //util로 빼야할까?
		for (int i = 1; i < 11; i++) {
			System.out.printf(" %02d  ", i);
			System.out.print("|");
		}
	}
}
