package bowling;

import java.util.ArrayList;
import java.util.Scanner;

import bowling.model.Frames;
import bowling.print.InputView;
import bowling.print.ResultView;

public class BowlingGame2 {

	public static void main(String[] args) {
		BowlingGame2 game = new BowlingGame2();
		InputView input = new InputView(new Scanner(System.in));
		ResultView print = new ResultView();
		game.play(input, print);
		input.endConsole();
	}
	
	public void play(InputView input, ResultView print) {
		String name = input.getName();
		Frames frames = new Frames();
		print.status(new ArrayList<String>(), name);
		while(!frames.isEnd()) {
			print.status2(frames.play(input.getThrowedPin(frames.getFrameNo())), name);
		}
	}
	

}