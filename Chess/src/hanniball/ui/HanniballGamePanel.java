package hanniball.ui;

import org.eclipse.swt.widgets.Composite;

import game.ui.GamePanel;
import hanniball.Hanniball;

public class HanniballGamePanel extends GamePanel {
	public HanniballGamePanel(Composite parent) {
		super(parent, new  Hanniball());

		HanniballBoardPanel gameBoard = new HanniballBoardPanel(this, game);
		insertSquares(gameBoard);
	}
}
