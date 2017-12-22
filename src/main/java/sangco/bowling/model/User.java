package sangco.bowling.model;

public class User {
	private String userName;
	private Board board = new Board();

	public User(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}

	public Board getBoard() {
		return board;
	}
}
