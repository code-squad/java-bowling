package view;

import java.util.List;

import model.Frame;

public class ResultView {

	public static void printBlank(String usrId) {
		printFirstLine();
		printSecondBlankLine(usrId);
	}

	private static void printFirstLine() {
		System.out.print("|  NAME  |");
		for(int i=1; i < 11; i++) {
			System.out.print("  0" + i + "  |");
		}
		System.out.println("\n");
	}

	private static void printSecondBlankLine(String usrId) {
		System.out.print("|  " + usrId + "   |");
		for(int i=1; i < 11; i++) {
			System.out.print("      |");
		}
		System.out.println("\n");
	}
	
	public static void printGame(int frameNum, int falledPin, String usrId, List<String> scores) {
		printFirstLine();
		printSecondLine(usrId, scores);
	}
	private static void printSecondLine(String usrId, List<String> scores) {
		System.out.print("|   " + usrId + "  |");
		for(String score : scores) {
			System.out.print("   " + score + "   |");
		}
		for(int i=scores.size()+1; i < 11; i++) {
				System.out.print("      |");
		}
		System.out.println("\n");
	}

}
