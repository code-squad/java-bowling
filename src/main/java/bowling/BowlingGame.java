package bowling;

import java.util.ArrayList;
import java.util.Scanner;

import bowling.model.Frame;
import bowling.print.InputView;
import bowling.print.ResultView;

public class BowlingGame {

	String name;

//테스트용
/*	
	public void setThrowedPins(List<Integer> throwedPins) {
		this.throwedPins = throwedPins;
	}
	public void setMarks(List<String> marks) {
		this.marks = marks;
	}
*/
	public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		InputView input = new InputView(new Scanner(System.in));
		ResultView print = new ResultView();
		game.name = input.getName();
		game.play(input, print);
		input.endConsole();
	}
	
	public void play(InputView input, ResultView print) {
		Frame frame = new Frame();
		print.throwedPin(new ArrayList<String>(), name);
		while (frame.getFrameNum() < 10) {
			print.throwedPin(frame.normal(input.getThrowedPin(frame.getFrameNum())), name);
		}
		while(frame.hasNext()) {
			print.throwedPin(frame.ten(input.getThrowedPin(frame.getFrameNum())), name);
		}
	}
	

}