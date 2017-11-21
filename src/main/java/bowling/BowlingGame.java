package bowling;

import java.util.ArrayList;
import java.util.Scanner;

import bowling.model.Frame;
import bowling.model.Frames;
import bowling.print.InputView;
import bowling.print.ResultView;

public class BowlingGame {

	public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		InputView input = new InputView(new Scanner(System.in));
		ResultView print = new ResultView();
		game.play(input, print);
		input.endConsole();
	}
	
	public void play(InputView input, ResultView print) {
		String name = input.getName();
		Frames frames = new Frames();
		print.status(new ArrayList<Frame>(), name);
		while(!frames.isEnd()) {
			print.status(frames.play(input.getThrowedPin(frames.getFrameNo())), name);
		}
	}
	

}