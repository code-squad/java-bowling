
public class View {

	public static void view(Frame frame, Player player) {
		System.out.println(frame.frame);
		System.out.print("|  " + player.name + " |");
		for (Score score : player.scores) {
			for (String stringScore : score.score) {
				System.out.print(stringScore);
			}
		}
		System.out.println("\n");
	}
}


