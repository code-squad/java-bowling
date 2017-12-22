package bowling;


public class ResultView {

	public static void printScore(String score) {
		printFormat();
		System.out.print("|" + "\t" + "NAME" + "\t" + "|");
		System.out.print(score + "\t");
	}

	public static String basicPrint() {
		return "";
	}

	private static void printFormat() {
		System.out.print("|" + "\t" + "NAME" + "\t" + "|");
		for (int i = 0; i < 10; i++) {
			System.out.print("\t" + (i + 1) + "\t" + "|");
		}
		System.out.println();
	}

}
