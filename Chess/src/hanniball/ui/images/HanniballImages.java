package hanniball.ui.images;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import chess.ui.images.ChessImages;

/**
 * Изображения для игры в Hanniball.
 * 
 * @author <a href="mailto:vladimir.romanov@gmail.com">Romanov V.Y.</a>
 */
public class HanniballImages {
	public static Image iconHanniball;
	public static Image imageBall;

	public static Image imageKingWhite;
	public static Image imageBishopWhite;
	public static Image imageKnightWhite;
	public static Image imageRookWhite;

	public static Image imageKingBlack;
	public static Image imageBishopBlack;
	public static Image imageKnightBlack;
	public static Image imageRookBlack;


	static {
		load(Display.getCurrent());
	}

	private static void load(final Display display) {
		iconHanniball = new Image(display, HanniballImages.class.getResourceAsStream("ball.png"));
		imageBall = new Image(display, HanniballImages.class.getResourceAsStream("ball.png"));

		imageKingBlack   = new Image(display, ChessImages.class.getResourceAsStream("bKingZurich.gif"));
		imageBishopBlack = new Image(display, ChessImages.class.getResourceAsStream("bBishopZurich.gif"));
		imageKnightBlack = new Image(display, ChessImages.class.getResourceAsStream("bKnightZurich.gif"));
		imageRookBlack   = new Image(display, ChessImages.class.getResourceAsStream("bRookZurich.gif"));

		imageKingWhite   = new Image(display, ChessImages.class.getResourceAsStream("wKingZurich.gif"));
		imageBishopWhite = new Image(display, ChessImages.class.getResourceAsStream("wBishopZurich.gif"));
		imageKnightWhite = new Image(display, ChessImages.class.getResourceAsStream("wKnightZurich.gif"));
		imageRookWhite   = new Image(display, ChessImages.class.getResourceAsStream("wRookZurich.gif"));
	}
}
