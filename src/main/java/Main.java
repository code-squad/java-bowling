import controller.GameManager;
import model.frame.Frame;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
