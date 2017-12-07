
public class View {

	public static void view(Frame frame, Player player) {
		System.out.println(frame.getFrame());
		System.out.print("|  " + player.getName() + " |");
		for (Score score : player.getScores()) {
			for (String stringScore : score.getScore()) {
				System.out.print(stringScore);
			}
		}
		System.out.println("\n");
	}
}


