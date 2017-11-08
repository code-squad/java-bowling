package model;

import java.util.Optional;
import java.util.regex.Pattern;

import Exception.PlayerNameException;

public class Player {
	private String name;

	public Player(String name) throws PlayerNameException {
		this.name = Optional.of(name)
				.filter(e -> name.length() == 3 && Pattern.matches("^[a-zA-Z]*$", name))
				.orElseThrow(() -> new PlayerNameException("플레이어 이름이 잘 못 입력되었습니다."));
	}

	public String getName() {
		return name;
	}
}
