package chess.pieces;

import game.core.Piece;
import game.core.PieceColor;
import game.core.Square;

/**
 * Базовый класс для всех шахматных фигур.
 * 
 * @author <a href="mailto:vladimir.romanov@gmail.com">Romanov V.Y.</a>
 */
abstract
public class ChessPiece extends Piece {
	public ChessPiece(Square square, PieceColor color) {
		super(square, color);
	}

    public ChessPiece() {
        super();
    }

    @Override
	public boolean isCorrectMove(Square... squares) {
		Square target = squares[0];
		
		if (target.isEmpty()) 
			return true;

		return getColor() != target.getPiece().getColor();
	}
}
