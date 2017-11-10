package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import exception.InvalidPlayerNameException;

public class Player {
	private String name;

	public Player(String name) throws InvalidPlayerNameException {
		this.name = Optional.of(name).filter(e -> name.length() == 3 && Pattern.matches("^[a-zA-Z]*$", name))
				.orElseThrow(() -> new InvalidPlayerNameException("플레이어 이름이 잘 못 입력되었습니다."));
	}

	public String getName() {
		return name;
	}
}
