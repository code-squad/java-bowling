package bowling.view;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BowlingFormView {
	private static final Logger log = LoggerFactory.getLogger(BowlingFormView.class);

	private static Scanner scanner = new Scanner(System.in);

	public static String inputName() {
		log.debug("플레이어의 이름을 입력하세요. (' ' 또는 ','으로 구분) : ");
		return scanner.nextLine();
	}

	public static int bowling(String user) {
		log.debug("{}'의 점수를 입력하세요 : ", user);
		return Integer.parseInt(scanner.nextLine());
	}

}
