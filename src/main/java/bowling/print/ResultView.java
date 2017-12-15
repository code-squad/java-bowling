package bowling.print;

import java.util.List;
import bowling.model.Board;
import bowling.model.Frame;
import bowling.model.PlayerResult;

public class ResultView {

	private void blank(int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%5s|", "");
		}
	}

	private void name(String name) {
		System.out.printf("\n| %4s |", name);
	}
	
	public void board(Board board) {
		frame();
		for(PlayerResult result : board.getResults()) {
			name(result.getName());
			result.getStatus().stream().forEach(status -> System.out.printf("%-5s|", status));
			blank(10 - result.getStatus().size());
			sum(result.getScores());
		}
	}

	private void sum(List<Integer> scores) {
		System.out.printf("\n| %4s |", "");
		scores.stream().filter(sum -> sum!= -1).reduce(0, (a,b)->{
			System.out.printf("%-5s|", a+b);
			return a + b;
		});
		scores.stream().filter(sum -> sum== -1).forEach(sum -> System.out.printf("%-5s|", ""));
		blank(10 - scores.size());
	}
	
	private void frame() {
		System.out.printf("| %4s |", "NAME");
		for (int i = 1; i < 11; i++) {
			System.out.printf(" %02d  ", i);
			System.out.print("|");
		}
	}
}