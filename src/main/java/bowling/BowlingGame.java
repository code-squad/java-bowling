package bowling;

import java.util.ArrayList;
import java.util.Scanner;

import bowling.model.Frame;
import bowling.print.InputView;
import bowling.print.ResultView;

public class BowlingGame {

//테스트용
/*	
	public void setThrowedPins(List<Integer> throwedPins) {
		this.throwedPins = throwedPins;
	}
	public void setMarks(List<String> status) {
		this.marks = status;
	}
*/
	public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		InputView input = new InputView(new Scanner(System.in));
		ResultView print = new ResultView();
		game.play(input, print);
		input.endConsole();
	}
	
	public void play(InputView input, ResultView print) {
		String name = input.getName();
		Frame frame = new Frame();
		print.status(new ArrayList<String>(), name);
		while(frame.hasNext()) {
			print.status(frame.play(input.getThrowedPin(frame.getFrameNo())), name);
		}
	}
	

}