package hanniball.players;

import game.core.Move;

public class Hannibaal extends HanniballPlayer {
    @Override
    public String getName() {
        return "Hannibaal";
    }

    @Override
    public String getAuthorName() {
        return "Зайдуллин Ризван";
    }

    @Override
    protected int getWeight(Move m) {
        return 0;
    }
}
