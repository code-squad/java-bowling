package model;

import java.util.Optional;

import Exception.FrameScoreException;

public class NomalFrame extends Frame{

	public NomalFrame() {
		super();
	}

	// optional 사용
	public void shot(int score) throws FrameScoreException {
		Optional<Integer> scoreOptional = Optional.ofNullable(score);
		frameScore.add(scoreOptional.filter(e -> totalScore() + score <= 10 && frameScore.size() < 2)
				.orElseThrow(() -> new FrameScoreException("불가능한 점수 입니다.")));
	}

	// if문 사용
	public void shot2_if(Integer score) throws FrameScoreException {
		if (!isGetScore(score)) {
			throw new FrameScoreException("불가능한 점수 입니다.");
		}
		frameScore.add(score);
	}

	protected boolean isGetScore(Integer score) {
		return score != null && totalScore() + score <= 10 && frameScore.size() < 2;
	}
}
