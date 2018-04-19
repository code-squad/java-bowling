package bowling.domain;

public class User {
	private String name;
	private Game game;

	public User(String name) {
		this.name = name;
		game = Game.of();
	}

	public static User of(String name) {
		return new User(name);
	}

	public String getName() {
		return name;
	}

	public Game getGame() {
		return game;
	}

	public void addScore(int inputScore) {
		game.addScore(inputScore);
	}

	public Pin getOneBall() {
		return game.getOneBall();
	}

	public int size() {
		return game.size();
	}

	public Score getScore(int i) {
		return game.getScore(i);
	}

	public int getTotalScore(int i) {
		return getScore(i).getScore();
	}

	public boolean canCalculateScore(int i) {
		return getScore(i).canCalculateScore();
	}

}
