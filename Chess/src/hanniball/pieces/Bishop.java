package hanniball.pieces;

import game.core.Move;
import game.core.PieceColor;
import game.core.Square;
import hanniball.moves.SimpleMove;

/**
 * Класс представляет слона.
 * 
 * @author <a href="mailto:vladimir.romanov@gmail.com">Romanov V.Y.</a>
 */
public class Bishop extends HanniballPiece {
	public Bishop(Square square, PieceColor color) {
		super(square, color);
	}

    public Bishop() {
    }

    @Override
	public boolean isCorrectMove(Square... squares) {
		return true;
	}
	
	@Override
	public Move makeMove(Square... squares) {
		return new SimpleMove(squares);
	}
	
	@Override
	public String toString() {
		return "B";
	}
}
