package controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import dto.InputValue;
import model.Bowling;
import model.Frame;
import model.Score;
import view.InputView;
import view.ResultView;

public class Main {
	
	public static void main(String[] args) {
		InputValue iv = InputView.getUserId();
		String usrId = iv.getUsrId();
		ResultView.printBlank(usrId);
		Bowling bowling = new Bowling();
		
		do {
			iv = InputView.getFalledPin(bowling.getFrames().size()+1);
			List<Frame> frames = bowling.roll(iv.getFalledPin());
			// List<Frame> to List<String>
			List<String> scores = frames.stream().map(s -> s.getScore().getResult()).collect(Collectors.toList());
			ResultView.printGame(frames.size(), iv.getFalledPin(), usrId, scores);
		} while(bowling.getFrames().size() < 11);
	}
}	
	


