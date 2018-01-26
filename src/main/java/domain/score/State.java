package domain.score;

import java.util.Optional;

public interface State {

    State bowl(Pin pin);

    int getFirstScore();

    Optional<Integer> getTotalScore();
}
