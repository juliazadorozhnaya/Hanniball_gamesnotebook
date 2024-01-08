package madrabbit;

import game.core.Game;
import game.core.PieceColor;
import game.players.IPlayer;
import game.players.Neznaika;
import madrabbit.pieces.Rabbit;
import madrabbit.pieces.Wolf;
import madrabbit.players.RabbitPlayer;
import madrabbit.players.WolfPlayer;

/**
 * TODO Задорожная
 * 
 * <a href="https://ludii.games/details.php?keyword=Cercar%20La%20Liebre">Бешеный кролик</a>
 */
public class MadRabbit extends Game {
	private static final int BOARD_SIZE = 5;

	static {
		Game.addPlayer(MadRabbit.class, IPlayer.HOMO_SAPIENCE);
		Game.addPlayer(MadRabbit.class, new Neznaika());
		Game.addPlayer(MadRabbit.class, new WolfPlayer());
		Game.addPlayer(MadRabbit.class, new RabbitPlayer());
	}

	public MadRabbit() {
		initBoardDefault();

		board.setWhitePlayer(new WolfPlayer());
		board.setBlackPlayer(new RabbitPlayer());
	}

	@Override
	public void initBoardDefault() {
		super.initBoard(BOARD_SIZE, BOARD_SIZE);

		new Rabbit(board.getSquare(2, 2), PieceColor.WHITE);

		new Wolf(board.getSquare(0, 2), PieceColor.BLACK);
		new Wolf(board.getSquare(BOARD_SIZE-1, 2), PieceColor.BLACK);
		
		for (int h = 0; h < 2; h++)
			for (int v = 0; v < BOARD_SIZE; v++)
				new Wolf(board.getSquare(v, BOARD_SIZE-h-1), PieceColor.BLACK);
	}
}
