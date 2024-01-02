package hanniball.players;

import game.core.Move;

public class Varro extends HanniballPlayer {
    @Override
    public String getName() {
        return "Gaius Varrō";
    }

    @Override
    public String getAuthorName() {
        return "Задорожная Юлия";
    }

    @Override
    protected int getWeight(Move m) {
        return 0;
    }
}
