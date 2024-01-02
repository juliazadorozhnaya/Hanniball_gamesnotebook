package hanniball.pieces;

import chess.moves.SimpleMove;
import game.core.Move;
import game.core.PieceColor;
import game.core.Square;

/**
 * Класс представляет коня.
 * 
 * @author <a href="mailto:vladimir.romanov@gmail.com">Romanov V.Y.</a>
 */
public class Knight extends HanniballPiece {
	public Knight(Square square, PieceColor color) {
		super(square, color);
	}

	public Knight() {
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
		return "N";
	}
}
