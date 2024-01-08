package madrabbit.players;

import game.core.*;
import game.core.moves.ICaptureMove;
import madrabbit.moves.Capture;

/**
 * TODO Задорожная
 */
public class RabbitPlayer extends WolfRabbitPlayer {

    private static final int BOARD_SIZE = 5;
    @Override
    public String getName() {
        return "Кролик";
    }

    @Override
    public String getAuthorName() {
        return "Задорожная";
    }

    @Override
    int getWeight(Move m) {

        int weight = 0;

        if (m instanceof ICaptureMove) {
            ICaptureMove captureMove = (ICaptureMove) m;
            int capturedCount = captureMove.getCaptured().size();
            weight += capturedCount * 10;
        }

        if (m instanceof Capture) {
            Square source = ((Capture) m).getSource();
            Square target = ((Capture) m).getTarget();
            Board board = target.getBoard();

            if (!isCornerSquare(source, board)) {
                weight += calculateManhattanDistance(source, target) / 2;
            }
            if (isCornerSquare(source, board)) {
                weight -= 20;
            }
            if (isCornerSquare(target, board)) {
                weight += 20;
            }
        }

        Piece piece = m.getPiece();
        int wolves = piece.getEnemies().size();

        try {
            m.doMove();
            // Подсчет свободных направлений для движения после хода.
            int freeDirections = calculateFreeDirections(m.getPiece().square);
//            int wolves_1 = piece.getEnemies().size();
//            if (wolves_1 < 9) {
//                throw new GameOver(GameResult.BLACK_WIN);
//            }
            weight += freeDirections * 10;
        } catch (GameOver e) {
            // Проверка условия победы (если после хода остается менее 9 волков).
            if (wolves < 9) {
                weight += 1000000; // Большое число для выигрышного хода.
            }
        } finally {
            // Важно отменить ход, чтобы не изменять состояние игры.
            m.undoMove();
        }

        return weight;
    }

    private boolean isCornerSquare(Square square, Board board) {
        int h = square.h;
        int v = square.v;
        int nH = board.nH;
        int nV = board.nV;
        return (h == 0 || h == nH - 1) && (v == 0 || v == nV - 1);
    }

    private int calculateManhattanDistance(Square source, Square target) {
        return Math.abs(source.h - target.h) + Math.abs(source.v - target.v);
    }

    private int calculateFreeDirections(Square square) {
        int freeDirections = 0;
        int x = square.h;
        int y = square.v;

        // Смещения для проверки 8 направлений: верх, низ, лево, право, и 4 диагонали.
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Проверяем, свободна ли клетка для перемещения.
            if (isValidAndFree(newX, newY)) {
                freeDirections++;
            }
        }

        return freeDirections;
    }

    // Проверяет, находится ли клетка в пределах доски и свободна ли она.
    private boolean isValidAndFree(int x, int y) {
        // Проверяем, находится ли клетка в пределах доски.
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

}
