package madrabbit.ui;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import game.core.Game;
import game.core.Piece;
import game.core.PieceColor;
import game.ui.GreenBoard;
import madrabbit.ui.images.MadRabbitImages;

public class MadRabbitBoardPanel extends GreenBoard {
    public MadRabbitBoardPanel(Composite composite, Game game) {
        super(composite, game.board);
    }

    @Override
    public Image getPieceImage(Piece piece, PieceColor color) {
        return color == PieceColor.WHITE ? MadRabbitImages.rabbitImage : MadRabbitImages.wolfImage;
    }
}
