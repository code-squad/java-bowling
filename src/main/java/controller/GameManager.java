package controller;

import model.Frame;
import model.NormalFrame;

public class GameManager {
    private Frame frame;

    public GameManager() {
        frame = new NormalFrame(1);
    }
}
