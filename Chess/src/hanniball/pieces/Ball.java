package hanniball.pieces;

import game.core.Move;
import game.core.Piece;
import game.core.PieceColor;
import game.core.Square;
import hanniball.moves.SimpleMove;

public class Ball extends Piece {
	public Ball(Square square) {
		super(square, PieceColor.RED);
	}

	@Override
	public boolean isCorrectMove(Square... squares) {
		return true;
	}

	@Override
	public Move makeMove(Square... squares) {
		return new SimpleMove(squares);
	}
}
