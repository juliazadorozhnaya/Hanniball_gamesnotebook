package hanniball;

import game.core.Board;
import game.core.PieceColor;

public class HanniballBoard extends Board {
	public static final int sizeV = 9;
	public static final int sizeH = 15;
	public static final int centerV = sizeV / 2;
	public static final int centerH = sizeH / 2;

	static public boolean isWall(Board board, int v, int h) {
		int nV = board.nV / 2 - 1;

		if ((h == 0) || (h == board.nH - 1))
			return v < nV || v >= nV + 3;

		return false;
	}

	static public boolean isGoal(PieceColor color, Board board, int v, int h) {
		int baseH = (color == PieceColor.WHITE) ? sizeH - 1 : 0;
		int nV = board.nV / 2 - 1;

		if (h == baseH)
			return (nV <= v) || v <= nV + 2;

		return false;
	}

	static public boolean isGoal(Board board, int v, int h) {
		return isGoal(PieceColor.WHITE, board, v, h) || isGoal(PieceColor.BLACK, board, v, h);
	}
}
