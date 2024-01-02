package hanniball.pieces;

import chess.moves.Capture;
import chess.moves.SimpleMove;
import game.core.Move;
import game.core.PieceColor;
import game.core.Square;

public class Rook extends HanniballPiece {
	public Rook(Square square, PieceColor color) {
		super(square, color);
	}

	public Rook() {
	}

	private boolean isKnightMove(Square current, Square target) {
		int dx = Math.abs(current.v - target.v);
		int dy = Math.abs(current.h - target.h);
		return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
	}

	@Override
	public boolean isCorrectMove(Square... squares) {
		if (!super.isCorrectMove(squares))
			return false;

		Square target = squares[0];

		if (square.isEmptyVertical(target))
			return true;

		if (square.isEmptyHorizontal(target))
			return true;

		return false;
	}

	@Override
	public Move makeMove(Square... squares) {
		Square target = squares[1];

		if (!target.isEmpty())
			return new Capture(squares);

		return new SimpleMove(squares);
	}

	@Override
	public String toString() {
		return "R";
	}
}
