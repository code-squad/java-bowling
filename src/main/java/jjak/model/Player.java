package jjak.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	public List<Frame> frames;

	public Player(String name) {
		this.name = name;
		this.frames = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setScore(int score) {
		
	}

}
