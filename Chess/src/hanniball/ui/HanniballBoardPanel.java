package hanniball.ui;

import static hanniball.HanniballBoard.isGoal;
import static hanniball.HanniballBoard.isWall;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import chess.ui.images.ChessImages;
import game.core.Game;
import game.core.Piece;
import game.core.PieceColor;
import game.ui.GreenBoard;
import game.ui.listeners.MovePieceListener;
import hanniball.pieces.Ball;
import hanniball.pieces.Bishop;
import hanniball.pieces.King;
import hanniball.pieces.Knight;
import hanniball.pieces.Rook;
import hanniball.ui.images.HanniballImages;

public class HanniballBoardPanel extends GreenBoard {
	protected static final Color GOAL_COLOR = new Color(null, 0, 255, 0);

	public HanniballBoardPanel(Composite composite, Game game) {
		super(composite, game.board);

		listener = new MovePieceListener(this);
	}

	private static final Map<PieceColor, Map<Class<? extends Piece>, Image>> pieceImages;

	static {
		Map<Class<? extends Piece>, Image> whites = new HashMap<>();
		Map<Class<? extends Piece>, Image> blacks = new HashMap<>();

		pieceImages = new HashMap<>();
		pieceImages.put(PieceColor.WHITE, whites);
		pieceImages.put(PieceColor.BLACK, blacks);

		// Инициализируем карту изображений белых фигур.
		//
		whites.put(Rook.class, ChessImages.imageRookWhite);
		whites.put(Knight.class, ChessImages.imageKnightWhite);
		whites.put(Bishop.class, ChessImages.imageBishopWhite);
		whites.put(King.class, ChessImages.imageKingWhite);

		// Инициализируем карту изображений черных фигур.
		//
		blacks.put(Rook.class, ChessImages.imageRookBlack);
		blacks.put(Knight.class, ChessImages.imageKnightBlack);
		blacks.put(Bishop.class, ChessImages.imageBishopBlack);
		blacks.put(King.class, ChessImages.imageKingBlack);
	}

	public Image getPieceImage(Piece piece, PieceColor color) {
		if (piece instanceof Ball)
			return HanniballImages.imageBall;
		
		return pieceImages.get(color).get(piece.getClass());
	}

	public void drawSquare(GC gc, int v, int h, int squareWidth, int squareHeight) {
		if (isWall(board, v, h))
			return;

		if (isGoal(board, v, h)) {
			gc.setBackground(GOAL_COLOR);
			gc.fillRectangle(v * squareWidth, h * squareHeight, squareWidth, squareHeight);

			gc.setForeground(LINE_COLOR);
			gc.drawRectangle(v * squareWidth, h * squareHeight, squareWidth, squareHeight);
			return;
		}

		super.drawSquare(gc, v, h, squareWidth, squareHeight);
	}
}
