package controller;

import model.frame.Frame;
import model.frame.NormalFrame;

public class GameManager {
    private Frame frame;

    public GameManager() {
        frame = new NormalFrame(1);
    }
}
