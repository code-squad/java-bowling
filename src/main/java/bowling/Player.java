package bowling;

public class Player {
	private String name;

	@Override
	public String toString() {
		return  (name != null ? name : "");
	}

	public Player(String name) {
		this.name = name;
	}
	
	public String getPlayerName(){
		return this.name;
	}

	
	

}
