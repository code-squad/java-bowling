
public class View {
	
	private static final String name = "| name |";
	private String fullframe;

	public static void view(View view, Player player) {
		System.out.println(view.getFullFrame());
		System.out.print("|  " + player.getName() + " |");
		for (Score score : player.getScores()) {
			for (String stringScore : score.getScore()) {
				System.out.print(stringScore);
			}
		}
		System.out.println("\n");
	}
	
	View (String fullframe) {
		this.fullframe = fullframe;
	}
	
	String getFullFrame() {
		return this.fullframe;
	}
	
	static String makeFullFrame() {
		String eachFrame = name;
		for (int i = 1; i <= 10; i++) {
			if (i == 10) {
				eachFrame += "  " + Integer.toString(i) + "  |";
				break;
			}
			eachFrame += "  0" + Integer.toString(i) + "  |";
		}
		return eachFrame;
	}
}


