package bowling;

public class Player {
	private String name;

	public Player(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return  (name != null ? name : "");
	}

	
	public String getPlayerName(){
		return this.name;
	}

	
	

}
