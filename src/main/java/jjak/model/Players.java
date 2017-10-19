package jjak.model;

import java.util.ArrayList;
import java.util.List;

public class Players {

	public List<Player> list;

	public Players() {
		list = new ArrayList<Player>();
	}

	public void addPlayer(String name) {
		list.add(new Player(name));
	}

}
