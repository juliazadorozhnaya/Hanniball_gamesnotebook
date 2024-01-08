package madrabbit.ui;

import org.eclipse.swt.widgets.Composite;

import game.ui.GamePanel;
import madrabbit.MadRabbit;

public class MadRabbitGamePanel extends GamePanel {

    public MadRabbitGamePanel(Composite parent) {
        super(parent, new MadRabbit());

        MadRabbitBoardPanel gameBoard = new MadRabbitBoardPanel(this, game);
        insertSquares(gameBoard);
    }
}
