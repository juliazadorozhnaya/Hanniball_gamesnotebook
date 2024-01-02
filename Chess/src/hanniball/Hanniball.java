package hanniball;

import static hanniball.HanniballBoard.centerH;
import static hanniball.HanniballBoard.centerV;
import static hanniball.HanniballBoard.sizeH;
import static hanniball.HanniballBoard.sizeV;

import game.core.Game;
import game.core.PieceColor;
import game.players.IPlayer;
import game.players.Neznaika;
import hanniball.pieces.*;
import hanniball.players.Hannibaal;
import hanniball.players.Varro;

/**
 * <a href="https://www.iggamecenter.com/ru/rules/hanniball">Hanniball</a>
 */
public class Hanniball extends Game {
	static {
		addPlayer(Hanniball.class, IPlayer.HOMO_SAPIENCE);
		addPlayer(Hanniball.class, new Neznaika());
		addPlayer(Hanniball.class, new Hannibaal());
		addPlayer(Hanniball.class, new Varro());
	}

	/**
	 * Расстановка фигур в начальную позицию.
	 */
	public Hanniball() {
		super(new HanniballBoard());

		initBoardDefault();

		board.setWhitePlayer(IPlayer.HOMO_SAPIENCE);
		board.setBlackPlayer(new Neznaika());
	}

	@Override
	public void initBoardDefault() {
		super.initBoard(sizeV, sizeH);

		new Ball(board.getSquare(centerV, centerH));

		setPieces(PieceColor.WHITE);
		setPieces(PieceColor.BLACK);
	}

	private void setPieces(PieceColor color) {
		int d = (color == PieceColor.WHITE) ? -1 : 1;
		int baseH = (color == PieceColor.WHITE) ? sizeH - 1 : 0;

		new King(board.getSquare(centerV, baseH), color);

		new Rook(board.getSquare(2, baseH + d), color);
		new Rook(board.getSquare(sizeV-3, baseH + d), color);

		new Bishop(board.getSquare(7, 2), PieceColor.BLACK);
		new Bishop(board.getSquare(5, 2), PieceColor.BLACK);
		new Bishop(board.getSquare(3, 2), PieceColor.BLACK);
		new Bishop(board.getSquare(1, 2), PieceColor.BLACK);

		new Knight(board.getSquare(7, 3), PieceColor.BLACK);
		new Knight(board.getSquare(5, 3), PieceColor.BLACK);
		new Knight(board.getSquare(3, 3), PieceColor.BLACK);
		new Knight(board.getSquare(1, 3), PieceColor.BLACK);

		new Bishop(board.getSquare(7, 12), PieceColor.WHITE);
		new Bishop(board.getSquare(5, 12), PieceColor.WHITE);
		new Bishop(board.getSquare(3, 12), PieceColor.WHITE);
		new Bishop(board.getSquare(1, 12), PieceColor.WHITE);

		new Knight(board.getSquare(7, 11), PieceColor.WHITE);
		new Knight(board.getSquare(5, 11), PieceColor.WHITE);
		new Knight(board.getSquare(3, 11), PieceColor.WHITE);
		new Knight(board.getSquare(1, 11), PieceColor.WHITE);

	}
}
