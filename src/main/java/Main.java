

public class Main {
	public static void main(String[] args) {
		
		String name = Input.getName();
		Player player = new Player(name);
		
		while (!player.isFinished()) {
			int pinsPerTry = Input.getPinsPerTry();
			player.play(pinsPerTry);
			View.showResult(player);
		}
		
		try {
			Input.getName();
			Input.getPinsPerTry();
		} catch (InputException e){
			String message = e.getMessage();
			System.out.println(message);
			e.printStackTrace();
		}
	}
}
