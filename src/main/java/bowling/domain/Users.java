package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private List<User> users;

	public Users() {
		this.users = new ArrayList<>();
	}

	public static Users of() {
		return new Users();
	}

	public void addUser(User user) {
		users.add(user);
	}

	public int size() {
		return users.size();
	}

	public String getName(int i) {
		return users.get(i).getName();
	}

	public void addScore(int i, int inputScore) {
		users.get(i).addScore(inputScore);
	}

	public Game getGame(int i) {
		return users.get(i).getGame();
	}

	public Pin getOneBall(int i) {
		return users.get(i).getOneBall();
	}

	public User getUser(int i) {
		return users.get(i);
	}

}
