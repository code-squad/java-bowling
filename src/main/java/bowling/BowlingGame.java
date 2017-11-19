package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingGame {
	int ballNum = 1;
	int frameNum = 1;
	List<Integer> throwedPins = new ArrayList<>();
	List<String> marks = new ArrayList<>();
	String name;
	boolean hasNext = true;
//테스트용
	public void setThrowedPins(List<Integer> throwedPins) {
		this.throwedPins = throwedPins;
	}
//테스트용
	public void setMarks(List<String> marks) {
		this.marks = marks;
	}

	public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		Scanner sc = new Scanner(System.in);
		System.out.print("플레이어 이름은?(3 english letters)?");
		game.name = sc.next();
		game.printFrame();
		game.printName();
		game.printBlank(10);
		game.play(sc);
		sc.close();
	}
	
	public void play(Scanner sc) {
		while (frameNum < 10) {
			System.out.printf("\n%1d프레임 투구 : ", frameNum);
			printThrowedPin(normalFrame(sc.nextInt()));
		}
		while(hasNext) {
			System.out.print("\n10프레임 투구 : ");
			printThrowedPin(tenFrame(sc.nextInt()));
		}
	}
	
	public List<String> normalFrame(int pin) {
		if (ballNum == 1) {
			return normalFrameOneBall(pin);
		}
		return normalFrameTwoBall(pin);
	}
	
	public List<String> tenFrame(int pin) {
		if (ballNum == 1) {
			return tenFrameOneBall(pin);
		} 
		if (ballNum == 2) {
			return tenFrameTwoBall(pin);
		} 
		tenFrameThreeBall(pin);
		return marks;
	}
	
	public List<String> normalFrameOneBall(int pin) {
		if (pin == 10) {
			addFrame();
			return strike(pin);
		} 
		addBallNum();
		marks.add(makeMark(Integer.toString(pin)));
		throwedPins.add(pin);
		return marks;
	}
	
	public List<String> tenFrameOneBall(int pin) {
		addBallNum();
		if (pin == 10) {
			return strike(pin);
		} 
		marks.add(makeMark(Integer.toString(pin)));
		throwedPins.add(pin);
		return marks;
	}
	
	public List<String> normalFrameTwoBall(int pin) {
		addFrame();
		subtractBallNum();
		int lastNum = throwedPins.get(throwedPins.size() - 1);
		int marksSize = marks.size() - 1;
		throwedPins.add(pin);//위에다 두면 lastNum이 pin값이 됨..
		if (lastNum + pin == 10) {
			marks.set(marksSize, makeSpare(marksSize));
			return marks;
		}
		marks.set(marksSize, makeMiss(pin, marksSize));
		return marks;
	}
	
	public List<String> tenFrameTwoBall(int pin) {
		addBallNum();
		int marksSize = marks.size() -1;
		int lastNum = throwedPins.get(throwedPins.size() - 1);
		throwedPins.add(pin);
		if("X".equals(marks.get(marksSize))) {
			if (pin == 10) {
				marks.set(marksSize, marks.get(marksSize) + "|X");
				return marks;
			}
			marks.set(marksSize, makeMiss(pin, marksSize));
			return marks;
		}
		if (lastNum + pin < 10) {
			quit();
			marks.set(marksSize, makeMiss(pin, marksSize));
		} else if (lastNum + pin == 10) {
			marks.set(marksSize, makeSpare(marksSize));
		}
		return marks;
	}
	
	public List<String> tenFrameThreeBall(int pin) {
		quit();
		int marksSize = marks.size() -1;
		int lastNum = throwedPins.get(throwedPins.size() - 1);
		throwedPins.add(pin);
		if (pin == 10) {
			marks.set(marksSize, marks.get(marksSize) + "|X");
			return marks;
		}
		//전전이 X면
		if("X".equals(marks.get(marksSize).substring(0,1))) {
			if (lastNum + pin < 10) {
				marks.set(marksSize, makeMiss(pin, marksSize));
			} else if (lastNum + pin == 10) {
				marks.set(marksSize, makeSpare(marksSize));
			}
			return marks;
		}
		marks.set(marksSize, makeMiss(pin, marksSize));
		return marks;
	}
	
	public void quit() {
		hasNext = false;
	}

	public List<String> strike(int pin) {
		throwedPins.add(pin);
		throwedPins.add(0);
		marks.add("X");
		return marks;
	}

	public String makeSpare(int marksSize) {
		return marks.get(marksSize) + "|/";
	}
	
	public String makeMiss(int pin, int marksSize) {
		return marks.get(marksSize) + "|" + makeMark(Integer.toString(pin));
	}

	public void addFrame() {
		frameNum++;
	}

	public void addBallNum() {
		ballNum++;
	}

	public void subtractBallNum() {
		ballNum--;
	}

	public String makeMark(String pin) {
		if ("0".equals(pin)) {
			return "-";
		}
		return pin;
	}

	public void printBlank(int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%5s|", "");
		}
	}

	public void printName() {
		System.out.printf("\n| %4s |", name);
	}

	public void printThrowedPin(List<String> throwedPins) {
		printFrame();
		printName();
		for (int j = 0; j < throwedPins.size(); j++) {
			System.out.printf("%-5s|", throwedPins.get(j));
		}
		printBlank(10 - throwedPins.size());
	}

	public void printFrame() {
		System.out.printf("| %4s |", "NAME");
		for (int i = 1; i < 11; i++) {
			System.out.printf(" %02d  ", i);
			System.out.print("|");
		}
	}
}