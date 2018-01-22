package controller;

import model.frame.Frame;
import model.frame.NormalFrame;
import view.ConsoleView;

public class GameManager {
    private Frame frame;
    private String name;

    public GameManager() {
        frame = new NormalFrame(1);
    }


    public void run() {
        this.name = ConsoleView.askName();
        Frame head = this.frame;
        int round = 1;
        while(head != null) {
            head.bowl(ConsoleView.inputBowl(round));
            ConsoleView.printScoreBoard(name, frame);
            if (head.isFinished()) {
                head = head.getNextFrame();
                round ++;
            }
        }

    }
}
