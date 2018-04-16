package game;

import input.Input;

public class Game {
    public void match() {
        Frames frames = new Frames();
        Input input = new Input();
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "번 프레임");
            int num = input.inputNum(1);
            if (frames.onFrame(num)) {
                System.out.println("다음프레임으로");
            }
            int secondNum = input.inputNum(2);
            frames.onFrame(secondNum);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.match();
    }
}
